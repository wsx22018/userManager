package com.wsx.service;

import java.util.List;
import java.util.Map;

import com.wsx.entity.User;

public interface UserService {
	
	/**
	 * 更新
	 * @param user
	 */
	void updateUser(User user);
	

	List<User> queryAll(Map<String,Object> map);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	void delUser(int id);
	
	/**
	 * 添加用户
	 * @param user
	 */
	void insertUser(User user);
	
	/**
	 * 查询总数
	 * @return
	 */
	int queryCount();

}
