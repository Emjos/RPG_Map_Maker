package sample.controllers.controllersList.actions;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddActionController {

    @FXML
    private TextField nameAction;

    @FXML
    private TextArea descriptionAction;

    @FXML
    private Button saveAction;

    @FXML
    private Button closeAction;

    @FXML
    public void initialize()
    {

        if(ActionHandle.flag == 1)
        {
           nameAction.setText(ActionHandle.actionHandle.getName());
           descriptionAction.setText(ActionHandle.actionHandle.getDesription());
           nameAction.setDisable(true);
        }

    }
    @FXML
    void closeAction(ActionEvent event) {
    Stage stage = (Stage) closeAction.getScene().getWindow();
    ActionHandle.flag = 0;
    stage.close();

    }

    @FXML
    void saveAction(ActionEvent event) {
    if (ActionHandle.flag == 0)
    {
        nameAction.setDisable(true);
        Action action = new Action(nameAction.getText(),descriptionAction.getText());
        ActionController.actionAction.add(nameAction.getText());
        ActionHandle.actionList.add(action);
    }
   else if (ActionHandle.flag == 1)
   {
       for (Action action : ActionHandle.actionList)
       {
           if(action.getName().equals(nameAction.getText()))
           {
               action.setDesription(descriptionAction.getText());
           }
       }
       ActionHandle.flag = 0;
   }
    ActionHandle.flag = 0;
        Stage stage = (Stage) saveAction.getScene().getWindow();
        stage.close();


    }



}
