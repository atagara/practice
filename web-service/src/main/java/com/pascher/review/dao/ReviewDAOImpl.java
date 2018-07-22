package com.pascher.review.dao;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pascher.core.Comment.Comment;
import com.pascher.core.review.Review;
import com.pascher.core.review.dao.ReviewDAO;
import com.pascher.db.MongoDBConnection;
import org.bson.Document;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public void create(final Review review) throws Exception {
        MongoCollection<Document> collection = getCollection();
        Document newReview = new Document();
        newReview.put("name", review.getProductName());
        newReview.put("description", review.getDescription());
        newReview.put("rating", review.getRating());
        newReview.put("longDescription", review.getLongDescription());
        newReview.put("userType", review.getUserType().toString());
        BasicDBList userList = new BasicDBList();
        for (String userName : review.getUserName()) {
            BasicDBObject newUser = new BasicDBObject();
            newUser.put("userName", userName);
            userList.add(newUser);
        }
        newReview.append("users", userList);
        BasicDBList commentList = new BasicDBList();
        for (Comment comment : review.getComments()) {
            BasicDBObject newComment = new BasicDBObject();
            newComment.put("comment", comment.getComment());
            newComment.put("abused", comment.isAbused());
            BasicDBList commentUserList = new BasicDBList();
            for (String userName : comment.getUsers()) {
                BasicDBObject newUser = new BasicDBObject();
                newUser.put("userName", userName);
                commentUserList.add(newUser);
            }
            newReview.append("users", commentUserList);
            commentList.add(newComment);
        }
        newReview.append("comments", commentList);
        collection.insertOne(newReview);
    }

	@Override
	public void update(final String name, final String description) throws Exception {
        MongoCollection<Document> collection = getCollection();
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", new BasicDBObject().append("description", description));

        BasicDBObject searchQuery = new BasicDBObject().append("name", name);

        collection.updateOne(searchQuery, newDocument);
	}

	@Override
	public void delete(String name) throws Exception {
        MongoCollection<Document> collection = getCollection();
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", name);
        collection.deleteOne(searchQuery);
	}

	@Override
	public String find(String name) throws Exception {
        MongoCollection<Document> collection = getCollection();

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", name);

        FindIterable<Document> result = collection.find(searchQuery);
        for(Document doc : result){
            if(doc.containsKey("name")){
                String resultName = (String)doc.get("name");
                if(resultName.equalsIgnoreCase(name))
                    return doc.toJson();
            }
        }
        return null;
	}

	private MongoCollection<Document> getCollection(){
        MongoDatabase db = MongoDBConnection.getDBConnection("eatFresh");
        return db.getCollection("review");
    }
}
