package controller;

import com.jfoenix.controls.*;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

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
}
