package com.spz.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spz.dao.UsersMapper;
import com.spz.entity.Users;
import com.spz.util.MyMd5Util;
@Service
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersMapper usersMapper;
	
	@Override
	public Integer insertUsers(Users users) {
		//对用户密码加密
		users.setU_pwd(MyMd5Util.converMd5(MyMd5Util.strMd5(users.getU_pwd())));
		return usersMapper.insertUsers(users);
	}
	StringBuffer aa=new StringBuffer();
			
	@Override
	public Users selectUserByUser(Users users) {
		users.setU_pwd(MyMd5Util.converMd5(MyMd5Util.strMd5(users.getU_pwd())));
		return usersMapper.selectUserByUser(users);
	}
	
}
