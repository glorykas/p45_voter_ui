package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import sample.domain.vote.Voter;
import sample.io.vote.Voter_io;
import sample.view.Profile;

import java.io.IOException;

public class Sample {
    @FXML
    private TextField idField;
    @FXML
    private Button idBtn;

//    private Label surNameLabel;
//    private Label nameLabel;
//    private Label idLabel;
//    private Label phoneNumberLabel;

    public void OnClicked(ActionEvent event) throws IOException {


        idBtn.setVisible(false);
        //Getting the voter's ID
        String voterId = idField.getText();




        Voter_io voter_io =new Voter_io();
        //System.out.println(idField.getText());
        Voter voter = voter_io.read(voterId);
        if (voter!=null){

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Profile.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);

            Profile profile = loader.getController();
            profile.initData(voter);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
//            System.out.println(voter);
//            Parent sampleParent = FXMLLoader.load(getClass() .getResource("Profile.fxml"));
//            Scene sampleScene = new Scene(sampleParent);
//            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            window.setScene(sampleScene);
//            window.show();
        }else {
            //show a notification error and allow the user to try again.
            Notifications.create()
                    .text("User not found, try again!") .darkStyle()
                    .hideAfter(Duration.seconds(1))
                    .position(Pos.CENTER)
                    .show();


        }

        idBtn.setVisible(true);
    }

    public static void main(String[] args){}
}
