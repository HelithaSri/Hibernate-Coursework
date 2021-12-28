package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author HelithaSri
 * @created 12/23/2021 - 9:25 PM
 * @project HibernateCW
 */
public class StudentDetailsController {

    public Label lblDate;
    public JFXTextField txtSearch;

    public TableView tblProgram;
    public TableColumn colProgramId;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;

    public TableView tblStudentDetails;
    public TableColumn colStdnRegNo;
    public TableColumn colName;
    public TableColumn colAge;
    public TableColumn colAddress;
    public TableColumn colEmail;
    public TableColumn colDob;
    public TableColumn colNice;
    public TableColumn colContact;
    public TableColumn colGender;

    public Label lblTime;

    public void btnClear(MouseEvent mouseEvent) {
    }

    public void onKeyReleased(KeyEvent keyEvent) {
    }

    private void loadDateAndTime() {
        // load Date
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy.MM.dd");
        lblDate.setText(f.format(date));

        // load Time
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    public void initialize(){
        loadDateAndTime();
    }
}
