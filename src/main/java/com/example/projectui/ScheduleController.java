package com.example.projectui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ScheduleController {

    private Scene scene;
    private Stage stage;
    private Parent root;


    @FXML
    private Label promptviewlabel;
    @FXML
    private Label mylabel;
    @FXML
    private ChoiceBox<String> departchoicebox;
    @FXML
    private ChoiceBox<String> arrivalchoicebox;

    TrainSchedule trainSchedule=TrainSchedule.getInstance();

    private String[] Station ={"Islamabad","Lahore","Karachi","Quetta","Chaman"};
    @FXML
    public void initialize() {
        departchoicebox.getItems().addAll(Station);
        departchoicebox.setOnAction(this::DepartStationinput);

        arrivalchoicebox.getItems().addAll(Station);
        arrivalchoicebox.setOnAction(this::ArrivalStationinput);
    }
    String mydepartStation;
    public void DepartStationinput(ActionEvent event){
        mydepartStation = departchoicebox.getValue();
        mylabel.setText(mydepartStation);
        trainSchedule.setDeparture_platform(mydepartStation);
    }
    String myarrivalStation;
    public void ArrivalStationinput(ActionEvent event){
        myarrivalStation = arrivalchoicebox.getValue();
        mylabel.setText(myarrivalStation);
        trainSchedule.setArrival_platform(myarrivalStation);
    }

    // button functions
    public void setbackbuttonschedule(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("portal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setsubmitbuttonschedule(ActionEvent event) throws IOException{
        TrainSchedule schedule= TrainSchedule.getInstance();
        DepartStationinput(event);
        ArrivalStationinput(event);
        String store= schedule.seeOnlySchedule(mydepartStation, myarrivalStation);
        if(!Objects.equals(store,"Success")){
            promptviewlabel.setText(store);
            return;
        }

        root = FXMLLoader.load(getClass().getResource("final-schedule.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
