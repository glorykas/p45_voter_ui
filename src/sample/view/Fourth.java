package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


import java.io.IOException;

public class Fourth {


    public void OnClicked(ActionEvent event) throws IOException {


        Parent fourthParent = FXMLLoader.load(getClass() .getResource("sample.fxml"));
        Scene fourthScene = new Scene(fourthParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(fourthScene);
        window.show();

        Notifications.create()
                .title("Confirmation of the vote")
                .text("Successful!") .darkStyle()
                .hideAfter(Duration.seconds(1))
                .position(Pos.CENTER)
                .show();


    }


    public void GoBack(ActionEvent event) throws IOException {
        Parent fourthParent = FXMLLoader.load(getClass() .getResource("third.fxml"));
        Scene fourthScene = new Scene(fourthParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(fourthScene);
        window.show();

    }

    public static void main(String[] args){}
}
