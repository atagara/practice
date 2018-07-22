package com.pascher.rest;

import com.pascher.core.review.Review;
import com.pascher.core.review.ReviewWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewResource {
	@Autowired
	private ReviewWS reviewService;
	
	@RequestMapping(method = RequestMethod.GET, value="/review/{name}")
	public @ResponseBody String findRewviewByProductName(@PathVariable("name")String name){
		return reviewService.find(name);
	}

	@RequestMapping(method = RequestMethod.POST, value="/review/create")
	public ResponseEntity<Review> createReview(@RequestBody final Review review){
		reviewService.add(review);
		return new ResponseEntity<Review>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/review/update")
	public ResponseEntity<Review> updateReview(@PathVariable("name")String name, @PathVariable("comment")String comment){
		reviewService.update(name, comment);
		return new ResponseEntity<Review>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/review/delete")
	public ResponseEntity<Review> deleteReview(@PathVariable("name")String name){
		reviewService.delete(name);
		return new ResponseEntity<Review>(HttpStatus.OK);
	}
}
