package com.spz.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.spz.services.ClassesService;

@Controller
public class ClassesController {
	@Resource
	private ClassesService classesService;
	//http://localhost:8080/SSMZH3/selectClas
	@RequestMapping(value="/selectClas",method=RequestMethod.POST)
	@ResponseBody
	public String selectClas() {
		return new Gson().toJson(classesService.slectClass());
	}
}
