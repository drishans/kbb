/*
 * FileIO.java
 * @author drishan
 * CIS 35B
 */

package util;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

import model.*;

@SuppressWarnings("serial")
public class FileIO implements Serializable {
	// Declare variables
	private String make;
	private String model;
	private float price;
	private int numOpSets;
	private FileReader fr;
	private BufferedReader buff;
	
	// Constructor
	public FileIO(String filename) {
		try {
			fr = new FileReader(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		buff = new BufferedReader(fr);
	}
	
	
	//instance methods
	public Automobile buildAutoObject(String filename) throws IOException {
		Automobile a1 = readFile();
		return a1;
	}
	
	/**
	 * readFile
	 * 		reads an input file and assigns attributes to a new auto object
	 * @param fr the file to be read
	 * @return automotive object
	 * @throws IOException
	 */
	public Automobile readFile() throws IOException {
		this.buff = new BufferedReader(fr);
		String firstLine = buff.readLine();
		String[] tokens = firstLine.split("\\|");
		make = tokens[0];
		model = tokens[1];
		price = Float.parseFloat(tokens[2]);
		numOpSets = Integer.parseInt(tokens[3]);
		//OptionSet [] opSet = new OptionSet[numOpSets];
		ArrayList<OptionSet> opSetSet = new ArrayList<OptionSet>(numOpSets);
		String opSetLine[] = new String[numOpSets];
		for(int i=0; i < numOpSets; i++) {
			opSetLine[i] = buff.readLine();
			tokens = opSetLine[i].split("\\|");
			String opSetName = tokens[0];
			// split options + prices
			int numOptions = Integer.parseInt(tokens[1]);
			// create the option set
			OptionSet opSet = new OptionSet(opSetName, numOptions);
			String options[] = tokens[2].split(":"); 
			String [] vnp = new String [1];
			String[] vn = new String[numOptions];
			float[] vp = new float[numOptions];
			for(int j = 0; j < numOptions; j++) {
				vnp = options[j].split(",");
				vn[j] = vnp[0];
				vp[j] = Float.parseFloat(vnp[1]);
				opSet.buildOption(j, vn[j], vp[j]);
			}
			opSetSet.add(opSet);
			
		}
		return new Automobile(make, model, price, numOpSets, opSetSet);
	}
	
	public void readProperties(String filename) throws IOException {
		Properties props = new Properties();
		String fileType;
		FileInputStream in = new FileInputStream(filename);
		props.load(in);
		String CarMake = props.getProperty("CarMake");
		if(!CarMake.equals(null)) {
		String CarModel = props.getProperty("CarModel");
		String Option1 = props.getProperty("Option1");
		String OptionValue1a = props.getProperty("OptionValue1a");
		String OptionValue1b = props.getProperty("OptionValue1b");
		String Option2 = props.getProperty("Option1");
		String OptionValue2a = props.getProperty("OptionValue2a");
		String OptionValue2b = props.getProperty("OptionValue2b");
		}
	}
	
	
	/**
	 * serializeAuto
	 * 		serializes the Auto instance
	 * @param a the automotive instance to be serialized
	 */
	public static void serializeAuto(Automobile a) {
		try {
			FileOutputStream fout = new FileOutputStream("serial.txt");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(a);
			oout.close();
			fout.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("--Serialized-");
		}
	}
	
	
	/**
	 * deserializeAuto
	 * 		creates an Automotive object from a serialized instance
	 * @return newAuto the deserialized object
	 */
	
	public static Automobile deserializeAuto() {
		Automobile newZTW = null;
		try {
			FileInputStream fin = new FileInputStream("serial.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			newZTW = (Automobile) oin.readObject();
			oin.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("--Deserialized--");
		}
		return newZTW;
	}

}
