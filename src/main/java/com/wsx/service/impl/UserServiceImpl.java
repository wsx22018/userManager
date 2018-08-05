package com.wsx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsx.dao.UserDao;
import com.wsx.entity.User;
import com.wsx.service.UserService;

//@Component @Service @Dao @Controller
@Service
public class UserServiceImpl implements UserService{
	//日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UserDao userDao;


	public void updateUser(User user) {
	    userDao.updateUser(user);
	}


	public List<User> queryAll(Map<String,Object> map) {
		return userDao.queryAll(map);
	}


	public void delUser(int id) {
		userDao.delUser(id);
	}


	public void insertUser(User user) {
		user.setCreateTime(new Date());
		userDao.insertUser(user);
	}


	public int queryCount() {
		return userDao.queryCount();
	}

}
