package controller;

import bo.BOFactory;
import bo.custom.impl.ProgramBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ProgramDTO;
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
import view.tm.ProgramTM;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

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
    public JFXButton btnAdd;

    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BoTypes.PROGRAM);

    LinkedHashMap<JFXTextField, Pattern> map = new LinkedHashMap<>();
    Pattern courserIdPattern = Pattern.compile("^(P)[-]?[0-9]{3}$");
    Pattern courserNamePattern = Pattern.compile("^[A-z ]{1,30}$");
    Pattern courserDurationPattern = Pattern.compile("^[A-z 0-9 ]{1,10}$");
    Pattern courserFeePattern = Pattern.compile("^(?:0|[1-9]\\d*)(?:\\.(?!.*000)\\d+)?$");

    private void storeValidations() {
        map.put(txtProgramId,courserIdPattern);
        map.put(txtProgram,courserNamePattern);
        map.put(txtDuration,courserDurationPattern);
        map.put(txtFee,courserFeePattern);

    }

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
        clear();
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
        clear();
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
        clear();
    }

    public void clear() throws SQLException, ClassNotFoundException {
        txtProgramId.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
        txtSearch.clear();
        showProgramsOnTable();
    }

    public void btnClear(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        /*txtProgramId.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
        showProgramsOnTable();*/
        clear();

        /*

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//        Query query = session.createQuery("from Program c WHERE oprogramId LIKE '%P-002'");

//        query.setParameter(1,"P-001");
//        query.list();
//        List<ProgramTM> list = session.createQuery(query);
//
//
//        for(ProgramTM owner : list) {
//            System.out.print(owner.getProgramId() + " : ");
//            System.out.println(owner.getProgramName());
//        }

        String s = "1";
//        String hql = "SELECT p.programId FROM Program p WHERE p.programId = :s";
        Query query = session.createQuery("FROM Program p WHERE p.programId LIKE ?1");
        query.setParameter(1, '%' + s + '%');
//        String hql = "SELECT p.programId FROM Program p WHERE p.programId = s";
        */
        /*List <Program> result = session.createQuery(hql).list();*//*

//        for(Program owner : result) {
//            System.out.println("hello3");
//            System.out.print(owner.getProgramId() + " : ");
//        }

        System.out.println(query.list());


//        Query query = session.createQuery(hql);
//        query.list();
//        System.out.println("hello1");
//        List <Program> result = session.createQuery(hql).list();
//        System.out.println("hello2");
//        for(Program owner : result) {
//            System.out.println("hello3");
//            System.out.print(owner.getProgramId() + " : ");
//            System.out.println(owner.getProgramName());
//        }
//        System.out.println("hello4");
        transaction.commit();
        session.close();
*/

    }

    public void onKeyReleased(KeyEvent keyEvent) {
        ObservableList<ProgramTM> search = programBO.search(txtSearch.getText());
        tblTrainingProgram.setItems(search);
    }

    public void showProgramsOnTable() throws SQLException, ClassNotFoundException {

        ObservableList<ProgramTM> list = programBO.find();

        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        tblTrainingProgram.setItems(list);
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

    public void initialize() {
        try {
            showProgramsOnTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        loadDateAndTime();
        storeValidations();
    }

    public void courseKeyRelease(KeyEvent keyEvent) {
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
