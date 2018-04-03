package com.cheguo.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheguo.springboot.dao.UserDao;
import com.cheguo.springboot.vo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> listUser() {
		return this.userDao.listUser();
	}

}
