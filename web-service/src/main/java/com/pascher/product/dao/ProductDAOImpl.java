package com.pascher.product.dao;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pascher.core.dimension.Dimension;
import com.pascher.core.price.Price;
import com.pascher.core.product.Product;
import com.pascher.core.product.dao.ProductDAO;
import com.pascher.db.MongoDBConnection;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private ProductDAOSDMongo productDAOSDMongo;
	
	static Logger logger = LoggerFactory.getLogger("ProductDAOImpl");

	@Override
	public void create(Product product) throws Exception {
		logger.info("storing product: " + product.getName());
		productDAOSDMongo.save(product);
		
		/* Mongo Client implementation:
		 * MongoDatabase db = MongoDBConnection.getDBConnection("eatFresh");
		 * MongoCollection<Document> collection = db.getCollection("product");
		 * 
		 * System.out.println("connection established");
		 * logger.info("connection established"); Document newProduct = new Document();
		 * newProduct.put("name", product.getName()); newProduct.put("description",
		 * product.getDescription()); newProduct.put("commodityType",
		 * product.getCommodityType()); BasicDBList priceList = new BasicDBList(); for
		 * (Price price : product.getPrice()) { BasicDBObject newPrice = new
		 * BasicDBObject(); newPrice.put("amount", price.getAmount());
		 * newPrice.put("currency", price.getCurrency()); priceList.add(newPrice); }
		 * newProduct.append("price", priceList); BasicDBList dimList = new
		 * BasicDBList(); for (Dimension dim : product.getDimensions()) { BasicDBObject
		 * newDim = new BasicDBObject(); newDim.put("measurement",
		 * dim.getMeasurement()); newDim.put("unit", dim.getUnit()); newDim.put("value",
		 * dim.getValue()); dimList.add(newDim); } newProduct.append("dimension",
		 * dimList); BasicDBObject weight = new BasicDBObject(); weight.put("unit",
		 * product.getWeight().getUnit()); weight.put("value",
		 * product.getWeight().getValue()); newProduct.put("weight", weight);
		 * System.out.println("calling insertOne"); collection.insertOne(newProduct);
		 */
	}
	
	@Override
	public boolean update(Product product) {
		logger.info("updating product: " + product.getName());
		productDAOSDMongo.save(product);
		return true;
	}

	@Override
	public boolean update(String name, double doublePrimitivePrice) throws Exception {
		logger.info("updating product: " + name + " to price: " + doublePrimitivePrice);
		Price priceObject = new Price(doublePrimitivePrice, name);
		Price[] priceList = {priceObject};
		Product product = productDAOSDMongo.findByName(name);
		if(product != null) {
			product.setPrice(priceList);
			productDAOSDMongo.save(product);
			return true;
		}
		return false;
		/* Mongo Client implementation
		MongoDatabase db = MongoDBConnection.getDBConnection("eatFresh");
		MongoCollection<Document> collection = db.getCollection("product");

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("price.0.amount", price));

		BasicDBObject searchQuery = new BasicDBObject().append("name", name);

		collection.updateOne(searchQuery, newDocument);
		*/
	}

	@Override
	public String delete(String name) throws Exception {
		logger.info("deleting product with name: " + name);
		Product product = productDAOSDMongo.findByName(name);
		if(product == null)
			return HttpStatus.NOT_FOUND.toString();
		productDAOSDMongo.delete(product);
		return HttpStatus.ACCEPTED.toString();
		/* Mongo Client implementation
		// getJdbcTemplate().update("delete from product where id=" + id);
		MongoDatabase db = MongoDBConnection.getDBConnection("eatFresh");
		MongoCollection<Document> collection = db.getCollection("product");
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", name);
		collection.deleteOne(searchQuery);
		*/
	}

	@Override
	public String find(String name) throws Exception {
		Product product = productDAOSDMongo.findByName(name);
		if(product == null)
			return HttpStatus.NOT_FOUND.toString();
		return product.toString();
		
		/* Mongo Client implementation
		MongoDatabase db = MongoDBConnection.getDBConnection("eatFresh");
		MongoCollection<Document> collection = db.getCollection("product");

		logger.info("Finding product " + name);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", name);

		FindIterable<Document> result = collection.find(searchQuery);
		for (Document doc : result) {
			if (doc.containsKey("name")) {
				String resultName = (String) doc.get("name");
				if (resultName.equalsIgnoreCase(name))
					return doc.toJson();
			}
		}
		return null;
		*/
	}
}
