package com.silcfcr.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

@Entity
@Table(name="products")
public class Product {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotNull
	 @Size( max = 100 )
	 private String name;
	 
	 @NotNull
	 private String category;
	 
	 @NotNull
	 @Size( min = 5 )
	 private String description;
	 
	 private Long creatorId;
	 
	 
//	 @OneToMany(mappedBy="song", fetch = FetchType.LAZY)
//	 private List<User> contributors;
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "swaps", 
	        joinColumns = @JoinColumn(name = "product_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    private List<User> swapers;

	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getSwapers() {
		return swapers;
	}

	public void setSwapers(List<User> swapers) {
		this.swapers = swapers;
	}


	public Long getCreatorId() {
		return creatorId;
	}


	public void setCreatorId(Long creator) {
		this.creatorId = creator;
	}


	public Product() {
	}
	 
	



	public Product(@NotNull @Size(max = 100) String name, @NotNull String category,
			@NotNull @Size(min = 5) String description, Long creatorId) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.creatorId = creatorId;
	}

	@PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }

	@PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }

	
	

}
