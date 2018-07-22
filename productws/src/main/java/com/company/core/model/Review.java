package com.company.core.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Review")
public class Review {
	
	private String name;
	private String description;
	private Date lastUpdated;
	private int productId;
	//TODO : If required later Update Rating as object 
	private double rating;
	//TODO : Update User as object later
	private String user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getUser() {
		return user;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
