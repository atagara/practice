package com.company.core.dao;

import com.company.core.model.Product;
import com.company.core.model.Review;

public interface ReviewDAO {
	void create(Review Review);

	void delete(int id);

	Product find(int id);
}
