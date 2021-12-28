package controller;

import bo.BOFactory;
import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentBOImpl;
import com.jfoenix.controls.*;
import dto.StudentDTO;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    public JFXComboBox cmbCourseId1;
    public JFXTextField txtProgram1;
    public JFXTextField txtContact;
    public JFXTextField txtDuration;
    public JFXTextField txtFee1;
    public JFXCheckBox checkBox2;
    public JFXComboBox cmbCourseId2;
    public JFXTextField txtProgram2;
    public JFXTextField txtDuration2;
    public JFXTextField txtFee2;
    public JFXCheckBox checkBox3;
    public JFXComboBox cmbCourseId3;
    public JFXTextField txtProgram3;
    public JFXTextField txtDuration3;
    public JFXTextField txtFee3;
    public JFXCheckBox checkBox4;
    public JFXComboBox cmbCourseId4;
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

    public String selectGender() {
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

        if (studentBO.add(student)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Program Added").show();

        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    public void onClickClear(MouseEvent mouseEvent) {

    }

    private void loadProgramId(){
        List<String> allProgramIds = programBO.getAllProgramIds();
        cmbCourseId1.getItems().addAll(allProgramIds);
        cmbCourseId2.getItems().addAll(allProgramIds);
        cmbCourseId3.getItems().addAll(allProgramIds);
        cmbCourseId4.getItems().addAll(allProgramIds);
    }

    public void initialize() {
        loadProgramId();
    }
}
