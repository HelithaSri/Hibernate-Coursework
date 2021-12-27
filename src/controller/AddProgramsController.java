package controller;

import bo.BOFactory;
import bo.custom.impl.ProgramBOImpl;
import com.jfoenix.controls.JFXTextField;
import dto.ProgramDTO;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import view.tm.ProgramTM;

import java.sql.SQLException;

/**
 * @author HelithaSri
 * @created 12/23/2021 - 7:54 PM
 * @project HibernateCW
 */
public class AddProgramsController {

    public JFXTextField txtProgramId;
    public JFXTextField txtProgram;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public TableView<ProgramTM> tblTrainingProgram;
    public TableColumn colProgramId;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;
    public JFXTextField txtSearch;
    public Label lblDate;
    public Label lblTime;

    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.PROGRAM);

    public void btnUpdate(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        ProgramDTO program = new ProgramDTO(
                txtProgramId.getText(),
                txtProgram.getText(),
                txtDuration.getText(),
                Double.parseDouble(txtFee.getText())
        );
        if (programBO.update(program)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Program Updated").show();
            showProgramsOnTable();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

    }

    public void btnDelete(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        ProgramTM selectedItem = tblTrainingProgram.getSelectionModel().getSelectedItem();
        String programId = selectedItem.getProgramId();

        if (programBO.delete(programId)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Selected Program Deleted").show();
            showProgramsOnTable();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    public void btnAdd(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        ProgramDTO program = new ProgramDTO(
                txtProgramId.getText(),
                txtProgram.getText(),
                txtDuration.getText(),
                Double.parseDouble(txtFee.getText())
        );

        if (programBO.add(program)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Program Added").show();
            showProgramsOnTable();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    public void btnClear(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        txtProgramId.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
        showProgramsOnTable();
    }

    public void onKeyReleased(KeyEvent keyEvent) {

    }

    public void showProgramsOnTable() throws SQLException, ClassNotFoundException {

        ObservableList<ProgramTM> list = programBO.find();

        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        tblTrainingProgram.setItems(list);
    }

    public void initialize() {
        try {
            showProgramsOnTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onMouseClickedTbl(MouseEvent mouseEvent) {
        try {
            ProgramTM selectedItem = tblTrainingProgram.getSelectionModel().getSelectedItem();
            txtProgramId.setText(selectedItem.getProgramId());
            txtProgram.setText(selectedItem.getProgramName());
            txtDuration.setText(selectedItem.getDuration());
            txtFee.setText(String.valueOf(selectedItem.getFee()));
        } catch (Exception e) {

        }
    }
}
