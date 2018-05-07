package com.github.taixiongliu.hapidemo.service;

import com.github.taixiongliu.hapidemo.entity.User;

public interface UserService {
	User getUserByAccount(String account);
}
