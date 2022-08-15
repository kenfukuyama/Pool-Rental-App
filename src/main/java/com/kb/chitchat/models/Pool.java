package com.kb.chitchat.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

// Domain Model
@Entity // Related to databases
@Table(name="pools") // TODO: change the table name
public class Pool {
	// domain models allow us to create table
	// TODO: drop excessive tables in SQL
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id;
	
    @NotNull
    @Size(min = 3, max = 200, message="address needs to be more than 3 characters")
    private String address;
    
    
    @NotNull
    @Size(min = 3, max = 200, message="description needs to be more than 3 characters")
    private String description;
    
    
    @NotNull
    @Size(min = 3, max = 200, message="size needs to be more than 3 characters")
    private String size;
    
    @NotNull
    @DecimalMin(value = "0", message = "the cost needs to be greater than 0")
    private Double price;
    
    

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
	// before it created
    @PrePersist 
    protected void onCreate(){
        this.createdAt = new Date();
    }
    // before it updates, null at first
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
    
    // TODO: Add relationship
    // TODO: getter for setter for relationships too.
//     many to one relationship
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    // you could use thingID, but it will convert to thing_id in MySQL databases
    // TODO: Add relationship - many to many
    // TODO: getter for setter for relationships too.
    // many to one relationship

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//    		name="attendees",
//    		joinColumns = @JoinColumn(name = "pool_id"),
//    		inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
    
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//    		name="comments",
//    		joinColumns = @JoinColumn(name = "pool_id"),
//    		inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<User> CommentingUsers;
//    
  
    

	// empty public constructor
    public Pool() {}
    
    
	// TODO: 2 overloaded constructor
	public Pool(String address, String description, String size, Double price) {
		this.address = address;
		this.description = description;
		this.size = size;
		this.price = price;
	}
	
    
    
    
    // TODO: 3 add getter and setters for member variable
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}


	
	
	


}
