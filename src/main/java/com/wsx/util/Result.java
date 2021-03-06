package com.wsx.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回类进行封装
 * @author wsx
 *
 */
public class Result {
	
	Map map = new HashMap();
	
	/**
	 * 状态码
	 */
	private String code;
	
	 /**
	  * 返回的信息
	  */
	private String massage;
	
	/**
	 * 返回的结果
	 */
	private List<Object> results;

	private Result(String code,String massage){
		this.code = code;
		this.massage = massage;
	}
	
	public static Result success(){
		return new Result("200","SUCCESS");
	}
	
	
	
}
