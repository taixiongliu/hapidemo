package com.github.taixiongliu.hapidemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.taixiongliu.hapidemo.dao.UserMapper;
import com.github.taixiongliu.hapidemo.entity.User;
import com.github.taixiongliu.hapidemo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserMapper userMapper;
	public User getUserByAccount(String account) {
		// TODO Auto-generated method stub
		User record = new User();
		record.setAccount(account);
		List<User> list = userMapper.select(record);
		if(list == null || list.isEmpty()){
			return null;
		}
		return list.get(0);
	}
}
