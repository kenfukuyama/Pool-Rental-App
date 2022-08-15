package com.kb.chitchat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kb.chitchat.models.Review;


@Repository
public interface ReviewRepo extends CrudRepository<Review, Long> {
	List<Review> findAll();
	
	
	// all comments for specific events
	List<Review> findByPoolId(Long poolId);
	
}