package com.snkit.springbootcustomevent;

public class UserAddressEvent {
	
	AddressVO addressVO;
	public UserAddressEvent(AddressVO addVO) {
		this.addressVO = addVO;
	}
	public AddressVO getAddressVO() {
		return addressVO;
	}
	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}
	
	

}
