package com.spz.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spz.entity.Students;
import com.spz.services.StudentSrevice;

@Controller
public class StudentsController {
	@Resource
	private StudentSrevice studentSrevice;
	//http://localhost:8080/SSMZH3/selectStu?page=1&rows=10
	@RequestMapping(value="/selectStu",method=RequestMethod.POST)
	@ResponseBody
	public String selectStu(Students student) {
		
		return studentSrevice.selectStudentAll(student);
	}
	
	@RequestMapping(value="/insertStu",method=RequestMethod.POST)
	@ResponseBody
	public Integer insertStu(Students student) {
		return studentSrevice.insertStudent(student);
	}
	
	@RequestMapping(value="/updateStu",method=RequestMethod.POST)
	@ResponseBody
	public Integer updateStu(Students student) {
		return studentSrevice.updateStudent(student);
	}
	
	@RequestMapping(value="/deleteStu",method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteStu(Integer stu_id) {
		return studentSrevice.deleteStudent(stu_id);
	}
	
	@RequestMapping(value="/selectStuById",method=RequestMethod.POST)
	@ResponseBody
	public Students selectStuById(Integer stu_id) {
		return studentSrevice.selectStudentsById(stu_id);
	}
}
