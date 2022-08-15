package com.kb.chitchat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.chitchat.models.Review;
import com.kb.chitchat.repositories.ReviewRepo;

@Service
public class ReviewService {
	@Autowired 
	private ReviewRepo reviewRepo;

	// for many to many
//	@Autowired
//	private UserService userService;
	
		
	// read all
	public List<Review> allReviews(){ 
		return reviewRepo.findAll();
	}
	
	// read one
//	public List<Review> allReviewsOfReview(Review review) {
//		return reviewRepo.findByReviews(review);
//	}
//	
//	public List<Review> allReviewsNotofReview(Review review) {
//		return reviewRepo.findByReviewsNotContains(review);
//	}
	
	
	// Create and Update
	public Review saveReview(Review review) {
		return reviewRepo.save(review);
	}
	
	// delete
	public void deleteReview(Review review) {
		reviewRepo.delete(review);
	}
	
	// read one
	public Review findReview(Long id) {
		Optional<Review> optionalReview = reviewRepo.findById(id);
		
		if (optionalReview.isPresent()) { return optionalReview.get(); } 
		else { return null;}
	}
	
	// read all but specific pools
	public List<Review> AllReviewsByPool(Long poolId) {
		return reviewRepo.findByPoolId(poolId);
	}

	
	// TODO: many to many relationship service
//	public Review addConnect(Long userId, Long reviewId) {
//		// retrieve an instance of a review using another method in the service.
//	    Review thisReview = findReview(reviewId);
//	    User thisUser = userService.findUser(userId);
//	    // add the user to this review's list of users
//	    thisReview.getAttendingUsers().add(thisUser);
//	    
//	    // Save thisReview, since you made changes to its user list.
//	    return reviewRepo.save(thisReview);
//		
//	}
//	
	
//	public Review removeConnect(Long userId, Long reviewId) {
//		// retrieve an instance of a review using another method in the service.
//	    Review thisReview = findReview(reviewId);
//	    User thisUser = userService.findUser(userId);
//	    // add the user to this review's list of users
//	    thisReview.getAttendingUsers().remove(thisUser);
//	    
//	    // Save thisReview, since you made changes to its user list.
//	    // TODO: don't forget this!! 
//	    return reviewRepo.save(thisReview);
//		
//	}
	
	
	// ! TODO addition validation
//	public void checkDate(Review review, BindingResult result) {
//		System.out.println(review.getReviewDate());
//		System.out.println(new Date());
//		
//		if (review.getReviewDate().after(new Date())) {
//			System.out.println("it is future");
//		}
//		else {
//			System.out.println("not futre");
//		}
//	}
//	
	
}
