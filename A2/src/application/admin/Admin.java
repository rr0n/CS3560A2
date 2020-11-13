package application.admin;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import application.composite.*;

public class Admin {

	private static Admin pointer;
	private static boolean isInstantiated = false;
	private Group root;
	private TreeMap treeMap;
	private TreeItem<String> tree;
	
	private Admin() {
		if(!isInstantiated){
			isInstantiated = true;
			root = new Group("Root");
			treeMap = new TreeMap(root);
			tree = treeMap.getTree();
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
		root.addComponent(new Group(groupId));
	}
	
	public void addUser(String username) {
		root.addComponent(new User(username));
		//treeMap.generateTree(root);
	}
	
	public TreeItem<String> getTreeMap() {
		return tree;
	}

}
