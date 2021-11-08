package com.silcfcr.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import javax.persistence.JoinColumn;

@Entity
@Table(name="swaps")
public class swaps {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="product_id")
	    private Product product;
}