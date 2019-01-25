package com.snkit.springbootcustomevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value="addService")
public class AddServiceImpl {
	
	@Autowired
	UserAddressRepository userAddressRepository;
	
	int count =0;
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveAdd(AddressVO addressVO) {
		System.out.println("  saveAdd start ============   ");
		UserAddressEntity user = new UserAddressEntity();
		
		user.setCountry(addressVO.getCountry());
		user.setStreet(addressVO.getStreet());
		user.setStatus(addressVO.getStatus());
		user.setUserid(addressVO.getUserid());
		if (count > 1 ) {
			throw new RuntimeException("  user denifed exception");
		}
		count =count+1;
		
		userAddressRepository.save(user);
		System.out.println("  saveAdd end ============   ");
	}

}
