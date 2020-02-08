package sample.controllers.controllersList.items;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controllers.controllersList.items.views.Item;

public class AddItemController {

    @FXML
    private TextField nameFIeld;

    @FXML
    private TextField typeField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private Button saveButton;

    @FXML
    private Button closeButton;

    @FXML
    public void initialize()
    {

            if(ItemHandle.flag == 1)
            {
                nameFIeld.setText(ItemHandle.itemHandle.getName());
                descriptionField.setText(ItemHandle.itemHandle.getDescription());
                typeField.setText(ItemHandle.itemHandle.getType());
                nameFIeld.setDisable(true);

            }


    }

    @FXML
    void closeAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        ItemHandle.flag = 0;
        stage.close();
    }

    @FXML
    void saveAction(ActionEvent event) {

        if (ItemHandle.flag == 0 )
        {
            nameFIeld.setDisable(true);
            Item item = new Item(nameFIeld.getText(),typeField.getText(),descriptionField.getText());
          ItemController.itemsItems.add(nameFIeld.getText());
            ItemHandle.itemsList.add(item);
        }
    if(ItemHandle.flag == 1)
    {
        for (Item item : ItemHandle.itemsList)
        {
            if (item.getName().equals(nameFIeld.getText()))
            {
                item.setDescription(descriptionField.getText());
                item.setType(typeField.getText());
            }
        }
        ItemHandle.flag = 0;
    }
            ItemHandle.flag = 0;
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();

    }

}
