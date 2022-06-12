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


public class AfterFareController {

    Scene scene;
    Stage stage;
    Parent root;


    @FXML
    private Label fare;

    @FXML
    private Label farearrivalst;

    @FXML
    private Label faredepartst;

    @FXML
    private Label faretrainname;

    TrainSchedule schedule=TrainSchedule.getInstance();
    TrainDescription description=TrainDescription.getInstance();

    @FXML
    public void initialize(){
        showScheduleInformation();
    }

    public void showScheduleInformation(){
        faretrainname.setText((description.getTrain_name()));
        farearrivalst.setText(schedule.getArrival_platform());
        faredepartst.setText(schedule.getDeparture_platform());
        fare.setText(description.getFare());
    }

    public void setBackButtoninCalcFare(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("calc-fare.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
