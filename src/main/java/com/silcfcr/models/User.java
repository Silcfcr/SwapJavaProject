package com.silcfcr.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	@NotNull
	 @Size( max = 100 )
	 private String firstName;
	 
	 @NotNull
	 @Size( max = 100 )
	 private String lastName;
	 
	 @Email(message="Email must be valid")
	 private String email;
	 

	@Size(min=5, message="Password must be greater than 5 characters")
	 private String password;
	 
	 @Transient
	 private String passwordConfirmation;
	 
//	 @ManyToMany(fetch = FetchType.LAZY)
//	    @JoinTable(
//	        name = "swaps", 
//	        joinColumns = @JoinColumn(name = "user_id"), 
//	        inverseJoinColumns = @JoinColumn(name = "product_id")
//	    )
//	    private List<Product> products;
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 
	 private Date updatedAt;
	 
//	 @ManyToOne(fetch = FetchType.LAZY)
//	 @JoinColumn(name="song_id")
//	 private Song song;
//	 
	 
	public User(String firstName, String lastName,
				String email,
				String password) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
	}
		 
	public User() {
			
	}

	 public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
	@PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
	
	@PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }

}
