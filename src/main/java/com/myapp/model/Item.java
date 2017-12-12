package com.myapp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="JPA_ITEM_PRIYA44")
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(name="ITEM_NAME")
    private String name;
    
   @ElementCollection
    @CollectionTable(name="ITEM_IMAGE_COLLECTION_PRIYA", joinColumns=@JoinColumn(name="ITEM_ID"))
    @Column(name="IMAGE_NAME")
    private Set<String> images = new HashSet<>();

    
    /*@ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="ITEM_IMAGE_PRIYA44", joinColumns=@JoinColumn(name="ITEM_ID"))
    @Column(name="IMAGE_NAME")
    @OrderColumn(name= "ITEM_INDEX")
    private List<String> images = new ArrayList<String>();
    
    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="item")
    @JoinColumn(name= "ITEM_ID")
    private Set<Bid> bids = new HashSet<>();*/
    
    
    public Item(String name) {
           super();
           this.name = name;
    }

    public Item() {
           // TODO Auto-generated constructor stub
    }
    
    public long getId() {
           return id;
    }

    @SuppressWarnings("unused")
    private void setId(long id) {
           this.id = id;
    }

    public String getName() {
           return name;
    }

    public void setName(String name) {
           this.name = name;
    }

    @Override
    public String toString() {
           StringBuilder builder = new StringBuilder();
           builder.append("Item [id=");
           builder.append(id);
           builder.append(", name=");
           builder.append(name);
           builder.append(", images=");
           builder.append(images);
           builder.append("]");
           return builder.toString();
    }

/*	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}*/

    public Set<String> getImages() {
           return images;
    }

    public void setImages(Set<String> images) {
           this.images = images;
    }


}
