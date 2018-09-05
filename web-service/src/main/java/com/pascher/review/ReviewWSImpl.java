package com.pascher.review;

import com.pascher.core.review.Review;
import com.pascher.core.review.ReviewWS;
import com.pascher.core.review.dao.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewWSImpl implements ReviewWS {
//	@Autowired
	private ReviewDAO dao;

	@Override
	public boolean add(final Review review) {
		try {
			dao.create(review);
			return true;
		}catch(Exception e){

		}
		return false;
	}

	@Override
	public boolean update(final String name, final String description) {
		try {
			dao.update(name, description);
			return true;
		}catch(Exception e){

		}
		return false;
	}

	@Override
	public boolean delete(final String name) {
		try {
			dao.delete(name);
			return true;
		}catch(Exception e){

		}
		return false;
	}

	@Override
	public String find(final String name) {
		try {
			String product = dao.find(name);
			if(product!= null)
				return product;
		}catch(Exception e){

		}
		return null;
	}
}
