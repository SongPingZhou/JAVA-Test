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
		 * stulist="[{\'stu_id\':33,\'stu_name\':\'�߱���\',\'sex\':\'��\',\'mtel\':\'15322682389\',\'qq\':\'287118185\',\'address\':\'֣��\',\'birthday\':\'2018-12-25 14:27:16.0\',\'stu_status\':\'ͳ��\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':42,\'stu_name\':\'��F�u\',\'sex\':\'��\',\'mtel\':\'15322612076\',\'qq\':\'1471126238\',\'address\':\'֣��\',\'birthday\':\'2018-12-25 14:27:16.0\',\'stu_status\':\'ͳ��\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':70,\'stu_name\':\'�ƫT��\',\'sex\':\'Ů\',\'mtel\':\'133220\',\'qq\':\'13711000000\',\'address\':\'֣��\',\'birthday\':\'2018-12-25 00:00:00.0\',\'stu_status\':\'ͳ��\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':79,\'stu_name\':\'·�v�t\',\'sex\':\'��\',\'mtel\':\'13322000000\',\'qq\':\'13711000000\',\'address\':\'֣��\',\'birthday\':\'2018-12-25 14:27:16.0\',\'stu_status\':\'ͳ��\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':80,\'stu_name\':\'�¹��x\',\'sex\':\'��\',\'mtel\':\'15322520859\',\'qq\':\'1371109149\',\'address\':\'֣��\',\'birthday\':\'2018-12-25 00:00:00.0\',\'stu_status\':\'ͳ��\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':105,\'stu_name\':\'�ȲȲ�\',\'sex\':\'��\',\'mtel\':\'1383780\',\'qq\':\'133126\',\'address\':\'����\',\'birthday\':\'1997-12-29 00:00:00.0\',\'stu_status\':\'����\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':114,\'stu_name\':\'test\',\'sex\':\'��\',\'mtel\':\'1383780524\',\'qq\':\'13313160\',\'address\':\'�Ϻ�\',\'birthday\':\'1997-12-28 00:00:00.0\',\'stu_status\':\'����\',\'class_id\':1,\'classes\':{\'class_id\':1,\'class_name\':\'1304\',\'class_status\':1}},{\'stu_id\':1,\'stu_name\':\'��B��\',\'sex\':\'��\',\'mtel\':\'13322000000\',\'qq\':\'13711000000\',\'address\':\'֣��\',\'birthday\':\'2015-07-21 00:00:00.0\',\'stu_status\':\'ͳ��\',\'class_id\':2,\'classes\':{\'class_id\':2,\'class_name\':\'GD1504A\',\'class_status\':1}},{\'stu_id\':34,\'stu_name\':\'���~�D\',\'sex\':\'Ů\',\'mtel\':\'15322743626\',\'qq\':\'1271146153\',\'address\':\'֣��\',\'birthday\':\'2018-12-25 14:27:16.0\',\'stu_status\':\'ͳ��\',\'class_id\':2,\'classes\':{\'class_id\':2,\'class_name\':\'GD1504A\',\'class_status\':1}},{\'stu_id\':43,\'stu_name\':\'�����i\',\'sex\':\'Ů\',\'mtel\':\'18322882310\',\'qq\':\'1271156\',\'address\':\'֣��\',\'birthday\':\'2018-12-25 14:27:16.0\',\'stu_status\':\'ͳ��\',\'class_id\':2,\'classes\':{\'class_id\':2,\'class_name\':\'GD1504A\',\'class_status\':1}}]"
		 * ;
		 * 
		 * JSONArray json=JSONArray.fromObject(stulist); if(json.size()>0) { for(int
		 * i=0;i<json.size();i++) { JSONObject
		 * job=json.getJSONObject(i);//����jsonarray���飬�Ѷ���ת��json����
		 * System.out.println(job.get("stu_id")); } }
		 */

		// String t=
		// "['stu_id','stu_name','sex','mtel','qq','address','birthday','stu_status','classes.class_name','caozuo']";
		
		
		
		
		
		
		
		
		
		Students stu = new Students();
		Field[] f = stu.getClass().getDeclaredFields();
		
		for(int i=0;i<f.length;i++){
            //��ȡ������
            String attributeName=f[i].getName();
            //��������������ĸ��Ϊ��д��Ϊִ��set/get������׼��
            String methodName=attributeName.substring(0,1).toUpperCase()+attributeName.substring(1);
            Object result = null;
            try{
                //��ȡTest�൱ǰ���Ե�setXXX������˽�к͹��з�����
                /*Method setMethod=Test.class.getDeclaredMethod("set"+methodName);*/
                //��ȡTest�൱ǰ���Ե�setXXX������ֻ�ܻ�ȡ���з�����
                Method getMethod=Test.class.getMethod("get"+methodName);
                //ִ�и�set����
                result=getMethod.invoke(stu);

            }catch(Exception e){
                try {
					result=f[i].get(stu);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            System.out.println("���ԣ�"+attributeName+"="+result);
        }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*for (Field s : fields) {
			String name = s.getName();// ��ȡ������
			String type = s.getGenericType().toString();// ��ȡ��������
			if (type.equals("class java.lang.String")) {
				try {
					Method m = stu.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
					String value = (String) m.invoke(stu);
					if (null != value) {
						Log.d("---������---", name);
						Log.d("---����ֵ---", value);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}*/
	}

}
