package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreatePaneController {
    private final sample.controllers.newPane newPane = new newPane();
    @FXML
    private Button createButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    void CreateAction(ActionEvent event) throws IOException {
        // zrobic kontener/klase ktora przechowuje wszelkie dane
        // tworzymy nowa klase z nazwy i opisu a pozniej poprzez funkcje dodajemy mapy i to wszystko przez klikniecie przyciusku dodaj!!!!
        String name = nameTextField.getText();
        String desription = descriptionTextArea.getText();
        System.out.println(name);
        System.out.println(desription);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/sample.fxml"));

        newPane.newPeneClass(fxmlLoader);
        Stage stage = (Stage) createButton.getScene().getWindow();
        stage.close();



    }

}
