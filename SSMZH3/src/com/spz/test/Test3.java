package com.spz.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.spz.entity.Students;

public class Test3 {
	 public static void main(String[] args) throws Exception{

	        /**
	         	*  返回stu 对象所表示的类或接口的所有可访问公共字段。
	         */
		 Students stu=new Students();
		 stu.setAddress("12331");
		 stu.setBirthday("1209-12-29");
		 String[] result = getResult(stu);
		 for (String string : result) {
			System.out.println(string);
		}
		 System.out.println(result.length);
	    }
	 public static String[] getResult(Object obj) throws Exception{
		 	//Students stu=new Students();
	        Field[] f=obj.getClass().getDeclaredFields();
	        //从stu对象取值
	        String[] arr=new String[f.length];
	        for(int i=0;i<f.length;i++){
	            //获取属相名
	            String attributeName=f[i].getName();
	            //将属性名的首字母变为大写，为执行set/get方法做准备
	            String methodName=attributeName.substring(0,1).toUpperCase()+attributeName.substring(1);
	            Object result;
	            try{
	                //获取stu类当前属性的setXXX方法（只能获取公有方法）
	                Method getMethod=obj.getClass().getMethod("get"+methodName);
	                //执行该get方法
	                result=getMethod.invoke(obj);//得到所有get的值
	                arr[i]=(String) result;
	            }catch(NoSuchMethodException e){
	                result=f[i].get(obj);
	            }
	            System.out.println("属性："+attributeName+"="+result);
	        }
		return arr;
	 }
}
