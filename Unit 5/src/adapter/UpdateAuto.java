/*
 * UpdateAuto.java
 * @author drishan
 * CIS 35B
 */

package adapter;

public interface UpdateAuto {
	public void updateOptionSetName(String Modelname, String OptionSetname, String
			newName);
	public void updateOptionPrice(String Modelname, String Optionname, String
			Option, float newprice);
}
