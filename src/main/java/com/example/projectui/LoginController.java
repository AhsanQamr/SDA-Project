package com.example.projectui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private Button cancelbutton;

    @FXML
    private Button loginbutton;

    @FXML
    private PasswordField startpswdlabel;

    @FXML
    private TextField startusernamelabel;

    @FXML
    private Button registerbutton;

    @FXML
    private TextField usernamelabel;

    @FXML
    private Button backtologinbutton;

    @FXML
    private TextField cniclabel;

    @FXML
    private TextField emaillabel;

    @FXML
    private TextField fullnamelabel;

    @FXML
    private TextField paswordlabel;

    @FXML
    private Button submitbutton;

    @FXML
    private Label promptatregister;

    @FXML
    private Label promptatlogin;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Passenger P1=Passenger.getInstance();
    public void setLoginbutton (ActionEvent event) throws IOException{
        String username= startusernamelabel.getText();
        String password= startpswdlabel.getText();
        if(Objects.equals(username, "") || Objects.equals(password, "")) {
            promptatlogin.setText("fields are empty");
        }

        String store= P1.login(username,password);
        if(!Objects.equals(store, "Success")){
            promptatlogin.setText(store);
            return;
        }

        root = FXMLLoader.load(getClass().getResource("portal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void setCancelbutton (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("start-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setRegisterbutton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("register-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /* functions related to the register page fxml file.  -> */

    public void fullnameInput(){
        String fullname;
        fullname=fullnamelabel.getText();
        P1.setFullname(fullname);
    }
    public void passwordInput(){
        String password;
        password= paswordlabel.getText();
        P1.setPassword(password);
    }
    public void usernameInput(){
        String username;
        username=usernamelabel.getText();
        P1.setUsername(username);
    }
    public void emailInput(){
        String email;
        email= emaillabel.getText();
        P1.setEmailID(email);
    }
    public void cnicInput(){
        String cnic;
        cnic= cniclabel.getText();
        P1.setCnicno(cnic);
    }

    public void setSubmitbutton(ActionEvent event) throws IOException{
        fullnameInput();
        usernameInput();
        passwordInput();
        emailInput();
        cnicInput();
        String store=P1.signUp();
        if(!Objects.equals(store, "Success")){
            promptatregister.setText(store);
            return;
        }
        // make passenger class singleton;;

        root = FXMLLoader.load(getClass().getResource("start-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setBacktologinbutton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("start-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}