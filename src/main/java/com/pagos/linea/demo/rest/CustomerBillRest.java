package com.pagos.linea.demo.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pagos.linea.demo.date.CustomerBillDataRepository;
import com.pagos.linea.demo.entitys.CustomerBill;
import com.pagos.linea.demo.services.CustomerInterface;


@Service
public class CustomerBillRest implements CustomerInterface{
	
	@Autowired
	private CustomerBillDataRepository customerBillDataRepository;
	
	@Override
	public CustomerBill saveOrder(CustomerBill customerBill) {
		return customerBillDataRepository.save(customerBill);
	}
	
	@Override
	public CustomerBill updateOrder(CustomerBill customerBill) {
		return customerBillDataRepository.save(customerBill);
	}
	
	 @Override
	    public Date getOrderDate(Long orderId) {
	        Optional<CustomerBill> optionalC = customerBillDataRepository.findById(orderId);
	        CustomerBill order = optionalC.get();
	        return order.getCreated();
	    }

	    @Override
	    public void deleteOrder(Long id) {
	        customerBillDataRepository.deleteById(id);
	    }

	    @Override
	    public CustomerBill getOrder(Long orderId) {
	        Optional<CustomerBill> optional = customerBillDataRepository.findById(orderId);
	        CustomerBill order = optional.get();
	        return order;
	    }

	
	  @Override
	    public void saveAllOrders(List<CustomerBill> orders) {
	        customerBillDataRepository.saveAll(orders);
	    }

}
