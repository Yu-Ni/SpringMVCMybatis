package com.cqut.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqut.model.dao.UserDao;
import com.cqut.model.pojo.UserInfo;
import com.cqut.model.service.UserService;
import com.cqut.util.MD5;
import com.cqut.util.UID;

//表示该类是个业务逻辑类
@Service
public class UserServiceImpl implements UserService{
	
	// 自动装配 自动创建该类的具体过程
	@Autowired
	private UserDao dao;
	
	@Override
	public UserInfo login(String username, String password) {
		return dao.login(username,MD5.getMD5(password));
	}

	@Override
	public void register(UserInfo userinfo) {
		userinfo.setUserid(UID.createID());
		userinfo.setPassword(MD5.getMD5(userinfo.getPassword()));
		dao.register(userinfo);
	}

	@Override
	public List<UserInfo> query(String input) {
		return dao.query("%"+input+"%");
	}

	@Override
	public void delete(String userid) {
		dao.delete(userid);
	}

	@Override
	public UserInfo queryById(String userid) {
		return dao.queryById(userid);
	}

	@Override
	public void update(UserInfo userinfo) {
		dao.update(userinfo);
	}
	
}
