package com.pascher.core.product;

import com.pascher.core.dimension.Dimension;
import com.pascher.core.price.Price;
import com.pascher.product.dao.ProductDAOImpl;
import com.pascher.product.dao.ProductDAOSDMongo;
import com.pascher.core.weight.Weight;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages= {"com.pascher"})
public class TestProduct {
	
	@Autowired
	private ProductDAOSDMongo productDAOSDMongo;
	
	@Test
	public void testSD() {
		List<Product> productList =  productDAOSDMongo.findAll();
		System.out.println("Number of Products = " + productList.size());
		
	}
	
    //@Test
	/*
    public void testProductCreationUpdateAndDelete() throws Exception{
        Product newProduct = new Product();
        newProduct.setName("iphone");
        newProduct.setDescription("Apple Iphone");
        newProduct.setCommodityType("phone");
        Price price = new Price();
        price.setAmount(699d);
        price.setCurrency("USD");
        Price[] prices = new Price[2];
        prices[0] = price;
        price = new Price();
        price.setAmount(65000d);
        price.setCurrency("INR");
        prices[1] = price;
        newProduct.setPrice(prices);
        Dimension dim = new Dimension();
        dim.setMeasurement("screen size");
        dim.setUnit("inch");
        dim.setValue("4.7");
        Dimension[] dims = new Dimension[1];
        dims[0] = dim;
        newProduct.setDimensions(dims);
        Weight weight = new Weight();
        weight.setUnit("pounds");
        weight.setValue("0.4");
        newProduct.setWeight(weight);

        ProductDAOImpl pdao = new ProductDAOImpl();
        pdao.create(newProduct);
        String res = pdao.find("iphone");
        System.out.println(res);

        pdao.update("iphone", 1099d);
        String updateRes = pdao.find("iphone");
        System.out.println(updateRes);

//        pdao.delete("iphone");
        Assertions.assertNull(pdao.find("iphone"));
    }
    */
}

