package sample.view;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.domain.user.Party;
import sample.domain.vote.Vote;
import sample.io.user.PartyIO;

import javax.swing.*;
import javax.swing.text.html.ListView;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class third {
    @FXML
    ListView listView;
    @FXML
    private VBox vBoxId;
    @FXML
    private Label label;

    DropShadow shadow = new DropShadow();
    Group root = new Group();

    private PartyIO partyIO = new PartyIO();

    public third() throws IOException {
    }

//    public void OnClicked(ActionEvent event) throws IOException {
//            Parent thirdParent = FXMLLoader.load(getClass() .getResource("fourth.fxml"));
//            Scene thirdScene = new Scene(thirdParent);
//            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            window.setScene(thirdScene);
//            window.show();
//        }
        public void fillTheImageView() throws IOException {
            List<Party> parties =partyIO.readAllList();
            for (int i = 0; i<parties.size();i++){
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(parties.get(i).getFlag()));
                    createAnImageView(byteArrayInputStream,parties.get(i).getFlag(),parties.get(i).getName(), parties.get(i).getId(), parties.get(i));
                    System.out.println(parties.get(i).getName());
                }catch (NullPointerException n){
                    System.out.println(parties.get(i).getName());
                }
            }
        }
        private void createAnImageView(ByteArrayInputStream byteArrayInputStream,byte[] image,String partyName,String partyId,Party party){
            ImageView imageView = new ImageView();
            imageView.setId(party.getId());
            selectParty(imageView,partyName, partyId,image);
            label = new Label(partyName);
            imageView.setImage(new Image(byteArrayInputStream));
            imageView.setFitHeight(175);
            imageView.setFitWidth(200);
            vBoxId.getChildren().add(imageView);
            vBoxId.getChildren().add(label);
            vBoxId.setLayoutX(5);
            vBoxId.setSpacing(10);
            ScrollBar scroll = new ScrollBar();
            scroll.setMin(0);
            scroll.setOrientation(Orientation.VERTICAL);
            scroll.setPrefHeight(200);
            scroll.setPrefWidth(20);
            scroll.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                vBoxId.setLayoutY(-new_val.doubleValue());
            });



        }

    private void selectParty(ImageView imageView,String partyName,String partyId,byte[] image){
        imageView.setPickOnBounds(true);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Vote vote = new Vote("",partyId,new Date().toString(),"");
                System.out.println("New Vote: "+vote.getCandidateId()+" Party: "+partyName);
                try {
                    toConfirm(event.getSource(),image,partyName,partyId);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void toConfirm(Object object,byte[] byteArrayInputStream,String partyName,String partyId) throws IOException {
        ActionEvent event = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass() .getResource("fourth.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Fourth fourth = loader.getController();
        fourth.initFourth(byteArrayInputStream,partyName,partyId);
        Stage window = (Stage) ((Node) object).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
//    public void addScrollbar(){
//        ScrollBar sc = new ScrollBar();
//        sc.setMin(0);
//        sc.setMax(300);
//        sc.setValue(50);
//
//        shadow.setColor(Color.GREY);
//        shadow.setOffsetX(2);
//        shadow.setOffsetY(2);
//
//        vBoxId.setLayoutX(5);
//        vBoxId.setSpacing(10);
//
//        //sc.setLayoutX(scene.getWidth()-sc.getWidth());
//        sc.setMin(0);
//        sc.setOrientation(Orientation.VERTICAL);
//        sc.setPrefHeight(180);
//        sc.setMax(360);
//
//        root.getChildren().addAll(vBoxId, sc);
//
//    }



    public static void main(String[] args){}
}
