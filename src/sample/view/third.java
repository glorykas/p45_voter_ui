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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.domain.user.Party;
import sample.io.user.PartyIO;

import javax.swing.text.html.ListView;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class third {

    @FXML
    ListView listView;
    @FXML
    private VBox vBoxId;

    @FXML
    private Label label;

    private PartyIO partyIO = new PartyIO();


    public third() throws IOException {
    }


    public void OnClicked(ActionEvent event) throws IOException {
            Parent thirdParent = FXMLLoader.load(getClass() .getResource("fourth.fxml"));
            Scene thirdScene = new Scene(thirdParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(thirdScene);
            window.show();


        }
        public void fillTheImageView() throws IOException {
            List<Party> parties =partyIO.readAllList();
            for (int i = 0; i<parties.size();i++){
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(parties.get(i).getFlag()));
                createAnImageView(byteArrayInputStream,i,parties.get(i).getName());
            }
        }

        private void createAnImageView(ByteArrayInputStream byteArrayInputStream,int index,String partyName){
           ImageView imageView = new ImageView();
           label = new Label(partyName);
           imageView.setImage(new Image(byteArrayInputStream));
            vBoxId.getChildren().add(index, imageView);
            vBoxId.getChildren().add(label);
        }

    public static void main(String[] args){}
}
