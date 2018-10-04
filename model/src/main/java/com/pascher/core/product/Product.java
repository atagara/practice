package com.pascher.core.product;

import java.util.Arrays;
import java.util.List;

import com.pascher.core.price.Price;
import com.pascher.core.dimension.Dimension;
import com.pascher.core.weight.Weight;

import org.springframework.data.annotation.Id;

public class Product {

	@Id
	private String id;
	private String name;
	private String description;
	private Price[] price;
	private String commodityType;	
	private Dimension[] dimensions;	
	
	private Weight weight;
	private List<String> images;
	
	public Weight getWeight() {
		return weight;
	}
	
	public void setWeight(Weight weight) {
		this.weight = weight;
	}
	
	public List<String> getImages() {
		return images;
	}
	
	public void setImages(List<String> images) {
		this.images = images;
	}
	
//	private ProductDetails productDetails;
	
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

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
//	public ProductDetails getProductDetails() {
//		return productDetails;
//	}
//	
//	public void setProductDetails(ProductDetails productDetails) {
//		this.productDetails = productDetails;
//	}
	
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
//		result = prime * result + ((productDetails.getWeight() == null) ? 0 : productDetails.getWeight().hashCode());
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
//		if (productDetails.getWeight() == null) {
//			if (other.getProductDetails().getWeight() != null)
//				return false;
//		} else if (!productDetails.getWeight().equals(other.getProductDetails().getWeight()))
//			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + Arrays.toString(price)
				+ ", commodityType=" + commodityType + ", dimensions=" + Arrays.toString(dimensions) + ", weight="
//				+ productDetails.getWeight() 
				+ "]";
	}
	
}
