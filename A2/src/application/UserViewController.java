package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.composite.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class UserViewController implements Initializable{

	private User user;

    @FXML
    private ListView<String> listView = new ListView<String>();

    @FXML
    private ListView<String> tweetView = new ListView<String>();
    
    @FXML
    private TextField inputField;
    
    @FXML
    private TextField tweet;
    
    @FXML
    void followUser(ActionEvent event) {
    	String tempString = inputField.getText();
    	user.addFollowing(tempString);
    	listView.getItems().add(tempString);
    }

    @FXML
    void postTweet(ActionEvent event) {
    	String tempString = user.getId() + " : " + tweet.getText();
    	user.addTweet(tempString);
		user.notifyObservers(tempString);
		tweetView.getItems().add(tempString);
    }
    
	public void setUser(User user) {
		this.user = user;
		//the listviewing/ updating
		for(String following: user.getFollowings()) {
			listView.getItems().add(following);
		}
		//tweet views /updating
		for(String tweets: user.getTweets()) {
			tweetView.getItems().add(tweets);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
