package com.example.projectui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class IssueTicketController {

    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private  TextField textfieldissue;
    @FXML
    private Label promptatissue;

    TrainDescription trainDescription= TrainDescription.getInstance();

    public void getSeatFromIssue(){
        int seat= Integer.parseInt(textfieldissue.getText());
        String seatno = Integer.toString(seat);
        if(seatno.isEmpty()){
            promptatissue.setText("Fields are empty");
            return;
        }
        trainDescription.setSeat(seat);
    }

    public void setIssueBackButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("select-train.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setbookseatsbutton(ActionEvent event) throws IOException{
        getSeatFromIssue();
        Reservation reservation=Reservation.getInstance();
        String store = reservation.setInBookingFile();
        if(!Objects.equals(store, "Success")){
            promptatissue.setText(store);
            return;
        }
        root = FXMLLoader.load(getClass().getResource("print-ticket.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
