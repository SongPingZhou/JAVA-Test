<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.3/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.3/themes/icon.css">   
<script type="text/javascript" src="jquery-easyui-1.4.3/jquery.min.js"></script>   
<script type="text/javascript" src="jquery-easyui-1.4.3/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jquery-easyui-1.4.3/datagrid_excel.js"></script>
<script type="text/javascript">
	$(function(){
		seachselect();
	})
	function seachselect(){
		$("#dg").datagrid({
			url:'selectStu',
			method:'post',
			fitColumns:true,
			singleSelect:true,
			checkbox:true,
			pagination:true,
			striped:true,
			toolbar:"#toolbar",
			queryParams:{
					  stu_name:$("#stu_name").textbox("getValue"),
					  address:$("#address").textbox("getValue"),
					  minBirth:$("#minBirth").datebox("getValue"),
					  maxBirth:$("#maxBirth").datebox("getValue"),
					  class_id:$("#classid").combobox("getValue")  
				}
		});
		/* 加载班级的下拉列表 */
		$('#classid').combobox({
		    url:'selectClas',  
		    valueField:'class_id',    
		    textField:'class_name'   
		});  
	}
	/* 显示连表的数据 */
	function formatterfunction(value,row,index){
		if(row.classes){
			return row.classes.class_name;
		}
	}
	/* classes.class_status=1显示已缴费别的显示未缴费 */
	/*   function formatterfunctiontest(value,row,index){
			return row.classes.class_status="1" ? "已缴费" : "未缴费";
	}  */ 
	/* 打开窗口dialog */
	function insertStudent(){
		/* 每次打开都清空form数据 */
		$("#insertform").form("clear");
		
		/* 显示提交按钮 */
		$("#tj").show();
		
		/* 对添加时赋值1表示执行添加 */
		$("#mark").val("1");
		
		/* 修改标题并打开 */
		$('#insertDialog').dialog({title:'添加学生'}).dialog('open');
	}
	
	/* 添加 */
	function add(){
		$.ajax({
			url:"insertStu",
			method:'post',
			data:$("#insertform").serializeArray(),
			success:function(res){
				$("#dg").datagrid("reload");
				$("#insertDialog").dialog("close");
				$.messager.alert("提示信息","添加成功");
			}
		},"json");
	}
	
	/* 修改 */
	function edit(){
		$.ajax({
			url:"updateStu",
			method:'post',
			data:$("#insertform").serializeArray(),
			success:function(res){
				$("#dg").datagrid("reload");
				$("#insertDialog").dialog("close");
				$.messager.alert("提示信息","修改成功");
			}
		},"json");
	}
	
	function deleteStu(index){
		var data=$("#dg").datagrid("getData");
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		        $.ajax({
		        	url:'deleteStu',
		        	method:'post',
		        	data:{stu_id:data.rows[index].stu_id},
		        	dataType:'json',
		        	success:function(res){
		        		if(res>0){
		        			$("#dg").datagrid("reload");
		        			$.messager.alert("提示信息","删除成功");
		        		}
		        	}
		        })
		    }
		}); 
	}
	
	/* 提交添加Student */
	function insertStu(){
		/* 判断使用那个方法提交 */
		$("#mark").val() == "1" ? add() : ($("#mark").val() == "2" ? edit() : null);
	}
	
	/* 格式化操作 */
	function formatterfunctioncaozuo(value,row,index){
		return "<a href='javascript:void(0)' onclick='selectStu("+index+")'>查看</a>"+
		       " <a href='javascript:void(0)' onclick='updateStu("+index+")'>修改</a>"+
		       " <a href='javascript:void(0)' onclick='deleteStu("+index+")'>删除</a>";
	}
	/* 打开窗口dialog */
	function updateStu(index){
		/* 每次打开都清空form数据 */
		$("#insertform").form("clear");
		
		/* 显示提交按钮 */
		$("#tj").show();
		
		/* 获取选择的表单数据 */
		var data = $("#dg").datagrid("getData");
		$("#insertform").form("load",data.rows[index]);
		
		/* 对表示input进行赋值，标识框主要用来在后面提交时判断url的 */
		$("#mark").val("2");
		/* 打开Dialog */
		$('#insertDialog').dialog({title:'修改学生'}).dialog('open');
	}
	
	function selectStu(index){
		var data = $("#dg").datagrid("getData");
		$.ajax({
			url:'selectStuById',
			method:'post',
			dataType:'json',
			data:{stu_id:data.rows[index].stu_id},
			success:function(res){
				if(res!=null){
					$("#insertform").form("clear");/* 先清空form */
					$("#tj").hide();/* 隐藏 提交、取消 按钮 */
					$("#insertform").form("load",res);/* 对form赋值 */
					$("#insertDialog").dialog({title:"查看学生信息"}).dialog("open");/* 打开dialog */
				}
				
			}
		})
	}
	/* 取消提交 */
	function clearStu(){
		$("#insertDialog").dialog("close");
	}
	function Save_Excel(){
		var data=$("#dg").datagrid("getData");
		var title=$("#dg").datagrid("getColumnFields");
		var d=title+"";
		$.ajax({
			url:'ExcelDc',
			method:'post',
			data:{stulist:JSON.stringify(data.rows),title:d},
			success:function(res){
				 $.messager.alert("提示信息","生成表格成功E：盘 查看");  
			}
		},"json")
	}
	
	function daochu(){
		var data=$("#dg").datagrid("getData");
		var title=$("#dg").datagrid("getColumnFields");
		var d=title+"";
		window.location.href="dochu?stulist="+JSON.stringify(data.rows)+"&title="+d;
	}
	var tt;
	function md(index){
		tt=index;
		$("#mdform").form("clear");
		index == "1" ? $("#qr").show() : $("#qr").hide();
		index == "2" ? $("#mdDialog").dialog({title:"登陆"}).dialog("open") : $("#mdDialog").dialog("open");
	}
	function dlmd(){
		var url= tt== "1" ? "insertUsers" : "seleceUsers";
		$.ajax({
			url:url,
			method:'post',
			dataType:'json',
			data:$("#mdform").serializeArray(),
			success:function(res){
				if(res.success){
					$("#mdDialog").dialog("close");
					$.messager.alert("提示信息",res.remark);
				}
			}
		})
	}
	
	$.extend($.fn.validatebox.defaults.rules, {    
	    equals: {    
	        validator: function(value,param){    
	            return value == $(param[0]).val();    
	        },    
	        message: 'Field do not match.'   
	    }    
	});  

