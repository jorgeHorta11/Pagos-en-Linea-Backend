package com.pagos.linea.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagos.linea.demo.entitys.CustomerBill;
import com.pagos.linea.demo.entitys.Product;
import com.pagos.linea.demo.services.CustomerInterface;
import com.pagos.linea.demo.services.ProductInterface;
import com.pagos.linea.demo.services.UserInterface;

@RestController
@RequestMapping("order")
public class CustomerBillController {

	@Autowired
	private CustomerInterface customerBillInterface;

	@Autowired
	private ProductInterface productInterface;

	@Autowired
	private UserInterface userInterface;

	@PostMapping("/save")
	public List<Object> saveOrder(@RequestBody CustomerBill customerBill) throws Exception {
		List<Product> products = customerBill.getProduct();

		double subtotal;
		double totalIva;
		double totalpay;
		double domicilio = 5000;

		List<Object> response = new LinkedList<>();
		try {
			Boolean userExist = getUser(customerBill);

			if (userExist) {
				subtotal = calculateSubtotal(products);
				totalIva = subtotal * 0.19d;
				totalpay = subtotal + totalIva;
				if (subtotal >= 10000) {
					domicilio = 0;
				}
				totalpay = totalpay + domicilio;
				customerBill.setDomicilio(domicilio);
				customerBill.setState(1);
				customerBill.setSubtotal(subtotal);
				customerBill.setTotalIva(totalIva);
				customerBill.setTotalpay(totalpay);

				CustomerBill order = customerBillInterface.updateOrder(customerBill);
				order.setProducts(products);
				response.add(order);
				response.add("el pedido se actualizo");
				return response;

			}
		} catch (Exception e) {
			response.add(e.getMessage());

			return response;
		}
		return response;
	}

	private Boolean getUser(CustomerBill customerBill) {
		// TODO Auto-generated method stub
		return null;
	}

	private double calculateSubtotal(List<Product> products) {
		// TODO Auto-generated method stub
		return 0;
	}
}
