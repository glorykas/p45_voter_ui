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
import org.apache.commons.io.FileUtils;
import sample.domain.vote.Voter;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;


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

    public void initData(Voter voter) throws IOException {
        surname.setText(voter.getSurname());
        name.setText(voter.getName());
        phone.setText(voter.getPhoneNumber());
        id.setText(voter.getId());
        byte[] image = voter.getImage();
        System.out.println(image);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(voter.getImage()));
        profilePicture.setImage(new Image(byteArrayInputStream));
    }

    public void setOnAction(ActionEvent event) throws IOException {

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
