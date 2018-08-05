package com.wsx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsx.entity.User;
import com.wsx.service.UserService;
import com.wsx.util.ResponseUtil;

//@Controller 将Controller放入Spring容器之中
@Controller
@RequestMapping("/user") 
public class UserController {
	
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 private UserService userService;
	 
	 /**
	  * 根据ID删除用户
	  * @param id
	  */
	 @RequestMapping(value = "/delUser/{id}", method = RequestMethod.GET)
	 @ResponseBody
	 public Map<String,Object> delUser(@PathVariable("id") Integer id){
		 Map<String,Object>  map= new HashMap();
		 userService.delUser(id);
		 map.put("code", 200);
		 map.put("msg", "SUCCESS");
		 return map;
	 }
	 

	 @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
	 @ResponseBody
	 public Map<String,Object> queryAll(Integer page,Integer rows){
		Map<String,Object> map = new HashMap();
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		int counts =  userService.queryCount();
		List<User> userList = userService.queryAll(map);
		map.put("total", counts);
		map.put("rows", userList);
		return map;
	 }
	 
	 /**
	  * 更新用户
	  * @param user
	  */
	 @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	 @ResponseBody
	 public Map<String,Object> updateUser(User user){
		 Map<String,Object>  map= new HashMap();
		 userService.updateUser(user);
		 map.put("code", 200);
		 map.put("msg", "SUCCESS");
		 return map;
	 }
	 
	 /**
	  * 添加用户
	  * @param user
	  */
	 @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	 @ResponseBody
	 public Map<String,Object> insertUser(User user){
		 Map<String,Object>  map= new HashMap();
		 userService.insertUser(user);
		 map.put("code", 200);
		 map.put("msg", "SUCCESS");
		 return map;
	 }

}
