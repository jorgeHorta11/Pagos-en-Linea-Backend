package com.pagos.linea.demo.services;

import java.util.Date;
import java.util.List;

import com.pagos.linea.demo.entitys.CustomerBill;

public interface CustomerInterface {
	
	CustomerBill saveOrder(CustomerBill customerBill);

	CustomerBill updateOrder(CustomerBill customerBill);
	
	CustomerBill getOrder(Long orderId);
	
	Date getOrderDate(Long orderId);
	
	void deleteOrder(Long orderId);
	
	void saveAllOrders(List<CustomerBill> orders);

}
