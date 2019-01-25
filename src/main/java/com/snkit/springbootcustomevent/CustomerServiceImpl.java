package com.snkit.springbootcustomevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value="customerService")
public class CustomerServiceImpl {
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveUser(UserVO userVO) {
		
		
		UserEntity user = new UserEntity();
		user.setEmail(userVO.getEmail());
		user.setName(userVO.getName());
		UserEntity newEntity = userRepository.save(user);
		
		AddressVO addVO = userVO.getAddressVO();
		
		addVO.setUserid(newEntity.getId());
		
		UserAddressEvent addEvent = new UserAddressEvent(addVO);
		
		publisher.publishEvent(addEvent);
	}

}
