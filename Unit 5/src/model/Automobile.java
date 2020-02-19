/*
 * Automobile.java
 * @author drishan
 * CIS 35B
 */

package model;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Automobile extends Thread implements Serializable {
	private String make;
	private String model;
	private float basePrice;
	private ArrayList<OptionSet> opSet;
	private ArrayList<Option> choice;
	private int numOpSets;

	// Constructors
	public Automobile() {
		make = "";
		model = "";
		basePrice = 0;
		opSet = new ArrayList<OptionSet>();
	}

	public Automobile(String n) {
		model = n;
		basePrice = 0;
		opSet = new ArrayList<OptionSet>();
	}

	public Automobile(String m, String n, float p, int size, ArrayList<OptionSet> oset) {
		make = m;
		model = n;
		basePrice = p;
		numOpSets = size;
		choice = new ArrayList<Option>(size);
		opSet = oset;
	}

	/**
	 * findOptionSet finds the name of an OptionSet using linear search
	 * 
	 * @param q
	 *            the search entry
	 * @return result the search result
	 */
	public synchronized OptionSet findOptionSet(String q) {
		for (int i = 0; i < numOpSets; i++) {
			if (q.equalsIgnoreCase(opSet.get(i).getOsetName())) {
				return opSet.get(i);
			}
		}
		return null;
	}

	/**
	 * findOption finds an option by using findOption method in Option class
	 * 
	 * @param q
	 *            the search entry oset the option set to search in
	 * @return result the search result
	 */
	public synchronized Option findOption(String q, OptionSet oset) {
		return oset.findOption(q);
	}

	// Getters
	public synchronized String getMake() {
		return make;
	}

	public synchronized String getModel() {
		return model;
	}

	public synchronized float getBasePrice() {
		return basePrice;
	}

	public synchronized OptionSet getOpSet(int i) {
		return opSet.get(i);
	}

	public synchronized ArrayList<OptionSet> getOpSet() {
		return opSet;
	}

	public synchronized String getOpSetName(int i) {
		return this.opSet.get(i).getOsetName();
	}
	
	public synchronized Option getOptionChoice(int index) {
		return choice.get(index);
	}
	public synchronized String getOptionName(int index) {
		return choice.get(index).getName();
	}
	public synchronized float getOptionPrice(int index) {
		return choice.get(index).getPrice();
	}
	
	public synchronized int getTotalPrice() {
		int x = 0;
		
		for (int i=0; i<numOpSets; i++) {
			x += this.getOptionPrice(i);
		}
		
		return x;
	}

	// Setters
	public synchronized void setMake(String make) {
		this.make = make;
	}

	public synchronized void setModel(String model) {
		this.model = model;
	}

	public synchronized void setBasePrice(float p) {
		basePrice = p;
	}

	public synchronized void setOpSet(ArrayList<OptionSet> oset) {
		opSet = oset;
	}

	public synchronized void setOneOpSet(OptionSet oset, int i) {
		opSet.set(i, oset);
	}

	public synchronized void setOpSetName(int i, String n) {
		this.opSet.get(i).setOsetName(n);
	}

	public synchronized void setOptionName(String n, int i, int j) {
		this.opSet.get(i).setOptionName(n, j);
	}

	public synchronized void setOptionPrice(float p, int i, int j) {
		this.opSet.get(i).setOptionPrice(p, j);
	}

	public synchronized void setOneOpSetOption(String n, float p, int i, int j) {
		this.opSet.get(i).buildOption(j, n, p);
	}

	// Update
	public synchronized void updateOpSetName(String str, String newName) {
		
	}

	public synchronized void updateOptionName(String str, String name) {
		
	}

	public synchronized void updateOptionPrice(String str, float p) {
	
	}

	// Delete
	public void deleteOptionSet(OptionSet oset) {
		oset = null;
		numOpSets--;
	}
	public void deleteOptionSet(String s) {
		numOpSets--;
	}
	public void deleteOptionSet(int i) {
		//this.opSet.get(i) = null;
	}

	public void deleteOption(OptionSet oset, int i) {
		oset.deleteOption(oset.getOptionIndex(i));
		numOpSets--;
	}

	/**
	 * print
	 * 
	 * @return r the appended StringBuilder containing Auto attributes
	 */
	public StringBuilder print() {
		StringBuilder r = new StringBuilder();
		r.append("Make: " + this.getMake());
		r.append("\nModel: " + this.getModel());
		r.append("\nPrice: " + this.getBasePrice());
		r.append("\nNumber of Option Sets: " + this.opSet.size());
		//r.append("\nTotal Price: " + this.getTotalPrice());

		for (int i = 0; i < numOpSets; i++) {
			r.append(opSet.get(i).print());
		}

		return r;
	}

	public void printMake() {
		System.out.println(make);
	}

	public void printModel() {
		System.out.println(model);
	}

	public void printBasePrice() {
		System.out.println(basePrice);
	}

	public void printMakeModel() {
		System.out.println(make + " " + model);
	}

	public void printOpSet() {
		System.out.println(opSet);
	}

	public void printOneOpSet(int i) {
		System.out.println(opSet.get(i));
	}

	public void printOption(int i, int j) {
		System.out.println(opSet.get(i).getOptionIndex(j).getName());
	}

}
