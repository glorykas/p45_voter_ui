package sample.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.domain.vote.Voter;

import java.io.IOException;


public class Profile {

    @FXML
    private Label surname;
    @FXML
    private Label name;
    @FXML
    private Label phone;
    @FXML
    private Label id;
    @FXML
    private ImageView profilePicture;
    @FXML
    private Image myImage;

    public void initData(Voter voter){
        surname.setText(voter.getSurname());
        name.setText(voter.getName());
        phone.setText(voter.getPhoneNumber());
        id.setText(voter.getId());

        Image image = null;
        profilePicture.setImage(null);
    }

    public void setOnAction(ActionEvent event) throws IOException {
        Parent profileParent = FXMLLoader.load(getClass() .getResource("third.fxml"));
        Scene profileScene = new Scene(profileParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(profileScene);
        window.show();


    }

    public static void main(String[] args){}
}
