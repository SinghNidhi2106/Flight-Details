package com.myapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="JPA_BID_PRIYA44")
public class Bid {
	
	public Bid(double price) {
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SELLER_ID")
	private Long id;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name="item_id",nullable=false,updatable=false)
	private Item item;
	
	
public Bid() {
	// TODO Auto-generated constructor stub
}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bid [id=");
		builder.append(id);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
	
	public void addBidToItem(Item item)
	{
		if(item==null)
			return;
		this.item=item;
		//item.getBids().add(this);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	
}
