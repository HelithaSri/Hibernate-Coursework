package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

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
}
