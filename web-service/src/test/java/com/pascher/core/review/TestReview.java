package com.pascher.core.review;

import com.pascher.core.Comment.Comment;
import com.pascher.core.domain.UserType;
import com.pascher.review.dao.ReviewDAOImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestReview {
    @Test
    public void testReviewCreationUpdateAndDelete() throws Exception{
        Review newReview = new Review();
        newReview.setProductName("iphone");
        newReview.setDescription("Apple Iphone");
        newReview.setLongDescription("Iphone is a product from Apple which runs on ios");
        newReview.setRating(3.0);
        newReview.setUserType(UserType.ANONYMUS);
        String[] userName = new String[1];
        userName[0] = "Abhi";
        newReview.setUserName(userName);
        Comment[] comments = new Comment[1];
        Comment comment = new Comment();
        comment.setComment("Phones are good but expensive");
        comment.setAbused(false);
        comment.setUsers(userName);
        comments[0] = comment;
        newReview.setComments(comments);

        ReviewDAOImpl dao = new ReviewDAOImpl();
        dao.create(newReview);
        String res = dao.find("iphone");
        System.out.println(res);

        dao.update("iphone", "Apple Iphone X");
        String updateRes = dao.find("iphone");
        System.out.println(updateRes);

        dao.delete("iphone");
        Assertions.assertNull(dao.find("iphone"));
    }
}

