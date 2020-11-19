package application.visitor;

import java.util.ArrayList;
import java.util.List;

import application.composite.User;

public class UserVisitor implements Visitor{
	private static List<String> messages = new ArrayList<String>();

	@Override
	public void visit(User user) {
		for(String msg: user.getTweets()) {
			messages.add(msg);
		}
	}
	
	public List<String> getAllMessages(){
		return messages;
	}

}
