package com.cqut.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cqut.model.pojo.UserInfo;

//表示该类是数据访问层
@Repository
public interface UserDao {
	
	public UserInfo login(String username,String password);
	public void register(UserInfo userinfo);
	public List<UserInfo> query(String input);
	public void delete(String userid);
	public UserInfo queryById(String userid);
	public void update(UserInfo userinfo);
}
