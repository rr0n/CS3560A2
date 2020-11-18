package application.composite;

public interface Component {

	public abstract String getId();
	public abstract boolean isLeaf();
	public abstract void addComposite(Group group);
	public abstract void addLeaf(User user); 

}
