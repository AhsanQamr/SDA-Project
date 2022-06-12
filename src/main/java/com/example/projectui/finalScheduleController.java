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

public class finalScheduleController {

    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private Label selectarrival;

    @FXML
    private Label selectdate;

    @FXML
    private Label selectdeparture;

    @FXML
    private Label selectduration;

    @FXML
    private Label selecttrainid;

    @FXML
    private Label selecttrainname;

    TrainSchedule schedule=TrainSchedule.getInstance();
    TrainDescription description=TrainDescription.getInstance();

    @FXML
    public void initialize(){
        showScheduleInformation();
    }
    public void showScheduleInformation(){
        selecttrainid.setText(description.getTrain_id());
        selecttrainname.setText((description.getTrain_name()));
        selectdate.setText(description.getDate());
        selectduration.setText(description.getDuration());
        selectarrival.setText(schedule.getArrival_platform());
        selectdeparture.setText(schedule.getDeparture_platform());
    }
    public void setbackbuttonfinalschedule(ActionEvent event) throws IOException {
        // TrainSchedule.setArrival_platform();
        root = FXMLLoader.load(getClass().getResource("view-schedule.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
