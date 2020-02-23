
package sample.controllers.controllersList.actions;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.control.Button;
        import javafx.scene.control.ListView;
        import sample.controllers.helpClass.newPane;

        import java.io.IOException;

public class ActionController {

    @FXML
    private ListView<String> actionList;

    @FXML
    private Button newAction;

    @FXML
    private Button editAction;

    @FXML
    private Button deleteAction;

    static ObservableList<String> actionAction = FXCollections.observableArrayList();
    private final sample.controllers.helpClass.newPane newPane = new newPane();

    @FXML
    public void initialize()
    {
        actionList.setItems(actionAction);
    }

    @FXML
    void deleteActionAction(ActionEvent event) {
    String actionName = actionList.getSelectionModel().getSelectedItem();
    ActionHandle.delete(actionName);
    actionList.getItems().remove(actionName);
    }

    @FXML
    void editActionAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/addActionPane.fxml"));

        ActionHandle.flag = 1;
        ActionHandle.find(actionList.getSelectionModel().getSelectedItem());
        newPane.newPeneClass(fxmlLoader);
    }

    @FXML
    void newActionAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/addActionPane.fxml"));
        ActionHandle.flag = 0;
        newPane.newPeneClass(fxmlLoader);
    }

}
