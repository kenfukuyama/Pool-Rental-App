package com.kb.chitchat.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kb.chitchat.models.Pool;
import com.kb.chitchat.models.Review;
import com.kb.chitchat.models.User;
import com.kb.chitchat.services.PoolService;
import com.kb.chitchat.services.ReviewService;
import com.kb.chitchat.services.UserService;


@Controller
public class PoolController {
	@Autowired 
	private PoolService poolService;
	
	
	@Autowired 
	private UserService userService;
	
	
	@Autowired
	private ReviewService reviewService;
	
	
	
	   
    // ! SHOW  =================================================================
	@GetMapping("/home")
    public String home(HttpSession session, Model model, @ModelAttribute Pool pool) {
    	Long userId = (Long)session.getAttribute("userId");
    	
    	// put user back if not logged in
    	if (userId == null) {
    		return "redirect:/";
    	} 
    	
    	User user = userService.findUser(userId);
    	model.addAttribute("user", user);


    	
    	if (user.isHost()) {
    		model.addAttribute("pools", user.getPools());
    		return "dashboard.jsp";
    	}
    	else {
    		return "dashboardGuest.jsp";
    	}


    }
	
    // ! show 1 pool page
    @GetMapping("/pools/{id}/show")
    public String showPool(@PathVariable("id") Long id, Model model, HttpSession session) {
    	model.addAttribute("pool", poolService.findPool(id));
    	model.addAttribute("userId", (Long)session.getAttribute("userId"));
    	List<Review> reviews = reviewService.AllReviewsByPool(id);
    	if (reviews.size() > 0) {
    		double sum = 0;
        	for (Review review : reviews) {
        		sum += review.getRating();
        	}
        	double average = sum / reviews.size();
        	System.out.println("sum: " + sum);
        	System.out.println("average: " + average);
        	model.addAttribute("average", average);
    	} else {
    		System.out.println("it does not have reviews");
    		model.addAttribute("average", "N");
    	}
    	model.addAttribute("reviews", reviews);
    	return "showPool.jsp";
    	
    }
    
    
    @GetMapping("/pools/search")
    public String findPool(@RequestParam(value="q", required = false) String q, HttpSession session, Model model) {
    	System.out.println("you searched for " + q);
    	
    	User user = userService.findUser((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
    	
    	
    	
//    	List<Pool> pools = poolService.allPools();
    	List<Pool> pools = poolService.allPoolsByAddress(q);
    	model.addAttribute("pools", pools);
    	

    	return "pools.jsp";
    }
    
//    @GetMapping("/pools/search?=location{address}") 
//    pubic String findPool
   
	
    
	 // ! Create  =================================================================
    // ! new Pool
//    @GetMapping("/pools/add")
//    public String addPool(@ModelAttribute("pool") Pool pool, Model model,
//    		HttpSession session) {
//    	model.addAttribute("userId", (Long)session.getAttribute("userId"));
//    	
//    	
//        return "newPool.jsp";
//    }
    
    
    // ! POST new pools
    @PostMapping("/pools/add")
    public String createPool(@Valid @ModelAttribute("pool") Pool pool,
            BindingResult result, Model model, HttpSession session) {
    	
//    	poolService.checkDate(pool, result);
    	
        if (result.hasErrors()) {
        	User user = userService.findUser((Long)session.getAttribute("userId"));
        	model.addAttribute("user", user);
        	model.addAttribute("pools", user.getPools());
            return "dashboard.jsp";
        }
       
        poolService.savePool(pool);
        return "redirect:/home";
        
        
    }
  
    
    // ! GET new reviews
    @GetMapping("/pools/{id}/review")
    public String addReview(@ModelAttribute("review") Review review, BindingResult result, @PathVariable("id") Long id,
    		Model model, HttpSession session) {
    	model.addAttribute("userId", (Long)session.getAttribute("userId"));
    	model.addAttribute("pool", poolService.findPool(id));
    	
    	return "newReview.jsp";
    	
    }

    
    // ! POST new reviews
    @PostMapping("/reviews/add")
    public String createReview(@Valid @ModelAttribute("review") Review review, BindingResult result, HttpSession session, Model model) {
    	System.out.println("posting");
    	
    	if (result.hasErrors()) {
    		// TODO fix this.n redirect
        	model.addAttribute("userId", (Long)session.getAttribute("userId"));
        	model.addAttribute("pool", review.getPool());
        	return "newReview.jsp";
    		
    	}
    	
		// TODO fix this.n redirect
    	reviewService.saveReview(review);
    	return "redirect:/pools/" + review.getPool().getId() + "/show";
    }

    // ! Add connection
//    @PostMapping("/pools/addConnect")
//    public String addConnect(@RequestParam("userId") Long userId,
//    						 @RequestParam("poolId") Long poolId) {
//    	poolService.addConnect(userId, poolId);
//    	return "redirect:/home";
//    }
    
    
    
    // ! Edit =================================================================
    // ! Edit pool page
    @GetMapping("/pools/{id}/edit")
    public String editPool(@PathVariable("id") Long id, Model model, HttpSession session) {
    	// validation
    	User user = userService.findUser((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
    	model.addAttribute("pool", poolService.findPool(id));
    	
    	
    	List<Review> reviews = reviewService.AllReviewsByPool(id);
    	if (reviews.size() > 0) {
    		double sum = 0;
        	for (Review review : reviews) {
        		sum += review.getRating();
        	}
        	double average = sum / reviews.size();
        	System.out.println("sum: " + sum);
        	System.out.println("average: " + average);
        	model.addAttribute("average", average);
    	} else {
    		System.out.println("it does not have reviews");
    		model.addAttribute("average", "N");
    	}
    	model.addAttribute("reviews", reviews);
    	
    	
    	
    	return "editPool.jsp";

    }
    
    
    // Edit put request
    @RequestMapping(value="/pools/{id}", method=RequestMethod.PUT)
    public String updatePool(@Valid @ModelAttribute("pool") Pool pool, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return  "editPool.jsp";
        } else {
            poolService.savePool(pool);
            return "redirect:/home";
        }
        
        
    }
    
    
    // Delete Route ============================================================
    // basic delete
    @RequestMapping(value="/pools/{id}", method=RequestMethod.DELETE)
    public String deletePool(@PathVariable("id") Long id) {
    	poolService.deletePool(poolService.findPool(id));
    	return "redirect:/home";
    }
    

    // remove connection
//    @PostMapping("/pools/removeConnect")
//    public String removeConnect(@RequestParam("userId") Long userId, @RequestParam("poolId") Long poolId) {
//    	poolService.removeConnect(userId, poolId);
//    	return "redirect:/home";
//    }

    
    


}
