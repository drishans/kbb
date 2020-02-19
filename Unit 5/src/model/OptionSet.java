/*
 * OptionSet.java
 * @author drishan
 * CIS 35B
 */

package model;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class OptionSet extends Automobile implements Serializable{
	// Declare variables for Option properties
	private String name;
	private ArrayList<Option> opt;
	private Option choice;
	
	// Constructors
	protected OptionSet() {
		name = "";
		opt= new ArrayList<Option>();
	}
	public OptionSet(int size) {
		name = "";
		opt= new ArrayList<Option>(size);
	}
	public OptionSet(String n, int size) {
		name = n;
		opt = new ArrayList<Option>(size);
		
	}
	public OptionSet(String n, int size, String vn[], float p[]) {
		name = n;
		opt = new ArrayList<Option>(size);
		for (int i=0; i < size; i++) {
			opt.get(i).setName(vn[i]);
			opt.get(i).setPrice(p[i]);
		}
	}
	
	// Build options
	public void buildOption(int i, String n, float p) {
		opt.add(new Option(n, p));
	}
	
	// Getters
	protected String getOsetName() {
		return name;
	}
	protected ArrayList<Option> getOption() {
		return opt;
	}
	protected Option getOptionIndex(int index) {
		return opt.get(index);
	}
	protected int getOptionSize() {
		return opt.size();
	}
	protected String getOpName(int i) {
		return opt.get(i).getName();
	}
	protected float getOpPrice(int i) {
		return opt.get(i).getPrice();
	}
	
	protected Option getOptionChoice() {
		return choice;
	}
	protected String getOptionChoiceName() {
		return choice.getName();
	}
	protected float getOptionChoicePrice() {
		return choice.getPrice();
	}
	
	// Setters
	protected void setOsetName(String n) {
		name = n;
	}
	protected void setOption(ArrayList<Option> o) {
		opt = o;
	}
	protected void setOneOption(Option o, int i) {
		this.opt.set(i, o);
	}
	protected void setOptionName(String n, int i) {
		this.opt.get(i).setName(n);
	}
	protected void setOptionPrice(float p, int i) {
		this.opt.get(i).setPrice(p);
	}
	
	protected void setOptionChoice(String optionName) {
		choice = this.findOption(optionName);
	}
	
	// Update
	protected void renameOset(OptionSet o, String n) {
		o.setOsetName(n);
	}
	
	protected void deleteOption(Option o) throws ArrayIndexOutOfBoundsException {
		o = null;
	}
	
	/**
	 * findOption uses linear search to find an option in the option set
	 * @param q the search entry
	 * @return result the search result
	 */
	protected Option findOption(String q) {
		for(int i=0; i < this.opt.size(); i++) {
			if(q.equalsIgnoreCase(opt.get(i).toString())) {
				return opt.get(i);
			}
		}
		return null;
	}
	
	// Instance Methods
	public StringBuilder print() {
		StringBuilder r = new StringBuilder();
		r.append("\n\tName of Option Set: " + this.getOsetName());
		r.append("\n\tNumber of Options: " + this.opt.size());
		for (int i = 0; i < this.opt.size(); i++) {
			r.append(opt.get(i).print());
		}
		return r;
	}
	public void printOption(int i) {
		System.out.println(opt.get(i).print());
	}
	public void pringOptionName(int i) {
		System.out.println(opt.get(i).getName());
	}
	public void printOptionPrice(int i) {
		System.out.println(opt.get(i).getPrice());
	}

}
