package com.pascher.core.review;

import com.pascher.core.Comment.Comment;
import com.pascher.core.domain.UserType;

public class Review {
    String productName;
    String description;
    double rating;
    String[] userName;
    String longDescription;
    Comment[] comments;
    UserType userType;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String[] getUserName() {
        return userName;
    }

    public void setUserName(String[] userName) {
        this.userName = userName;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
