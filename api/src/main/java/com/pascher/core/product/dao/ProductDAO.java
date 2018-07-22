package com.pascher.core.product.dao;

import com.pascher.core.product.Product;

public interface ProductDAO {

	void create(Product product) throws Exception;

	void update(String name, double price) throws Exception;

	void delete(String name) throws Exception;

	String find(String name) throws Exception;
}
