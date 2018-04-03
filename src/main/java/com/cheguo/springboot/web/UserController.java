package com.cheguo.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheguo.springboot.service.UserService;
import com.cheguo.springboot.vo.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/userList")
	public List<User> userList() {
		return service.listUser();
	}
}
