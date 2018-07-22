package com.company.core.service.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.core.service.ReviewWSImpl;
import com.company.ws.product.dto.Product;

@RestController
public class ReviewResource {
	
	private ReviewWSImpl ReviewService;
	
	@RequestMapping(method = RequestMethod.GET, value="/review/{id}")
	public Product findProductById(@PathVariable("id")int id){
		return ReviewService.find(id);
	}
}
