package com.company.core.dao;

import com.company.core.dao.mappers.ProductRowMapper;
import com.company.core.model.Product;
import com.company.core.model.Review;

public class ReviewDAOImpl extends JdbcTemplateDao implements ReviewDAO {

	@Override
	public void create(Review review) {
		getJdbcTemplate().update("insert into review value(" + review.getId() + ",'" + review.getName() + "','"
				+ review.getDescription() + "')");
	}

	@Override
	public void delete(int id) {
		getJdbcTemplate().update("delete from product where id=" + id);
	}

	@Override
	public Product find(int id) {
		Product product = getJdbcTemplate().queryForObject("select * from product where id=" + id, new ProductRowMapper());
		return product;
	}
}
