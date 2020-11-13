package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;
import application.admin.Admin;
public class SampleController implements Initializable{

	@FXML
    private TextField username;

    @FXML
    private TextField groupName;
    
    @FXML
    private TreeView<String> treeView = new TreeView<>();
    
    @FXML
    private void addUser(ActionEvent event) {
    	Admin.getInstance().addUser(username.getText());
    	//TreeItem<String> node = Admin.getInstance().getTreeMap();
		//treeView.setRoot(node);
    }
    
    @FXML
    private void addGroup(ActionEvent event) {
    	Admin.getInstance().addGroup(groupName.getText());
    	//TreeItem<String> node = Admin.getInstance().getTreeMap();
		//treeView.setRoot(node);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TreeItem<String> node = Admin.getInstance().getTreeMap();
		treeView.setRoot(node);
	}

}
