/*
 * Driver.java
 * @author drishan
 * CIS 35B
 */

package driver;

import java.io.*;

import adapter.*;
import model.Automobile;
import util.FileIO;

// instantiates an Automotive object and writes it to a file
public class Driver {

	public static void main(String[] args) throws IOException {
		
		// Build auto object from file
		FileIO file = new FileIO("FordZTW.dat");
		Automobile FordZTW = file.readFile();
		
		// Print attributes before serialization
		System.out.println(FordZTW.print());
		
		// Serialize the object
		FileIO.serializeAuto(FordZTW);
		
		// Deserialize the object and read it into memory.
		Automobile newFordZTW = FileIO.deserializeAuto();
		
		// Print new attributes.
		System.out.println(newFordZTW.print());
		
		// Build using proxyauto 
		CreateAuto a1 = new BuildAuto();
		a1.buildAuto("FordZTW.dat");
		a1.printAuto("Wagon ZTW");
	}
	
}
