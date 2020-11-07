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
import sample.io.vote.VoterIo;

import java.io.IOException;

public class Sample {
    @FXML
    private TextField idField;
    @FXML
    private Button idBtn;
    @FXML
    private Button closeBtn;

//    private Label surNameLabel;
//    private Label nameLabel;
//    private Label idLabel;
//    private Label phoneNumberLabel;

    public void OnClicked(ActionEvent event) throws IOException {


        idBtn.setVisible(false);
        //Getting the voter's ID
        String voterId = idField.getText();




        VoterIo voterIo =new VoterIo();
        //System.out.println(idField.getText());
        Voter voter = voterIo.read(voterId);
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
                    .text("invalid User.") .darkStyle()
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER)
                    .show();
        }

        idBtn.setVisible(true);
    }

    public void closeBtn(){
        // get a handle to the stage
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public static void main(String[] args){}
}
