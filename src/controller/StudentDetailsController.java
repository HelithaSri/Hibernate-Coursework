package controller;

import bo.BOFactory;
import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import view.tm.ProgramTM;
import view.tm.StudentTM;

import java.sql.SQLException;
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

    public TableView<ProgramTM> tblProgram;
    public TableColumn colProgramId;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;

    public TableView<StudentTM> tblStudentDetails;
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
    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.PROGRAM);
    StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.STUDENT);


    public void btnClear(MouseEvent mouseEvent) {
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        ObservableList<StudentTM> search = studentBO.search(txtSearch.getText());
        tblStudentDetails.setItems(search);
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

    public void onMouseClickStudentTbl(MouseEvent mouseEvent) {
        StudentTM selectedItem = tblStudentDetails.getSelectionModel().getSelectedItem();
        String regNum = selectedItem.getRegNum();
        ObservableList<ProgramTM> studentPrograms = programBO.getStudentPrograms(regNum);
        tblProgram.setItems(studentPrograms);

        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        System.out.println(studentPrograms);
    }

    public void showStudentsOnTable() throws SQLException, ClassNotFoundException {

        ObservableList<StudentTM> list = studentBO.find();

        colStdnRegNo.setCellValueFactory(new PropertyValueFactory<>("regNum"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colNice.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNum"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        tblStudentDetails.setItems(list);
    }

    public void initialize(){
        loadDateAndTime();
        try {
            showStudentsOnTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ObservableList<ProgramTM> studentPrograms = programBO.getStudentPrograms("S-001");
        for (ProgramTM tm: studentPrograms){
            System.out.println(tm.getProgramName());
            System.out.println(tm.getDuration());
            System.out.println(tm.getFee());
            System.out.println(tm.getProgramId());
        }
    }

}
