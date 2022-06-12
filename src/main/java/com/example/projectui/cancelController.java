package com.example.projectui;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class cancelController {

    @FXML
    private TextField fullnamelabel;

    @FXML
    private TextField ticketnolabel;

    @FXML
    private Button submitbuttoncancel;
    @FXML
    private Label promptatcancel;

    private Scene scene;
    private Stage stage;
    private Parent root;

    public void setcancelticketbutton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("portal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setSubmitButtonCancel(ActionEvent event) throws IOException{
        submitbuttoncancel.setOnAction(setsubmitbuttondisplay("Cancel Ticket","Your Ticket has been cancelled!"));

    }

    public EventHandler<ActionEvent> setsubmitbuttondisplay(String title, String message)  {
        String fullname= fullnamelabel.getText();
        String ticketno= ticketnolabel.getText();

        if(Objects.equals(fullname, "") || Objects.equals(ticketno, "")){
            promptatcancel.setText("Fields are empty");
            return null;
        }
        else{
            Ticket ticket= Ticket.getInstance();
            String store= ticket.cancelTicket(fullname,ticketno);
            if(!Objects.equals(store, "Success")){
                promptatcancel.setText(store);
                return null;
            }
        }

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

    public void setcancelbackutton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("portal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
