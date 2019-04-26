package com.spz.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Result {
	public static String[] getResult(Object obj,int num) throws Exception{
	 	//Students stu=new Students();
        Field[] f=obj.getClass().getDeclaredFields();
        //从stu对象取值
        String[] arr=new String[f.length];
        for(int i=0;i<num;i++){
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
                //System.out.println(result.toString());
                arr[i]=result.toString()!=null ? result.toString() : "null";
            }catch(NoSuchMethodException e){
                result=f[i].get(obj);
            }
            //System.out.println("属性："+attributeName+"="+result);
        }
	return arr;
 }
}
