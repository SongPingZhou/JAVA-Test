package com.spz.services;

import com.spz.entity.Users;

public interface UsersService {
	
	Integer insertUsers(Users users);
	
	Users selectUserByUser(Users users);
}
