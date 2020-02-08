package sample.controllers.controllersList.items;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ItemController {

    @FXML
    private ListView<String> itemsList;

    @FXML
    private Button newItem;

    @FXML
    private Button editItem;

    @FXML
    private Button deleteItem;

    static ObservableList<String> items = FXCollections.observableArrayList();
    @FXML
    public void initialize(){
        itemsList.setItems(items);
    }

    @FXML
    void deleteItemAction(ActionEvent event) {
        System.out.println("delete");
    }

    @FXML
    void editItemAction(ActionEvent event) {
        System.out.println("Edit");
    }

    @FXML
    void newItemAction(ActionEvent event) {
        System.out.println("New");
    }

}
