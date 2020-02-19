/*
 * ThreadDriver.java
 * @author drishan
 * CIS 35B
 */

package driver;

import adapter.*;
import model.Automobile;
import scale.EditOptions;

public class ThreadDriver extends Thread {

	public static void main(String [] args) {
		
		CreateAuto a1 = new BuildAuto();
		a1.buildAuto("FordZTW.dat");
		
		//Thread t1 = new Thread();
		//Thread t2 = new Thread();
		
		EditOptions edit = new EditOptions(0, (Automobile) a1);
		edit.start();
		//Option color = a1;
		//edit.editColor("Ford", color);
		
		try {
			a1.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		a1.printAuto("Wagon ZTW");
		
	}
	
}
