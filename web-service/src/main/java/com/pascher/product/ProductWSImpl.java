package com.pascher.product;

import com.pascher.core.product.Product;
import com.pascher.core.product.ProductWS;
import com.pascher.core.product.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductWSImpl implements ProductWS {
	@Autowired
	private ProductDAO dao;

	@Override
	public boolean add(final Product product) {
		try {
			dao.create(product);
			return true;
		}catch(Exception e){

		}
		return false;
	}

	@Override
	public boolean update(final String name, final double price) {
		try {
			dao.update(name, price);
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
