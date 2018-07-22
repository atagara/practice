package com.company.core.service.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.core.service.ProductWSImpl;
import com.company.ws.product.dto.Product;

@RestController
public class ProductResource {
	
	private ProductWSImpl productService;
	
	@RequestMapping(method = RequestMethod.GET, value="/product/{id}")
	public Product findProductById(@PathVariable("id")int id){
		return productService.find(id);
	}
}
