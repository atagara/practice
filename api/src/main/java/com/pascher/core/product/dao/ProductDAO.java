package com.pascher.core.product.dao;

import com.pascher.core.product.Product;

public interface ProductDAO {

	void create(Product product) throws Exception;
	
	boolean update(Product product);

	boolean update(String name, double price) throws Exception;

	String delete(String name) throws Exception;

	String find(String name) throws Exception;
}
