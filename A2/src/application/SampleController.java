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
    private TreeView<String> treeView;
    
    @FXML
    private void addUser(ActionEvent event) {
    	Admin.getInstance().addUser(username.getText());
    }
    
    @FXML
    private void addGroup(ActionEvent event) {
    	Admin.getInstance().addGroup(groupName.getText());
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TreeItem node = Admin.getInstance().getForTreeView();
		treeView = new TreeView<String>(node);
		System.out.println(Admin.getInstance().getForTreeView());
	}

}
