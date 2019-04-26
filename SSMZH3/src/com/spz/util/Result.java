package com.spz.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Result {
	public static String[] getResult(Object obj,int num) throws Exception{
	 	//Students stu=new Students();
        Field[] f=obj.getClass().getDeclaredFields();
        //��stu����ȡֵ
        String[] arr=new String[f.length];
        for(int i=0;i<num;i++){
            //��ȡ������
            String attributeName=f[i].getName();
            //��������������ĸ��Ϊ��д��Ϊִ��set/get������׼��
            String methodName=attributeName.substring(0,1).toUpperCase()+attributeName.substring(1);
            Object result;
            try{
                //��ȡstu�൱ǰ���Ե�setXXX������ֻ�ܻ�ȡ���з�����
                Method getMethod=obj.getClass().getMethod("get"+methodName);
                //ִ�и�get����
                result=getMethod.invoke(obj);//�õ�����get��ֵ
                //System.out.println(result.toString());
                arr[i]=result.toString()!=null ? result.toString() : "null";
            }catch(NoSuchMethodException e){
                result=f[i].get(obj);
            }
            //System.out.println("���ԣ�"+attributeName+"="+result);
        }
	return arr;
 }
}
