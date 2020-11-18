package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;


import java.net.URL;
import java.util.ResourceBundle;
import application.admin.Admin;
import application.composite.Component;
import application.composite.Group;
import application.composite.User;
import application.data.UserList;
public class SampleController implements Initializable{

	private TreeItem<String> node; // current node
	private TreeItem<String> root;
	private Component component;//current component
	
	/*********************************************************************/
	
    @FXML
    private Label message;
    
	@FXML
    private TextField username;

    @FXML
    private TextField groupName;
    
    @FXML
    private TreeView<String> treeView = new TreeView<String>();
    
    @FXML
    private TextField info = new TextField();
    
    @FXML
    private Button groupButton;

    @FXML
    private Button userButton;
    
    /**********************************************************************/
    
    @FXML
    private void addUser(ActionEvent event) {
    	
    	TreeItem<String> tempNode = new TreeItem<String>(username.getText());
    	Component tempComp = new User(username.getText());
    	
    	if(component.getId() == "Root") {
    		root.getChildren().add(tempNode);
    		node = tempNode;
    		component = tempComp;
    		
    	}
    	
    	else if(!component.isLeaf()) {
    		node.getChildren().add(tempNode);
    		node = tempNode;
    		component = tempComp;
    	}
    	
    	else {
    		node.getParent().getChildren().add(tempNode);
    		node = tempNode;
    		component = tempComp;
    	}
    	Admin.getInstance().addUser(username.getText());
    }
    
    @FXML
    private void addGroup(ActionEvent event) {
    	TreeItem<String> tempNode = new TreeItem<String>(groupName.getText());
    	Component tempComp = new Group(groupName.getText());
    	
    	if(component.getId() == "Root") {
    		root.getChildren().add(tempNode);
    		node = tempNode;
    		component = tempComp;
    	}
    	
    	else if(!component.isLeaf()) {
    		node.getChildren().add(tempNode);
    		node = tempNode;
    		component = tempComp;
    	}
    	
    	else {
    		node.getParent().getChildren().add(tempNode);
    		node = tempNode;
    		component = tempComp;
    	}
    	
    	Admin.getInstance().addGroup(groupName.getText());
    }
    
    @FXML
    void showTotalGroups(ActionEvent event) {
    	int totalGroups = Admin.getInstance().getGroupSize();
    	String temp = "Total Groups:  " + Integer.toString(totalGroups);
    	info.setText(temp);
    }

    @FXML
    void showTotalUsers(ActionEvent event) {
    	int totalUsers = Admin.getInstance().getUserSize();
    	String temp = "Total Users:  " + Integer.toString(totalUsers);
    	info.setText(temp);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		root = new TreeItem<String>("Root");
		treeView.setRoot(root);
		root.setExpanded(true);
		component = new Group("Root");
		Admin.getInstance().addGroup("Root");
	}

}
