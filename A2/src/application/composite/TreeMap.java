package application.composite;

import java.util.List;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeMap {

//	TreeItem<String> root = new TreeItem<>("RootItem");
//	TreeItem<String> treeItem1 = new TreeItem<>("treeItem1");
//	TreeItem<String> treeItem2 = new TreeItem<>("treeItem2");
//	TreeItem<String> treeItem3 = new TreeItem<>("treeItem3");
//	root.getChildren().add(treeItem1);
//	root.getChildren().add(treeItem2);
//	root.getChildren().add(treeItem3);
//	
//	treeview.setRoot(root);
	
	private TreeItem<Group> composite;
	private static TreeItem<String> tree;
	private TreeView<String> treeView;
	
	public TreeMap(Group root) {
		treeView = new TreeView<String>();
		tree = new TreeItem<String>(root.getId());
		generateTree(root);
	}
	
	public void generateTree(Group comp) {
		List<Component> tempGroupList = comp.getChildList();
		composite = new TreeItem<Group>(comp); //treeItem
		TreeItem<String> tempChild;
		for(int i = 0; i < tempGroupList.size(); i++) {
			if(tempGroupList.get(i).isLeaf()) {
				tempChild = new TreeItem<String>(tempGroupList.get(i).getId());
				tree.getChildren().add(tempChild);
			}
			else {
				Group tempGroup = composite.getValue();
				tempChild = new TreeItem<String>(tempGroupList.get(i).getId());
				tree.getChildren().add(tempChild);
				generateTree(tempGroup);
			}
		}
		//treeView.setRoot(tree);
	}
	
	public TreeItem<String> getTree() {
		return tree;
	}
}
