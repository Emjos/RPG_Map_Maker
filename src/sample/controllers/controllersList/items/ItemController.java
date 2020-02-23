package sample.controllers.controllersList.items;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import sample.controllers.helpClass.newPane;

import java.io.IOException;

public class ItemController {
    private final sample.controllers.helpClass.newPane newPane = new newPane();
    @FXML
    private ListView<String> itemsList;

    @FXML
    private Button newItem;

    @FXML
    private Button editItem;

    @FXML
    private Button deleteItem;

    static ObservableList<String> itemsItems = FXCollections.observableArrayList();
    @FXML
    public void initialize(){
        itemsList.setItems(itemsItems);
    }




    @FXML
    void deleteItemAction(ActionEvent event)

    {
        if(ItemHandle.itemsList.size() !=0)
        {
            String itemName = itemsList.getSelectionModel().getSelectedItem();
            ItemHandle.delete(itemName);
            itemsList.getItems().remove(itemName);

        }
    }




    @FXML
    void editItemAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/addItemPane.fxml"));
        ItemHandle.flag = 1;
        ItemHandle.find(itemsList.getSelectionModel().getSelectedItem());
        newPane.newPeneClass(fxmlLoader);
    }

    @FXML
    void newItemAction(ActionEvent event) throws Exception
    {
        ItemHandle.flag = 0;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/addItemPane.fxml"));

        newPane.newPeneClass(fxmlLoader);

    }

}
