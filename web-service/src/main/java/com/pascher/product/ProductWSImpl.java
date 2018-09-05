package com.pascher.product;

import com.pascher.core.product.Product;
import com.pascher.core.product.ProductWS;
import com.pascher.core.product.dao.ProductDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductWSImpl implements ProductWS {
	
	static Logger logger = LoggerFactory.getLogger("ProductWSImpl");
	
	@Autowired
	private ProductDAO dao;

	@Override
	public boolean add(final Product product) {
		try {
			dao.create(product);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	
	@Override
	public boolean update(final Product product) {
		try {
			return dao.update(product);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(final String name, final double price) {
		try {
			return dao.update(name, price);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public String delete(final String name) {
		try {
			return dao.delete(name);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return HttpStatus.EXPECTATION_FAILED.toString();
	}

	@Override
	public String find(final String name) {
		String productString = HttpStatus.EXPECTATION_FAILED.toString();
		try {
			productString = dao.find(name);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return productString;
	}
}
