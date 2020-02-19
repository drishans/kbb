/*
 * Option.java
 * @author drishan
 * CIS 35B
 */

package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Option extends OptionSet implements Serializable {
	// Declare variables for property values
	private String name;
	private float price;
	
	// Constructor
	protected Option() {
		name = "";
		price = 0;
	}
	protected Option(String n, float p) {
		name = n;
		price = p;
	}
	
	// Getters
	protected String getOpName() {
		return name;
	}
	protected float getPrice() {
		return price;
	}
	
	// Setters
	protected void setOpName(String name) {
		this.name = name;
	}
	protected void setPrice(float price) {
		this.price = price;
	}
	
	// Instance Methods
	public StringBuilder print() {
		StringBuilder r = new StringBuilder();
		r.append("\n\t\tName of Option: " + this.getOpName());
		r.append("\n\t\tPrice: " + this.getPrice());
		return r;
	}
	
}
