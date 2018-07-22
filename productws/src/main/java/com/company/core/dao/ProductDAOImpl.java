package com.company.core.dao;

import com.company.core.dao.mappers.ProductRowMapper;
import com.company.core.model.Product;

public class ProductDAOImpl  extends JdbcTemplateDao implements ProductDAO {

	@Override
	public void create(Product product) {
		//java.lang.System.identityHashCode(obj)
		getJdbcTemplate().update("insert into product value(" + product.hashCode() + ",'" + product.getName() + "','"
				+ product.getDescription() + "'," + product.getCommodityType() + ")");
	}

	@Override
	public void update(int id, Price price) {
//		getJdbcTemplate().update("update product set price=" + price + " where id=" + id);
	}

	@Override
	public void delete(int id) {
//		getJdbcTemplate().update("delete from product where id=" + id);
	}

	@Override
	public Product find(int id) {
//		Product product = getJdbcTemplate().queryForObject("select * from product where id=" + id, new ProductRowMapper());
//		return product;
		return null;
	}
}
