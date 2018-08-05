package com.wsx.dao;

import java.util.List;
import java.util.Map;

import com.wsx.entity.User;

public interface UserDao {
	/**
	 * 更新
	 * @param user
	 */
	void updateUser(User user);
	

	List<User> queryAll(Map<String,Object> map);
	
	/**
	 * 查询总数
	 * @return
	 */
	int queryCount();
	
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

}
