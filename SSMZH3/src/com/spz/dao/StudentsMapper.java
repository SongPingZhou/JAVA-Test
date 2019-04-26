package com.spz.dao;

import java.util.List;

import com.spz.entity.Students;

public interface StudentsMapper {
	
	List<Students> selectStudents(Students students); 

	Integer selectStudentsCount(Students students); 
	
	Integer updateStudent(Students students);
	
	Integer deleteStudent(Integer stu_id);
	
	Integer insertStudent(Students students);
	
	Students selectStudentsById(Integer stu_id);
}
