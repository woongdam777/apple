package com.kh.test.user.model.service;

import com.kh.test.user.model.vo.User;

public interface UserService {

	/** 아이디 검색
	 * @param selectId
	 * @return
	 */
	User selectId(String selectId);

}
