package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author HelithaSri
 * @created 12/23/2021 - 3:17 PM
 * @project HibernateCW
 */
public class BaseController {
    public AnchorPane rightMainAnchor;

    public void btnRegisterStudent(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane;
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/RegisterStudent.fxml"));
        pane = fxmlLoader.load();
        rightMainAnchor.getChildren().setAll(pane);
    }

    public void btnAddPrograms(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane;
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/AddPrograms.fxml"));
        pane = fxmlLoader.load();
        rightMainAnchor.getChildren().setAll(pane);
    }

    public void btnStudentDetails(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane;
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/StudentDetails.fxml"));
        pane = fxmlLoader.load();
        rightMainAnchor.getChildren().setAll(pane);
    }

    public void btnSignOut(MouseEvent mouseEvent) {
        Stage window = (Stage) rightMainAnchor.getScene().getWindow();
        window.close();
    }
}
