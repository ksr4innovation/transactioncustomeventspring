package com.snkit.springbootcustomevent;

public class UserCreatedEvent {

	UserVO userVO;
	
	
	public UserCreatedEvent(UserVO userVO) {
	this.userVO = userVO;
	
	}


	public UserVO getUserVO() {
		return userVO;
	}


	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	
}
