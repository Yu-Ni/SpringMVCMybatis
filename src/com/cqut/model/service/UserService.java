package com.cqut.model.service;

import java.util.List;

import com.cqut.model.pojo.UserInfo;


//表示该类是一个业务逻辑类
public interface UserService {
	
	public UserInfo login(String username,String password);
	public void register(UserInfo userinfo);
	public List<UserInfo> query(String input);
	public void delete(String userid);
	public UserInfo queryById(String userid);
	public void update(UserInfo userinfo);
}
