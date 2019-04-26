package com.spz.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.spz.entity.Students;

public class Test3 {
	 public static void main(String[] args) throws Exception{

	        /**
	         	*  ����stu ��������ʾ�����ӿڵ����пɷ��ʹ����ֶΡ�
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
	        //��stu����ȡֵ
	        String[] arr=new String[f.length];
	        for(int i=0;i<f.length;i++){
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
	                arr[i]=(String) result;
	            }catch(NoSuchMethodException e){
	                result=f[i].get(obj);
	            }
	            System.out.println("���ԣ�"+attributeName+"="+result);
	        }
		return arr;
	 }
}
