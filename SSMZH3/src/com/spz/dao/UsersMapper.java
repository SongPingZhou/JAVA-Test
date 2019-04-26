package com.spz.dao;

import com.spz.entity.Users;

public interface UsersMapper {
	
	Integer insertUsers(Users users);
	
	Users selectUserByUser(Users users);
}
