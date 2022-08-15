package com.kb.chitchat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kb.chitchat.models.Pool;


@Repository
public interface PoolRepo extends CrudRepository<Pool, Long> {
	List<Pool> findAll();
	
	
	List<Pool> findByAddressContaining(String address);
	
}