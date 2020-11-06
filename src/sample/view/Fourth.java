package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import sample.domain.vote.Vote;
import sample.io.vote.VoteIo;
import sample.io.vote.VoterIo;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;

public class Fourth {

    VoteIo voterIo = new VoteIo();
    @FXML
    private ImageView partyPicture;
    @FXML
    private Label partyName;
    @FXML
    private Image myImage;
    String partyIdString=null;


    public void initFourth(byte[] bytes, String Name,String partyId){
        System.out.println(bytes);
        partyIdString=partyId;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(bytes));
        partyPicture.setImage(new Image(byteArrayInputStream));
        partyPicture.setFitHeight(250);
        partyPicture.setFitWidth(250);
        partyName.setText(Name);
    }

    public void OnClicked(ActionEvent event){
        //Building Vote Object
        Vote vote = new Vote("",partyIdString,new Date().toString(),"");
        //Sending Vote Object to the api.
        try {
            voterIo.create(vote);
            System.out.println("New Vote: "+vote.getCandidateId()+" Party: "+partyName);
            Parent fourthParent = FXMLLoader.load(getClass() .getResource("sample.fxml"));
            Scene fourthScene = new Scene(fourthParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(fourthScene);
            window.show();

            Notifications.create()
                    .title("Confirmation of the vote")
                    .text("Successful!") .darkStyle()
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER)
                    .show();

        } catch (IOException io){
            Notifications.create()
                    .title("Confirmation of the vote Fail")
                    .text("Error!") .darkStyle()
                    .hideAfter(Duration.seconds(1))
                    .position(Pos.CENTER)
                    .show();
        }




    }


    public void GoBack(ActionEvent event) throws IOException {
//        Parent fourthParent = FXMLLoader.load(getClass() .getResource("third.fxml"));
//        Scene fourthScene = new Scene(fourthParent);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(fourthScene);
//        window.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("third.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        third profile = loader.getController();
        profile.fillTheImageView();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args){}
}
