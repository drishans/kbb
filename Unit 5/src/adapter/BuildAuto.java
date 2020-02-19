/*
 * BuildAuto.java
 * @author drishan
 * CIS 35B
 */

package adapter;
import scale.EditThread;
import server.AutoServer;

public class BuildAuto extends ProxyAutomotive implements CreateAuto, UpdateAuto, EditThread, AutoServer {

}
