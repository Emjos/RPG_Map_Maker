package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.controllers.helpClass.UrlHandle;
import sample.controllers.windows.AlertWindow;

public class AddPaneController {
    static Stage stage;
String name = "1";
int height = 2;
int width = 3;
String scene = "4";
String description = "5";
    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField heightSize;

    @FXML
    private TextField widthSize;

    @FXML
    private MenuButton groundMenu;

    @FXML
    private MenuItem terraMenu;

    @FXML
    private MenuItem towerMenu;

    @FXML
    private MenuItem mineMenu;

    @FXML
    private MenuItem underMenu;

    @FXML
    private MenuItem castleMenu;

    @FXML
    private MenuItem houseMenu;

    @FXML
    private TextArea discriptionText;

    @FXML
    private TextField mapNameText;
    @FXML
    void closeAction(MouseEvent event) {
    stage.close();
    }


    @FXML
    void saveAction(MouseEvent event) {
        CreateMapClass test = new CreateMapClass();
        try {
            name = mapNameText.getText();
            height = Integer.parseInt(heightSize.getText());
            width = Integer.parseInt(widthSize.getText());
            description = discriptionText.getText();

            if (height >0 && width > 0) {

                test.create(height, width, scene);
                stage.close();
                MapList map = new MapList(name, height, width, scene, description);
                MapClass.mapLists.add(map);
                UrlHandle.menuItems.add(name);
            }
            else
                height = Integer.parseInt("a");
        }
        catch (Exception e){
            AlertWindow alertWindow = new AlertWindow();
            alertWindow.setAlert("Height or Width need to be numbers and need to be more then 0");
            heightSize.setText("1");
            widthSize.setText("1");
        }


    }



    @FXML
    void castleAction(ActionEvent event) {
        groundMenu.setText("Castle");
        scene = "castle";
    }

    @FXML
    void houseAction(ActionEvent event) {
        groundMenu.setText("House");
        scene = "house";
    }

    @FXML
    void mineAction(ActionEvent event) {
        groundMenu.setText("Mine");
        scene = "mines";
    }

    @FXML
    void terraAction(ActionEvent event) {
        groundMenu.setText("Terra");
        scene = "terra";
    }
    @FXML
    void smallTerraAction(ActionEvent event) {
        groundMenu.setText("Small Terra");
        scene = "terraSmall";
    }
    @FXML
    void towerAction(ActionEvent event) {
        groundMenu.setText("Tower");
        scene = "tower";
    }

    @FXML
    void underAction(ActionEvent event) {
        groundMenu.setText("Underground");
        scene = "under";
    }

}


