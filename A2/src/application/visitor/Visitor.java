package application.visitor;

import application.composite.User;

public interface Visitor {

	public void visit(User user);
}
