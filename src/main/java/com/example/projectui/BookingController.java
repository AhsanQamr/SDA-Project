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
import java.util.Objects;

public class BookingController {

    @FXML
    private Label bookarrival;

    @FXML
    private Label bookdepart;

    @FXML
    private Label bookfullname;

    @FXML
    private Label booktrainname;

    @FXML
    private Label bookseatno;

    @FXML
    private Label bookticketid;

    private Scene scene;
    private Stage stage;
    private Parent root;

    Passenger P1= Passenger.getInstance();
    Reservation reservation=Reservation.getInstance();
    FileHandler fileHandler=new FileHandler();

    private static BookingController bookingController= new BookingController();
    public static BookingController getInstance(){
        return bookingController;
    }

    @FXML
    public void initialize(){
        showBookings();
    }
    public void showBookings(){


        fileHandler.readBookingFile(P1.getCnicno());

        bookfullname.setText(reservation.getPassengerFullName());
        booktrainname.setText(reservation.getTrainID());
        //.setText(reservation.getPassengerCnic());
        bookseatno.setText(reservation.getSeatNo());
        bookticketid.setText(Integer.toString(reservation.getTicketNo()));
        bookdepart.setText(reservation.getDepartureStation());
        bookarrival.setText(reservation.getArrivalStation());
        //.setText(reservation.getFare());
    }


    public void setbackbuttonbooking(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("portal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

////    void cancelTheTicket(){
////        String store = fileHandler.cancelTicket(P1.getFullname(),Integer.toString(reservation.getTicketNo()));
////        if(Objects.equals(store, "Success")){
////            bookfullname.setText("");
////            booktrainname.setText("");
////            bookseatno.setText("");
////            bookticketid.setText("");
////            bookdepart.setText("");
////            bookarrival.setText("");
////        }
//
//    }



}
