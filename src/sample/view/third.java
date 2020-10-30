package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class third {

        public void OnClicked(ActionEvent event) throws IOException {
            Parent thirdParent = FXMLLoader.load(getClass() .getResource("fourth.fxml"));
            Scene thirdScene = new Scene(thirdParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(thirdScene);
            window.show();


        }

    public static void main(String[] args){}
}