</script>

</head>
<body>
	<table id="dg" class="easyui-datagrid">   
	    <thead>   
	        <tr>
	            <th data-options="field:'stu_id'">stu_id</th>   
	            <th data-options="field:'stu_name'">stu_name</th>   
	            <th data-options="field:'sex'">sex</th>
	            
	            
	            
	            <th data-options="field:'mtel'">mtel</th>
	            <th data-options="field:'qq'">qq</th>
	            <th data-options="field:'address'">address</th>   
	            <th data-options="field:'birthday'">birthday</th>   
	            <th data-options="field:'stu_status'">stu_status</th>   
	            <th data-options="field:'classes.class_name',formatter:formatterfunction">classes.class_name</th>   
	           <!--  <th data-options="field:'classes.class_status',formatter:formatterfunctiontest">classes.class_status</th> -->
	            <th data-options="field:'caozu',formatter:formatterfunctioncaozuo">操作</th> 
	        </tr>   
	    </thead>   
	</table>

	<!-- 工具条 -->
	<div id="toolbar">
		<form id="sousuo">
		<a id="btn" href="javascript:void(0)" onclick="md(1)" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">md5注册</a>
		<a id="btn" href="javascript:void(0)" onclick="md(2)" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">md5登陆</a>
		<a id="btn" href="javascript:void(0)" onclick="daochu()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">自选导出</a>
			<a id="btn" href="javascript:void(0)" onclick="Save_Excel()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">导入：E盘</a>
			<a id="btn" href="javascript:void(0)" onclick="insertStudent()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
			姓名：<input class="easyui-textbox" id="stu_name"/>
			住址：<input class="easyui-textbox" id="address"/>
			出生日期：<input  id="minBirth"  type= "text" class= "easyui-datebox"/>~
				   <input  id="maxBirth"  type= "text" class= "easyui-datebox"/>
			班级：<input id="classid" class="easyui-combobox"  data-options="valueField:'class_id',textField:'class_name',url:'selectClas'" />
			<a id="btn" href="javascript:void(0)" onclick="seachselect()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">检索</a>
		</form>
	</div>

	<!-- form-->
	<div id="insertDialog" class="easyui-dialog" title="添加学生"   
	        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">   
	    <form id="insertform" style="text-align: right;">  
	    	<input type="hidden" id="mark"/>
		    <div>   
		        <label for="name">class_name:</label>   
		        <input id="cc" class="easyui-combobox" name="class_id"   
   				 data-options="valueField:'class_id',textField:'class_name',url:'selectClas'" />
   				 <input type="hidden" name="stu_id" />
		    </div>   
		    <div>   
		        <label for="name">stu_name:</label>   
		        <input class="easyui-textbox" type="text" name="stu_name" />   
		    </div>   
		    <div>   
		        <label for="email">sex:</label>   
		        <input class="easyui-textbox" type="text" name="sex" />   
		    </div>
		    <div>   
		        <label for="email">mtel:</label>   
		        <input class="easyui-textbox" type="text" name="mtel" />   
		    </div>
		    <div>   
		        <label for="email">qq:</label>   
		        <input class="easyui-textbox" type="text" name="qq" />   
		    </div>
		    <div>   
		        <label for="email">address:</label>   
		        <input class="easyui-textbox" type="text" name="address" />   
		    </div>
		    <div>   
		        <label for="email">birthday:</label>   
		        <input class="easyui-datebox" type="text" name="birthday" />   
		    </div>
		    <div>   
		        <label for="email">stu_status:</label>   
		        <select class="easyui-combobox" style="width: 159px" name="stu_status">   
				    <option value="单招">单招</option>   
				    <option value="统招">统招</option>   
				</select>   
		    </div>
		</form>
		<div id="tj" style="text-align: center; padding:3px">
			<a id="btn" href="javascript:void(0)" onclick="insertStu()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>  
			<a id="btn" href="javascript:void(0)" onclick="clearStu()" class="easyui-linkbutton" data-options="iconCls:'icon-clear'">取消</a>  
		</div>
	</div>
	
	<!-- md5登陆 -->
	<div id="mdDialog" class="easyui-dialog" title="注册"   
	        data-options="iconCls:'icon-ok',resizable:true,modal:true,closed:true">   
	    <form id="mdform" style="text-align: right;">  
		    <div>   
		        <label for="name">登陆名:</label>   
		        <input class="easyui-textbox" type="text" name="u_name" />   
		    </div>   
		    <div>   
		        <label for="email">密     码:</label>   
		        <input class="easyui-textbox" type="password" name="u_pwd" />
		        <!-- <input class="easyui-validatebox" type="password" id="pwd" name="u_pwd" data-options="required:true" />  -->
		    </div>
		    <!-- <div id="qr">   
		        <label for="email">确认密码:</label>   
		        <input class="easyui-textbox" type="password" name="u_pwd" />   
		        <input id="rpwd" name="rpwd" type="password" class="easyui-validatebox"     
    			required="required" validType="equals['#pwd']" />  
		    </div> -->
		</form>
		<div id="tj" style="text-align: center; padding:3px">
			<a id="btn" href="javascript:void(0)" onclick="dlmd()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交</a>  
			<a id="btn" href="javascript:void(0)" onclick="clearmd()" class="easyui-linkbutton" data-options="iconCls:'icon-clear'">取消</a>  
		</div>
	</div>
</body>
</html>