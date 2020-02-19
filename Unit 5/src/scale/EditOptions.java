/*
 * EditOptions.java
 * @author drishan
 * CIS 35B
 */

package scale;

import adapter.ProxyAutomotive;
import model.Automobile;

public class EditOptions extends ProxyAutomotive implements Runnable {
	int x;
	Automobile a1;
	Thread t1;
	Thread t2;

	public EditOptions(int x, Automobile a1) {
		this.x = x;
		this.a1 = a1;
		t1 = new Automobile();
		t2 = new Automobile();
	}
	
	public void start() {
		
	}
	
	protected void ops() {
		switch (x) {
		case 0:
			System.out.println();
			break;
		case 1:
			System.out.println();
			break;
		default:
			
		}
	}

	@Override
	public void run() {
		switch (x) {
		case 0:
			System.out.println();
			break;
		case 1:
			System.out.println();
			break;
		default:
			
		}
		
	}
	
}
