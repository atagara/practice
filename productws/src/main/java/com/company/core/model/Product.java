package com.company.core.model;

import java.util.Arrays;

public class Product {

	private String name;
	private String description;
	private Price[] price;
	private String commodityType;	
	private Dimension[] dimensions;	
	private Weight weight;
	
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
	public Price[] getPrice() {
		return price;
	}
	public void setPrice(Price[] price) {
		this.price = price;
	}
	public String getCommodityType() {
		return commodityType;
	}
	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}
	public Dimension[] getDimensions() {
		return dimensions;
	}
	public void setDimensions(Dimension[] dimensions) {
		this.dimensions = dimensions;
	}
	public Weight getWeight() {
		return weight;
	}
	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commodityType == null) ? 0 : commodityType.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + Arrays.hashCode(dimensions);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(price);
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (commodityType == null) {
			if (other.commodityType != null)
				return false;
		} else if (!commodityType.equals(other.commodityType))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (!Arrays.equals(dimensions, other.dimensions))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(price, other.price))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
}
