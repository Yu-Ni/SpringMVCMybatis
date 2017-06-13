package com.cqut.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cqut.model.pojo.UserInfo;
import com.cqut.model.service.UserService;

//加注解表示这是一个控制器
@Controller
@RequestMapping("/userController")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserInfo userinfo = service.login(username,password);
		if(userinfo != null){
			List<UserInfo> list=service.query("");
			request.setAttribute("list",list);
			return "success";
		}
		return "login";
	}
	
	@RequestMapping(value="/register")
	public String register(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		UserInfo info = new UserInfo(username,password,realname);
		try{
			service.register(info);
			return "login";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "register";
	}
	
	@RequestMapping("/query")
	public String query(HttpServletRequest request){
		String input = request.getParameter("input");
		try{
			List<UserInfo> list=service.query(input);
			request.setAttribute("list",list);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
		
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id") String userid,HttpServletRequest request){
		try{
			service.delete(userid);;
			List<UserInfo> list=service.query("");
			request.setAttribute("list",list);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	
	@RequestMapping(value="/queryById/{id}",method=RequestMethod.GET)
	public String queryById(@PathVariable("id") String userid,HttpServletRequest request){
		try{
			System.out.println(userid);
			UserInfo userinfo = service.queryById(userid);
			request.setAttribute("userinfo",userinfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "update";
	}
	
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request){
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		UserInfo info = new UserInfo(userid,username,password,realname);
		try{
			service.update(info);
			List<UserInfo> list=service.query("");
			request.setAttribute("list",list);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
}
