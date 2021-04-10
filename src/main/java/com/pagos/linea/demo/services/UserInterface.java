package com.pagos.linea.demo.services;

import com.pagos.linea.demo.entitys.User;

public interface UserInterface {
	
	Boolean getUser(Long userId);
	void saveUser(User user);

}
