package com.example.projectui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountViewController {
    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private Label acccniclabel;

    @FXML
    private Label accemaillabel;

    @FXML
    private Label accfullnamelabel;

    @FXML
    private Label accpswdlabel;

    @FXML
    private Label accusernamelabel;

    Passenger P1=Passenger.getInstance();
    @FXML
    public void initialize(){
        showInformation();
    }
    public void showInformation(){
        String fullname = P1.getFullname();
        accfullnamelabel.setText(fullname);
        String username = P1.getUsername();
        accusernamelabel.setText(username);
        String password= P1.getPassword();
        accpswdlabel.setText(password);
        String email= P1.getEmailID();
        accemaillabel.setText(email);
        String cnic= P1.getCnicno();
        acccniclabel.setText(cnic);
    }
    public void setBackButtonviewAccount(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("portal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
