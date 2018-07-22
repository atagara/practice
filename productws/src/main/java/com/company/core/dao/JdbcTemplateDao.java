package com.company.core.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDao {
	private JdbcTemplate jdbcTemplate;
	
	protected JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
