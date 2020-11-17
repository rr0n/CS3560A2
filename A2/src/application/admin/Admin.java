package application.admin;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import application.composite.*;

public class Admin {

	private static Admin pointer;
	private static boolean isInstantiated = false;
	private static Group root;
	private TreeItem<Component> treePtr;
	private TreeItem<String> forTreeView;
	
	private Admin() {
		if(!isInstantiated){
			isInstantiated = true;
			root = new Group("Root");
			treePtr = new TreeItem(root);
			forTreeView = new TreeItem("root");
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
	
	public TreeItem<Component> getTreePtr(){
		return treePtr;
	}
	
	public TreeItem<String> getForTreeView(){
		return forTreeView;
	}
	
	public void addGroup(String groupId) {
		
		TreeItem<Component> tempPtr = new TreeItem<Component>(new Group(groupId));
		
		if(!treePtr.isLeaf()) {
			
			treePtr.getChildren().add(tempPtr);
			forTreeView.getChildren().add(new TreeItem<String>(groupId));
			//treePtr = tempPtr;
		}
		else {
			treePtr.getParent().getChildren().add(tempPtr);
			forTreeView.getParent().getChildren().add(new TreeItem<String>(groupId));
			//treePtr = tempPtr;
		}
	}
	
	public void addUser(String username) {
		
		TreeItem<Component> tempPtr = new TreeItem<Component>(new User(username));
		
		if(!treePtr.isLeaf()) {
			treePtr.getChildren().add(tempPtr);
			forTreeView.getChildren().add(new TreeItem<String>(username));
			treePtr = tempPtr;
		}
		
		else {
			treePtr.getParent().getChildren().add(tempPtr);
			forTreeView.getParent().getChildren().add(new TreeItem<String>(username));
			treePtr = tempPtr;
		}
	}

}
