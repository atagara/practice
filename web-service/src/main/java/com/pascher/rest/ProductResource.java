package com.pascher.rest;

import com.pascher.core.product.Product;
import com.pascher.core.product.ProductWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductResource {
	@Autowired
	private ProductWS productService;
	
	@RequestMapping(method = RequestMethod.GET, value="/product/{name}")
	public @ResponseBody String findProductByName(@PathVariable("name")String name){
		return productService.find(name);
	}

	@RequestMapping(method = RequestMethod.POST, value="/product/create")
	public ResponseEntity<Product> createProduct(@RequestBody final Product product){
		System.out.println(product.toString());
		productService.add(product);
		return new ResponseEntity<Product>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/product/update/{name}/{price}")
	public ResponseEntity<Product> updateProductPrice(@PathVariable("name")String name, @PathVariable("price")double price){
		productService.update(name, price);
		return new ResponseEntity<Product>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/product/delete")
	public ResponseEntity<Product> deleteProduct(@PathVariable("name")String name){
		productService.delete(name);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
}
