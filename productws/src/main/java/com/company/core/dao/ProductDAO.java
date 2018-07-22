package com.company.core.dao;

import com.company.core.model.Product;

public interface ProductDAO {

	void create(Product product);

	void update(int id, int price);

	void delete(int id);

	Product find(int id);
}
