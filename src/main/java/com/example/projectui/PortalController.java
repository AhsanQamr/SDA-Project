package com.example.projectui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PortalController  {
    @FXML
    private Button bookingbutton;

    @FXML
    private Button calculatefarebutton;

    @FXML
    private Button cancelticketbutton;

    @FXML
    private Button issueticketbutton;

    @FXML
    private Button logoutbutton;

    @FXML
    private Button schedulebutton;

    @FXML
    private Button viewaccountbutton;

    @FXML
    private Label welcomelabel;

    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    public void initialize(){
        Passenger P1= Passenger.getInstance();
        welcomelabel.setText("Welcome "+P1.getUsername());
    }

    public void setLogoutbutton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("start-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setCalculatefarebutton(ActionEvent event) throws IOException{
        root= FXMLLoader.load(getClass().getResource("calc-fare.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setViewAccountButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("view-account.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setIssueticketbutton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("check-train.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setCancelticketbutton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("cancel-ticket.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setBookingbutton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("see-booking.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setSchedulebutton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("view-schedule.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
