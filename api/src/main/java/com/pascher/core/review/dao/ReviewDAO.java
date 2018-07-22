package com.pascher.core.review.dao;

import com.pascher.core.review.Review;

public interface ReviewDAO {

	void create(Review review) throws Exception;

	void update(String name, String comment) throws Exception;

	void delete(String name) throws Exception;

	String find(String name) throws Exception;
}
