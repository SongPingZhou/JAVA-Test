package com.spz.test;

import java.util.ArrayList;
import java.util.List;

import com.spz.entity.Students;
import com.spz.util.Result;

public class Test4 {

	public static void main(String[] args) throws Exception {
		
		Students stu=new Students();
		stu.setAddress("123");
		String[] result = Result.getResult(stu,0);
		System.out.println(result.length);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
		/*List<Students> listStu=new ArrayList<Students>();
		System.out.println(listStu.size());
		Students st1=new Students();
		st1.setAddress("北京");
		Students st2=new Students();
		st2.setAddress("北京");
		Students st3=new Students();
		st3.setAddress("北京");
		System.out.println("++++++");
		listStu.set(0, st1);
		listStu.set(1, st2);
		listStu.set(2, st3);
		System.out.println("++++++++++++++++");
		System.out.println(listStu.size());
		for(int i=0;i<listStu.size();i++) {
			Students students = listStu.get(i);
			String[] result = Result.getResult(students);
			for(int j=0;j<result.length;j++) {
				System.out.println(result[j]);
			}
		}*/
	}

}
