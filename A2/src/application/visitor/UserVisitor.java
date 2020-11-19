package application.visitor;

import java.util.ArrayList;
import java.util.List;

import application.composite.User;

public class UserVisitor implements Visitor{
	private List<String> messages = new ArrayList<String>();

	@Override
	public void visit(User user) {
		for(String msg: user.getTweets()) {
			for(int i = 0; i < messages.size(); i++) {
				if(!(msg.equals(messages.get(i)))) {
					messages.add(msg);
				}
			}
		}
		messages.addAll(user.getTweets());
	}
	
	public List<String> getAllMessages(){
		return messages;
	}

}
