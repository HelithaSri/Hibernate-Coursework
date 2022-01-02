package controller;

import bo.BOFactory;
import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentBOImpl;
import com.jfoenix.controls.*;
import dao.DAOFactory;
import dao.custom.impl.StudentDAOImpl;
import dto.ProgramDTO;
import entity.Student;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import util.Validation;
import view.tm.StudentTM;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

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
    public JFXButton btnDelete;
    public JFXButton btnAdd;
    public JFXButton btnClear;
    public TableView<StudentTM> tblRegStudent;
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
    public JFXButton btnAddNewProgram;
    String cmb1;
    String cmb2;
    String cmb3;
    String cmb4;

    StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.STUDENT);
    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.PROGRAM);
    StudentDAOImpl studentDAO = (StudentDAOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    LinkedHashMap<JFXTextField, Pattern> map = new LinkedHashMap<>();
    Pattern studentIdPattern = Pattern.compile("^(S)[-]?[0-9]{3}$");
    Pattern studentNamePattern = Pattern.compile("^[A-z ]{1,30}$");
    Pattern studentNicPattern = Pattern.compile("^[0-9]{9}[v]|[0-9]{12}$");
    Pattern address = Pattern.compile("^[A-z 0-9 \\/\\,]{2,50}[A-z 0-9]{1,50}$");
    Pattern phoneNo = Pattern.compile("^(077|071|078|075|076|072)[-]?[0-9]{7}$");
    Pattern studentAgePattern = Pattern.compile("^[0-9]{2}$");
    Pattern studentEmailPattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    Pattern studentDobPattern = Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$");

    private void storeValidations() {
        map.put(txtStdnRegNo,studentIdPattern);
        map.put(txtName,studentNamePattern);
        map.put(txtAge,studentAgePattern);
        map.put(txtAddress,address);
        map.put(txtEmail,studentEmailPattern);
        map.put(txtDOB,studentDobPattern);
        map.put(txtNic,studentNicPattern);
        map.put(txtContact,phoneNo);
    }

    public void onKeyReleased(KeyEvent keyEvent) {
        ObservableList<StudentTM> search = studentBO.search(txtSearch.getText());
        tblRegStudent.setItems(search);
    }

    /*public void onClickUpdate(MouseEvent mouseEvent) {

        Student student1 = new Student();

        student1.setRegNum(txtStdnRegNo.getText());
        student1.setName(txtName.getText());
        student1.setAge(Integer.parseInt(txtAge.getText()));
        student1.setAddress(txtAddress.getText());
        student1.setEmail(txtEmail.getText());
        student1.setDob(txtDOB.getText());
        student1.setNic(txtNic.getText());
        student1.setContactNum(txtContact.getText());
        student1.setGender(selectGender());

        if (studentDAO.updateRegister(student1,cmb1,cmb2,cmb3,cmb4)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Program Added").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

        //studentDAO.updateNativly(student1, cmb1, cmb2, cmb3, cmb4);
    }*/

    public void onClickAddNewProgram(MouseEvent mouseEvent) {
        if (studentDAO.updateNatively(txtStdnRegNo.getText(), cmb1)) {
            clear();
            new Alert(Alert.AlertType.INFORMATION, "Program Added").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    public void onClickDelete(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {

        /*
        Student student1 = new Student();

        student1.setRegNum(txtStdnRegNo.getText());
        student1.setName(txtName.getText());
        student1.setAge(Integer.parseInt(txtAge.getText()));
        student1.setAddress(txtAddress.getText());
        student1.setEmail(txtEmail.getText());
        student1.setDob(txtDOB.getText());
        student1.setNic(txtNic.getText());
        student1.setContactNum(txtContact.getText());
        student1.setGender(selectGender());

        if (studentDAO.deleteRegister(student1, cmb1, cmb2, cmb3, cmb4)) {
            showStudentsOnTable();
            new Alert(Alert.AlertType.CONFIRMATION, "Program Added").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
*/

        StudentTM selectedItem = tblRegStudent.getSelectionModel().getSelectedItem();
        String studentId = selectedItem.getRegNum();

        if (studentBO.delete(studentId)) {
            new Alert(Alert.AlertType.INFORMATION, "Deleted").show();
            showStudentsOnTable();
            clear();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

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

    public void onClickAdd(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {

        Student student1 = new Student();

        student1.setRegNum(txtStdnRegNo.getText());
        student1.setName(txtName.getText());
        student1.setAge(Integer.parseInt(txtAge.getText()));
        student1.setAddress(txtAddress.getText());
        student1.setEmail(txtEmail.getText());
        student1.setDob(txtDOB.getText());
        student1.setNic(txtNic.getText());
        student1.setContactNum(txtContact.getText());
        student1.setGender(selectGender());

        if (studentDAO.register(student1, cmb1, cmb2, cmb3, cmb4)) {
            showStudentsOnTable();
            clear();
            new Alert(Alert.AlertType.INFORMATION, "Student Registered").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

        /*
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(cmb1);
        Program program1 = session.get(Program.class, cmb1);
        Program program2 = session.get(Program.class, cmb2);
        Program program3 = session.get(Program.class, cmb3);
        Program program4 = session.get(Program.class, cmb4);
*/

        /*        if (checkBox2.isSelected()){
            student1.getProgramList().add();
        }
        if (checkBox3.isSelected()){
            student1.getProgramList().add(program3);
        }
        if (checkBox4.isSelected()){
            student1.getProgramList().add(program4);
        }*/

        /*student1.getProgramList().add(program1);

        session.save(student1);

        transaction.commit();
        session.close();*/

        /*if (studentBO.add(student1)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Program Added").show();

        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }*/


    }

    private void clear() {
        txtStdnRegNo.clear();
        txtName.clear();
        txtAddress.clear();
        txtAge.clear();
        txtEmail.clear();
        txtDOB.clear();
        txtNic.clear();
        txtContact.clear();
        txtGenderMale.setSelected(true);
        txtProgram1.clear();
        txtDuration.clear();
        txtFee1.clear();
        txtSearch.clear();
        cmbCourseId1.setValue("");
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
        checkBox4.setSelected(false);
        checkBoxDisable();
        isSelectedBox();
    }

    public void onClickClear(MouseEvent mouseEvent) {
        clear();
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

    private void isSelectedBox() {
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

            cmbCourseId2.setValue("");
            txtProgram2.clear();
            txtDuration2.clear();
            txtFee2.clear();
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

            cmbCourseId3.setValue("");
            txtProgram3.clear();
            txtDuration3.clear();
            txtFee3.clear();
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

            txtProgram4.clear();
            txtDuration4.clear();
            txtFee4.clear();
            cmbCourseId4.setValue("");
        }
    }

    public void onClickCheckBox(MouseEvent mouseEvent) {
        /*if (checkBox2.isSelected()) {
            cmbCourseId2.setDisable(false);
            txtProgram2.setDisable(false);
            txtDuration2.setDisable(false);
            txtFee2.setDisable(false);
        } else {
            cmbCourseId2.setDisable(true);
            txtProgram2.setDisable(true);
            txtDuration2.setDisable(true);
            txtFee2.setDisable(true);

            cmbCourseId2.setValue("");
            txtProgram2.clear();
            txtDuration2.clear();
            txtFee2.clear();
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

            cmbCourseId3.setValue("");
            txtProgram3.clear();
            txtDuration3.clear();
            txtFee3.clear();
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

            txtProgram4.clear();
            txtDuration4.clear();
            txtFee4.clear();
            cmbCourseId4.setValue("");
        }*/
        isSelectedBox();
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

    public void tblOnMouseClick(MouseEvent mouseEvent) {
        try {
            StudentTM selectedItem = tblRegStudent.getSelectionModel().getSelectedItem();
            txtStdnRegNo.setText(selectedItem.getRegNum());
            txtName.setText(selectedItem.getName());
            txtAge.setText(String.valueOf(selectedItem.getAge()));
            txtAddress.setText(selectedItem.getAddress());
            txtEmail.setText(selectedItem.getEmail());
            txtDOB.setText(selectedItem.getDob());
            txtNic.setText(selectedItem.getNic());
            txtContact.setText(selectedItem.getContactNum());

            //Change Male Female
            if (selectedItem.getGender().equals("Male")) {
                txtGenderMale.setSelected(true);
            } else if (selectedItem.getGender().equals("Female")) {
                txtGenderFemale.setSelected(true);
            }

        } catch (Exception e) {

        }

    }

    public void initialize() {
        loadProgramId();
        checkBoxDisable();
        loadDateAndTime();
        storeValidations();

        cmbCourseId1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgramData(txtProgram1, txtDuration, txtFee1, newValue);
            cmb1 = newValue;
        });

        cmbCourseId2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgramData(txtProgram2, txtDuration2, txtFee2, newValue);
            cmb2 = newValue;
        });

        cmbCourseId3.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgramData(txtProgram3, txtDuration3, txtFee3, newValue);
            cmb3 = newValue;
        });

        cmbCourseId4.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setProgramData(txtProgram4, txtDuration4, txtFee4, newValue);
            cmb4 = newValue;
        });

        try {
            showStudentsOnTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void studentOnKeyReleased(KeyEvent keyEvent) {
        btnAdd.setDisable(true);
        Object response = Validation.validate(map,btnAdd);
        if (keyEvent.getCode()== KeyCode.ENTER) {
            if (response instanceof TextField){
                TextField error  = (TextField) response;
                error.requestFocus();
            }else if (response instanceof Boolean){
                new Alert(Alert.AlertType.CONFIRMATION, "Done").show();
            }
        }
    }
}
