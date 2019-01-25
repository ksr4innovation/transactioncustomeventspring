package com.snkit.springbootcustomevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	
	@PostMapping(value="/saveUser")
	public String saveUser(@RequestBody UserVO userVO) {
		
		customerService.saveUser(userVO);
		
		return "Success";
		
	}

}
