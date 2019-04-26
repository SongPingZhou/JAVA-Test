package com.spz.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spz.entity.Users;
import com.spz.services.UsersService;
import com.spz.util.MyResult;

@Controller
public class UsersController {
	
	@Resource
	private UsersService usersService;
	
	@ResponseBody
	@RequestMapping(value="/insertUsers",method=RequestMethod.POST)
	public String insertUsers(Users users) {
		return MyResult.toClient(true, usersService.insertUsers(users), "×¢²á³É¹¦");
	}
	
	@ResponseBody
	@RequestMapping(value="/seleceUsers",method=RequestMethod.POST)
	public String seleceUsers(Users users) {
		Users user = usersService.selectUserByUser(users);
		return MyResult.toClient(true, user == null ? "null" : user, user !=null ? "µÇÂ½³É¹¦" : "µÇÂ½Ê§°Ü");
	}
}
