package com.pagos.linea.demo.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pagos.linea.demo.date.UserDateRepository;
import com.pagos.linea.demo.entitys.User;
import com.pagos.linea.demo.services.UserInterface;

@Service
public class UserRest implements UserInterface {
	
	@Autowired
	private UserDateRepository userDateRepository;
	
	@Override
	public Boolean getUser(Long userId) {
		Optional<User> optional = userDateRepository.findById(userId);
		if(!optional.isPresent()) {
			return false;
		}else {
			return true;
		}
		
	}
	@Override
	public void saveUser(User user) {
		userDateRepository.save(user);
	}

}
