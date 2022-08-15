package com.kb.chitchat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.chitchat.models.Pool;
import com.kb.chitchat.repositories.PoolRepo;

@Service
public class PoolService {
	@Autowired 
	private PoolRepo poolRepo;

	// for many to many
//	@Autowired
//	private UserService userService;
	
		
	// read all
	public List<Pool> allPools(){ 
		return poolRepo.findAll();
	}
	
	
	public List<Pool> allPoolsByAddress(String address){ 
		return poolRepo.findByAddressContaining(address);
	}
	
	// read one
//	public List<Pool> allPoolsOfPool(Pool pool) {
//		return poolRepo.findByPools(pool);
//	}
//	
//	public List<Pool> allPoolsNotofPool(Pool pool) {
//		return poolRepo.findByPoolsNotContains(pool);
//	}
	
	
	// Create and Update
	public Pool savePool(Pool pool) {
		return poolRepo.save(pool);
	}
	
	// delete
	public void deletePool(Pool pool) {
		poolRepo.delete(pool);
	}
	
	// read one
	public Pool findPool(Long id) {
		Optional<Pool> optionalPool = poolRepo.findById(id);
		
		if (optionalPool.isPresent()) { return optionalPool.get(); } 
		else { return null;}
	}
	
	
	
	// TODO: many to many relationship service
//	public Pool addConnect(Long userId, Long poolId) {
//		// retrieve an instance of a pool using another method in the service.
//	    Pool thisPool = findPool(poolId);
//	    User thisUser = userService.findUser(userId);
//	    // add the user to this pool's list of users
//	    thisPool.getAttendingUsers().add(thisUser);
//	    
//	    // Save thisPool, since you made changes to its user list.
//	    return poolRepo.save(thisPool);
//		
//	}
	
	
//	public Pool removeConnect(Long userId, Long poolId) {
//		// retrieve an instance of a pool using another method in the service.
//	    Pool thisPool = findPool(poolId);
//	    User thisUser = userService.findUser(userId);
//	    // add the user to this pool's list of users
//	    thisPool.getAttendingUsers().remove(thisUser);
//	    
//	    // Save thisPool, since you made changes to its user list.
//	    // TODO: don't forget this!! 
//	    return poolRepo.save(thisPool);
//		
//	}
	// ! TODO addition validation
//	public void checkDate(Pool pool, BindingResult result) {
//		System.out.println(pool.getPoolDate());
//		System.out.println(new Date());
//		
//		if (pool.getPoolDate().after(new Date())) {
//			System.out.println("it is future");
//		}
//		else {
//			System.out.println("not futre");
//		}
//	}
//	
	
}
