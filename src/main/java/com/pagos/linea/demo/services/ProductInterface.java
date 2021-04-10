package com.pagos.linea.demo.services;

import java.util.List;

import com.pagos.linea.demo.entitys.Product;

public interface ProductInterface {
	
	Product getProduct(Long productId);
	void saveAllProduct(List<Product> products);

}
