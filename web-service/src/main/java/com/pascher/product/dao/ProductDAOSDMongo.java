package com.pascher.product.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.pascher.core.product.Product;

@Component
public interface ProductDAOSDMongo extends MongoRepository<Product, ObjectId>{

	public Product findByName(String name);
	
}
