package sample.controllers.controllersList.monster;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controllers.windows.AlertWindow;

public class AddMonsterPane {

    @FXML
    private TextField nemeField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField hitPointsField;



    @FXML
    private TextField lvlField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private Button saveButton;

    @FXML
    private Button closeButton;

    AlertWindow alertWindow = new AlertWindow();


    @FXML
    public void initialize(){
       if(MonsterHandle.flag == 1){
           nemeField.setText(MonsterHandle.monsterHandle.name);
           typeField.setText(MonsterHandle.monsterHandle.type);
           descriptionField.setText(MonsterHandle.monsterHandle.desctiption);
           lvlField.setText(String.valueOf(MonsterHandle.monsterHandle.lvl));
           hitPointsField.setText(String.valueOf(MonsterHandle.monsterHandle.hp));
           nemeField.setDisable(true);
       }
    }

    @FXML
    void closeAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();
    }

    @FXML
    void saveAction(ActionEvent event) {
        try {


            if (Integer.parseInt(lvlField.getText()) > 0 && Integer.parseInt(lvlField.getText()) < 11) {
                int hp = Integer.parseInt(hitPointsField.getText());
                int lvl = Integer.parseInt(lvlField.getText());
                if (MonsterHandle.flag == 0) {
                    Monster monster = new Monster(nemeField.getText(), typeField.getText(), hp, lvl, descriptionField.getText());
                    MonsterController.items.add(nemeField.getText());
                    MonsterHandle.monsterList.add(monster);
                }

                if (MonsterHandle.flag == 1) {

                    for (Monster monster : MonsterHandle.monsterList) {

                        if (monster.name.equals(nemeField.getText())) {

                            monster.desctiption = descriptionField.getText();
                            monster.type = typeField.getText();
                            monster.lvl = lvl;
                            monster.hp = hp;


                        }

                    }

                }

                MonsterHandle.flag = 0;
                Stage stage = (Stage) saveButton.getScene().getWindow();
                stage.close();
                } else
                    alertWindow.setAlert("lvl need to be between 1 and 10");




        }
        catch (Exception e){

            alertWindow.setAlert("Check fields and ty again !!");
        }

    }
}




