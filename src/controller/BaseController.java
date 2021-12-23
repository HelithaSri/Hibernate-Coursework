package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
}
