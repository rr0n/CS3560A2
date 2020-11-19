package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.composite.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UserViewController implements Initializable{

	private User user;

    @FXML
    private ListView<String> listView = new ListView<String>();

    @FXML
    private TextField inputField;
    
    @FXML
    void followUser(ActionEvent event) {
    	String tempString = inputField.getText();
    	user.addFollowing(tempString);
    	listView.getItems().add(tempString);
    }

    @FXML
    void postTweet(ActionEvent event) {

    }
    
	public void setUser(User user) {
		this.user = user;
		for(String following: user.getFollowings()) {
			listView.getItems().add(following);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
