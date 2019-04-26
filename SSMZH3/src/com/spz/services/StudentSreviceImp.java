package com.spz.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.spz.dao.StudentsMapper;
import com.spz.entity.Fenye;
import com.spz.entity.Students;
@Service
public class StudentSreviceImp implements StudentSrevice {
	@Resource
	private StudentsMapper studentsMapper;
	@Override
	public String selectStudentAll(Students students) {
		Fenye<Students> fy=new Fenye<Students>();
		students.setPage((students.getPage()-1)*students.getRows());
		fy.setRows(studentsMapper.selectStudents(students));
		fy.setTotal(studentsMapper.selectStudentsCount(students));
		return new Gson().toJson(fy);
	}
	@Override
	public Integer updateStudent(Students students) {
		return studentsMapper.updateStudent(students);
	}
	@Override
	public Integer deleteStudent(Integer stu_id) {
		return studentsMapper.deleteStudent(stu_id);
	}
	@Override
	public Integer insertStudent(Students students) {
		return studentsMapper.insertStudent(students);
	}
	@Override
	public Students selectStudentsById(Integer stu_id) {
		return studentsMapper.selectStudentsById(stu_id);
	}

}
