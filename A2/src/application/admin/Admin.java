package application.admin;

import javafx.scene.control.TreeItem;
import application.composite.*;

public class Admin {

	private static Admin pointer;
	private static boolean isInstantiated = false;
	
	private Admin() {
		if(!isInstantiated){
			isInstantiated = true;
			System.out.println("Created Admin Instance");
		}
		else {
			throw new RuntimeException("Unable to create Admin Instance");
		}
	}

	
	public static Admin getInstance() {
		if(pointer == null) {
			pointer = new Admin();
		}
		return pointer;
	}
	
	public void addGroup(String groupId) {
	}



	 public void addUser(String username) {
	  
	
	  
	 }
	 

}
