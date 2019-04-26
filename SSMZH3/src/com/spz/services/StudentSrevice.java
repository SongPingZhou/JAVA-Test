package com.spz.services;

import com.spz.entity.Students;

public interface StudentSrevice {
	
	String selectStudentAll(Students student);
	
	Integer updateStudent(Students students);
	
	Integer deleteStudent(Integer stu_id);
	
	Integer insertStudent(Students students);
	
	Students selectStudentsById(Integer stu_id);
}
