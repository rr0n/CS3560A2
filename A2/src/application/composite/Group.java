package application.composite;

import java.util.Arrays;
import java.util.List;

public class Group implements Component{

	private String groupId;
	private List<Component> childList;
	private static final boolean isLeaf = false;
	
	public Group(String groupId) {
		this.groupId = groupId;
		childList = Arrays.asList();
	}
	
	public String getId() {
		return groupId;
	}
	
	public void addComposite(Group group) {
		childList.add(group);
	}
	
	public void addLeaf(User user) {
		childList.add(user);
	}
	
	public List<Component> getChildList(){
		return childList;
	}
	
	public boolean isLeaf() {
		return isLeaf;
	}
}
