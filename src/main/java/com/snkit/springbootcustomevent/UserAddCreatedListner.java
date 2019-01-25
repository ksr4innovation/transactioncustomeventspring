package com.snkit.springbootcustomevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserAddCreatedListner {
	
	
	
	@Autowired
	AddServiceImpl addService;
	



	@TransactionalEventListener(phase=TransactionPhase.BEFORE_COMMIT)
	public void afterCommit(UserAddressEvent createEvent) {
		System.out.println("  afterCommit ============   ");
		
		addService.saveAdd(createEvent.getAddressVO());
		
	
		
		
	}
	
	@TransactionalEventListener(phase=TransactionPhase.AFTER_ROLLBACK)
	public void usercreationFailed(UserAddressEvent createEvent) {
		
		System.out.println("  usercreationFailed   ");
		
		
		addService.saveAdd(createEvent.getAddressVO());
		
	
		
		
	}
}
