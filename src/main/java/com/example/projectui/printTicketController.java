package com.example.projectui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class printTicketController {
    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private Label seatno;

    @FXML
    private Label ticketno;
    @FXML
    private Label cnicticket;

    @FXML
    private Label depstticket;

    @FXML
    private Label fareticket;

    @FXML
    private Label fullnameticket;
    @FXML
    private Label arrstticket;


    @FXML
    public void initialize(){
        showTicketInformation();
    }


    public void showTicketInformation(){
        Reservation reservation=Reservation.getInstance();
        fullnameticket.setText(reservation.getPassengerFullName());
        cnicticket.setText(reservation.getPassengerCnic());
        seatno.setText(reservation.getSeatNo());
        ticketno.setText(Integer.toString(reservation.getTicketNo()));
        depstticket.setText(reservation.getDepartureStation());
        arrstticket.setText(reservation.getArrivalStation());
        fareticket.setText(reservation.getFare());
    }


    public EventHandler<ActionEvent> setPrintButtonDisplay(String title, String message)  {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setHeight(300);
        window.setWidth(300);


        Label label= new Label();
        label.setText(message);
        label.setFont(Font.font("Times new Roman", 18));
        Button closebutton = new Button("Ok");
        closebutton.setOnAction(event -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closebutton);
        layout.setAlignment(Pos.CENTER);

        Scene scene= new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return null;
    }

    public void setBackbuttonprintticket(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("issue-ticket.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setPrintbutton(ActionEvent event) throws IOException{
        setPrintButtonDisplay("Printer","Please Connect the Printer");
//        root = FXMLLoader.load(getClass().getResource("printer.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene= new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

//    public void setbackbuttonprinter(ActionEvent event) throws IOException{
//        root = FXMLLoader.load(getClass().getResource("print-ticket.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene= new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
}
