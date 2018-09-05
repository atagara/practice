package com.pascher.core.product;

import java.util.List;

import com.pascher.core.weight.Weight;

public class ProductDetails {

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
}
