/*
 * ProxyAutomotive.java
 * @author drishan
 * CIS 35B
 */

package adapter;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import scale.EditOptions;
import model.*;
import util.*;

public abstract class ProxyAutomotive {
	
	private static LinkedHashMap<Integer, Automobile> lhm = new LinkedHashMap<Integer, Automobile>();
	private static Automobile a1;
	private static int num = 0;
	private static Map m;
	
	Set set = lhm.entrySet();
	Iterator iterator = set.iterator();
	
	
	public void editColor(String Modelname, Option newColor) {
		
		
	}

	
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName) {
		a1.updateOpSetName(Modelname, newName);
		
		EditOptions edit = new EditOptions(0, a1);
		edit.start();
		
	}

	public void updateOptionPrice(String Modelname, String Optionname, String Option, float newPrice) {
		a1.updateOptionPrice(Modelname, newPrice);
		
		EditOptions edit = new EditOptions(0, a1);
		edit.start();
		
	}

	public void buildAuto(String filename) {
		FileIO file = new FileIO(filename);
		try {
			a1 = file.readFile();
			lhm.put(num, a1);
			num++;
			m = Collections.synchronizedMap(lhm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void printAuto(String modelname) {
		System.out.println(a1.print());
	}


	public String getAllModels() {
		
		return null;
	}

}
