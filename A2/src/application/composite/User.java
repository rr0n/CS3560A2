package application.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.admin.Admin;
import application.observer.*;

public class User implements Component, Subject, Observer{

	private List<Observer> observers = new ArrayList<Observer>();
	private String username;
	private List<String> followers;
	private List<String> followings;
	private List<String> messages;
	private static final boolean isLeaf = true;
	
	public User(String username) {
		this.username = username;
		followers = new ArrayList<String>();
		followings = new ArrayList<String>();
		messages = new ArrayList<String>();
	}
	
	public String getId() {
		return username;
	}
	
	public void addFollower(String userId) {
		for(User user: Admin.getInstance().getUserList()) {
			if(user.getId().equals(userId));
			followers.add(userId);
		}
	}
	
	public void addFollowing(String userId) {
		followings.add(userId);
		for(User user: Admin.getInstance().getUserList()) {
			if(user.getId().equals(userId)) {
				user.addFollower(this.getId());
				user.attach(this);
			}
		}
	}
	
	public boolean isLeaf() {
		return isLeaf;
	}

	public List<String> getFollowers(){
		return followers;
	}
	
	public List<String> getFollowings(){
		return followings;
	}
	/******************************************************/
	public void addComposite(Group group) {}

	public void addLeaf(User user) {}

	/*****************************************************/
	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update(this);
		}
	}

	@Override
	public void update(Subject subject) {
		if(subject instanceof User) {
			this.addFollower(subject.getId());
		}
	}
	
	
}
