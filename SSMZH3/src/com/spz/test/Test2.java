package com.spz.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.google.gson.Gson;
import com.spz.entity.Students;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String
		 * stulist="[{\'stu_id\':33,\'stu_name\':\'高兵伝\',\'sex\':\'男\',\'mtel\':\'15322682389\',\'qq\':\'287118185\',\'address\':\'郑州\',\'birthday\':\'2018-12-25 14:27:16.0\',\'stu_status\':\'统招\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':42,\'stu_name\':\'杨丗畊\',\'sex\':\'男\',\'mtel\':\'15322612076\',\'qq\':\'1471126238\',\'address\':\'郑州\',\'birthday\':\'2018-12-25 14:27:16.0\',\'stu_status\':\'统招\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':70,\'stu_name\':\'闫玊奉\',\'sex\':\'女\',\'mtel\':\'133220\',\'qq\':\'13711000000\',\'address\':\'郑州\',\'birthday\':\'2018-12-25 00:00:00.0\',\'stu_status\':\'统招\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':79,\'stu_name\':\'路乿乼\',\'sex\':\'男\',\'mtel\':\'13322000000\',\'qq\':\'13711000000\',\'address\':\'郑州\',\'birthday\':\'2018-12-25 14:27:16.0\',\'stu_status\':\'统招\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':80,\'stu_name\':\'陈龚飜\',\'sex\':\'男\',\'mtel\':\'15322520859\',\'qq\':\'1371109149\',\'address\':\'郑州\',\'birthday\':\'2018-12-25 00:00:00.0\',\'stu_status\':\'统招\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':105,\'stu_name\':\'踩踩踩\',\'sex\':\'男\',\'mtel\':\'1383780\',\'qq\':\'133126\',\'address\':\'北京\',\'birthday\':\'1997-12-29 00:00:00.0\',\'stu_status\':\'单招\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':114,\'stu_name\':\'test\',\'sex\':\'男\',\'mtel\':\'1383780524\',\'qq\':\'13313160\',\'address\':\'上海\',\'birthday\':\'1997-12-28 00:00:00.0\',\'stu_status\':\'单招\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':1,\'stu_name\':\'孙嘊此\',\'sex\':\'男\',\'mtel\':\'13322000000\',\'qq\':\'13711000000\',\'address\':\'郑州\',\'birthday\':\'2015-07-21 00:00:00.0\',\'stu_status\':\'统招\',\'class_id\':2,\'classes\':{\'class_id\':2,\'class_name\':\'GD1504A\',\'class_status\':1}},{\'stu_id\':34,\'stu_name\':\'郭雫艱\',\'sex\':\'女\',\'mtel\':\'15322743626\',\'qq\':\'1271146153\',\'address\':\'郑州\',\'birthday\':\'2018-12-25 14:27:16.0\',\'stu_status\':\'统招\',\'class_id\':2,\'classes\':{\'class_id\':2,\'class_name\':\'GD1504A\',\'class_status\':1}},{\'stu_id\':43,\'stu_name\':\'杨翋蔵\',\'sex\':\'女\',\'mtel\':\'18322882310\',\'qq\':\'1271156\',\'address\':\'郑州\',\'birthday\':\'2018-12-25 14:27:16.0\',\'stu_status\':\'统招\',\'class_id\':2,\'classes\':{\'class_id\':2,\'class_name\':\'GD1504A\',\'class_status\':1}}]"
		 * ;
		 * 
		 * JSONArray json=JSONArray.fromObject(stulist); if(json.size()>0) { for(int
		 * i=0;i<json.size();i++) { JSONObject
		 * job=json.getJSONObject(i);//遍历jsonarray数组，把对象转成json对象
		 * System.out.println(job.get("stu_id")); } }
		 */

		// String t=
		// "['stu_id','stu_name','sex','mtel','qq','address','birthday','stu_status','classes.class_name','caozuo']";
		
		
		
		
		
		
		
		
		
		Students stu = new Students();
		Field[] f = stu.getClass().getDeclaredFields();
		
		for(int i=0;i<f.length;i++){
            //获取属相名
            String attributeName=f[i].getName();
            //将属性名的首字母变为大写，为执行set/get方法做准备
            String methodName=attributeName.substring(0,1).toUpperCase()+attributeName.substring(1);
            Object result = null;
            try{
                //获取Test类当前属性的setXXX方法（私有和公有方法）
                /*Method setMethod=Test.class.getDeclaredMethod("set"+methodName);*/
                //获取Test类当前属性的setXXX方法（只能获取公有方法）
                Method getMethod=Test.class.getMethod("get"+methodName);
                //执行该set方法
                result=getMethod.invoke(stu);

            }catch(Exception e){
                try {
					result=f[i].get(stu);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            System.out.println("属性："+attributeName+"="+result);
        }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*for (Field s : fields) {
			String name = s.getName();// 获取属性名
			String type = s.getGenericType().toString();// 获取属性类型
			if (type.equals("class java.lang.String")) {
				try {
					Method m = stu.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
					String value = (String) m.invoke(stu);
					if (null != value) {
						Log.d("---属性名---", name);
						Log.d("---属性值---", value);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}*/
	}

}
