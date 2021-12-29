package controller;

import bo.BOFactory;
import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentBOImpl;
import com.jfoenix.controls.*;
import dto.ProgramDTO;
import dto.StudentDTO;
import entity.Program;
import entity.Student;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author HelithaSri
 * @created 12/23/2021 - 3:19 PM
 * @project HibernateCW
 */
public class RegisterStudentController {

    public Label lblDate;
    public Label lblTime;
    public JFXTextField txtStdnRegNo;
    public JFXTextField txtName;
    public JFXTextField txtAge;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXTextField txtDOB;
    public JFXTextField txtNic;
    public JFXRadioButton txtGenderMale;
    public ToggleGroup gender;
    public JFXRadioButton txtGenderFemale;
    public JFXCheckBox checkBox1;
    public JFXComboBox<String> cmbCourseId1;
    public JFXTextField txtProgram1;
    public JFXTextField txtContact;
    public JFXTextField txtDuration;
    public JFXTextField txtFee1;
    public JFXCheckBox checkBox2;
    public JFXComboBox<String> cmbCourseId2;
    public JFXTextField txtProgram2;
    public JFXTextField txtDuration2;
    public JFXTextField txtFee2;
    public JFXCheckBox checkBox3;
    public JFXComboBox<String> cmbCourseId3;
    public JFXTextField txtProgram3;
    public JFXTextField txtDuration3;
    public JFXTextField txtFee3;
    public JFXCheckBox checkBox4;
    public JFXComboBox<String> cmbCourseId4;
    public JFXTextField txtProgram4;
    public JFXTextField txtDuration4;
    public JFXTextField txtFee4;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXButton btnAdd;
    public JFXButton btnClear;
    public TableView tblRegStudent;
    public TableColumn colStudentRegNo;
    public TableColumn colName;
    public TableColumn colAge;
    public TableColumn colAddress;
    public TableColumn colEmail;
    public TableColumn colDOB;
    public TableColumn colNic;
    public TableColumn colContact;
    public TableColumn colGender;
    public JFXTextField txtSearch;

    StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.STUDENT);
    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.PROGRAM);


    public void onKeyReleased(KeyEvent keyEvent) {

    }

    public void onClickUpdate(MouseEvent mouseEvent) {

    }

    public void onClickDelete(MouseEvent mouseEvent) {

    }

    private String selectGender() {
        if (txtGenderMale.isSelected()) {
            return "Male";
        } else if (txtGenderFemale.isSelected()) {
            return "Female";
        } else {
            return null;
        }
    }

    public void onClickAdd(MouseEvent mouseEvent) {

        StudentDTO student = new StudentDTO(
                txtStdnRegNo.getText(),
                txtName.getText(),
                Integer.parseInt(txtAge.getText()),
                txtAddress.getText(),
                txtEmail.getText(),
                txtDOB.getText(),
                txtNic.getText(),
                txtContact.getText(),
                selectGender()
        );

        /*StudentDTO student1 = new StudentDTO(
                txtStdnRegNo.getText(),
                txtName.getText(),
                Integer.parseInt(txtAge.getText()),
                txtAddress.getText(),
                txtEmail.getText(),
                txtDOB.getText(),
                txtNic.getText(),
                txtContact.getText(),
                selectGender()
        );

        Program program = new Program();
        program.getStudentList().add(student1);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(program);
        session.save(student1);

        transaction.commit();
        session.close();*/

        if (studentBO.add(student)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Program Added").show();

        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    public void onClickClear(MouseEvent mouseEvent) {

    }

    private void loadProgramId() {
        List<String> allProgramIds = programBO.getAllProgramIds();
        cmbCourseId1.getItems().addAll(allProgramIds);
        cmbCourseId2.getItems().addAll(allProgramIds);
        cmbCourseId3.getItems().addAll(allProgramIds);
        cmbCourseId4.getItems().addAll(allProgramIds);
    }

    private void checkBoxDisable() {
        cmbCourseId2.setDisable(true);
        txtProgram2.setDisable(true);
        txtDuration2.setDisable(true);
        txtFee2.setDisable(true);

        cmbCourseId3.setDisable(true);
        txtProgram3.setDisable(true);
        txtDuration3.setDisable(true);
        txtFee3.setDisable(true);

        cmbCourseId4.setDisable(true);
        txtProgram4.setDisable(true);
        txtDuration4.setDisable(true);
        txtFee4.setDisable(true);
    }

    public void onClickCheckBox(MouseEvent mouseEvent) {
        if (checkBox2.isSelected()) {
            cmbCourseId2.setDisable(false);
            txtProgram2.setDisable(false);
            txtDuration2.setDisable(false);
            txtFee2.setDisable(false);
        } else {
            cmbCourseId2.setDisable(true);
            txtProgram2.setDisable(true);
            txtDuration2.setDisable(true);
            txtFee2.setDisable(true);
        }

        if (checkBox3.isSelected()) {
            cmbCourseId3.setDisable(false);
            txtProgram3.setDisable(false);
            txtDuration3.setDisable(false);
            txtFee3.setDisable(false);
        } else {
            cmbCourseId3.setDisable(true);
            txtProgram3.setDisable(true);
            txtDuration3.setDisable(true);
            txtFee3.setDisable(true);
        }

        if (checkBox4.isSelected()) {
            cmbCourseId4.setDisable(false);
            txtProgram4.setDisable(false);
            txtDuration4.setDisable(false);
            txtFee4.setDisable(false);
        } else {
            cmbCourseId4.setDisable(true);
            txtProgram4.setDisable(true);
            txtDuration4.setDisable(true);
            txtFee4.setDisable(true);
        }
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

    /*    private void setProgramData(String programId){
        ProgramDTO programDetails = programBO.getProgramDetails(programId);

        System.out.println(programDetails);
        if (programDetails == null){
        } else {
            txtProgram1.setText(programDetails.getProgramName());
            txtDuration.setText(programDetails.getDuration());
            txtFee1.setText(programDetails.getFee()+"");
        }
    }*/

    private void setProgramData(JFXTextField enterProgram, JFXTextField enterDuration, JFXTextField enterFee, String ProgramID) {
        ProgramDTO programDetails = programBO.getProgramDetails(ProgramID);

        if (programDetails == null) {
        } else {
            enterProgram.setText(programDetails.getProgramName());
            enterDuration.setText(programDetails.getDuration());
            enterFee.setText(programDetails.getFee() + "");
        }
    }

    public void showStudentsOnTable() throws SQLException, ClassNotFoundException {

        ObservableList<StudentTM> list = studentBO.find();

        colStudentRegNo.setCellValueFactory(new PropertyValueFactory<>("regNum"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contactNum"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        tblRegStudent.setItems(list);
    }

    public void initialize() {
        loadProgramId();
        checkBoxDisable();
        loadDateAndTime();

        cmbCourseId1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgramData(txtProgram1, txtDuration, txtFee1, newValue);
        });

        cmbCourseId2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgramData(txtProgram2, txtDuration2, txtFee2, newValue);
        });

        cmbCourseId3.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgramData(txtProgram3, txtDuration3, txtFee3, newValue);
        });

        cmbCourseId4.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgramData(txtProgram4, txtDuration4, txtFee4, newValue);
        });

        try {
            showStudentsOnTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
