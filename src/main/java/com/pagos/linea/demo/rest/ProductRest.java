package com.pagos.linea.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pagos.linea.demo.date.ProductDateRepository;
import com.pagos.linea.demo.entitys.Product;
import com.pagos.linea.demo.services.ProductInterface;

@Service
public class ProductRest implements ProductInterface {

	@Autowired
	private ProductDateRepository productDateRepository;

	@Override
	public Product getProduct(Long productId) {
		Optional<Product> optional = productDateRepository.findById(productId);
		Product product = optional.get();
		return product;
	}

	@Override
	public void saveAllProduct(List<Product> products) {

		productDateRepository.saveAll(products);

	}
}
