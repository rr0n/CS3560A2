package application.admin;

import java.util.ArrayList;
import java.util.List;

import application.composite.*;
import application.visitor.UserVisitor;
import application.visitor.Visitable;

public class Admin {

	private static Admin pointer;
	private static boolean isInstantiated = false;
	private List<User> userList;
	private List<Group> groupList;
	
	private Admin() {
		if(!isInstantiated){
			isInstantiated = true;
			userList = new ArrayList<User>();
			groupList = new ArrayList<Group>();
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
		 Group temp = new Group(groupId);
		groupList.add(temp);
	 }

	 public void addUser(String username) {
		 userList.add(new User(username));
	 }
	 
	 public List<User> getUserList() {
		 return userList;
	 }
	 
	 public List<Group> getGroupList() {
		 return groupList;
	 }

	public int getGroupSize() {
		return groupList.size();
	}
	
	public int getUserSize() {
		return userList.size();
	}
	
	public int getTotalMessages() {
		List<String> temp = new ArrayList<>();
		UserVisitor userVisitor = new UserVisitor();
		
		for(Visitable user: userList) {
			user.accept(userVisitor);
		}
		
		temp.addAll(userVisitor.getAllMessages());
		return temp.size();
	}
	
}


