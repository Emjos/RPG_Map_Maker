package sample.controllers.controllersList.monster;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controllers.Controller;
import sample.controllers.windows.AlertWindow;

import java.sql.Connection;

public class AddMonsterPane {


    @FXML
    public TextField nemeFIeld;

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
           nemeFIeld.setText(MonsterHandle.monsterHandle.getName());
           typeField.setText(MonsterHandle.monsterHandle.getType());
           descriptionField.setText(MonsterHandle.monsterHandle.getDesctiption());
           lvlField.setText(String.valueOf(MonsterHandle.monsterHandle.getLvl()));
           hitPointsField.setText(String.valueOf(MonsterHandle.monsterHandle.getHp()));
           nemeFIeld.setDisable(true);
       }
    }

    @FXML
    void closeAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        MonsterHandle.flag = 0;
        stage.close();
    }

    @FXML
    void saveAction(ActionEvent event) {
        try {


            if (Integer.parseInt(lvlField.getText()) > 0 && Integer.parseInt(lvlField.getText()) < 11) {
                int hp = Integer.parseInt(hitPointsField.getText());
                int lvl = Integer.parseInt(lvlField.getText());
                if (MonsterHandle.flag == 0) {
                    Monster monster = new Monster(nemeFIeld.getText(), typeField.getText(), hp, lvl, descriptionField.getText());
                    MonsterController.monsterItems.add(nemeFIeld.getText());
                    MonsterHandle.monsterList.add(monster);

                }

                if (MonsterHandle.flag == 1) {

                    for (Monster monster : MonsterHandle.monsterList) {

                        if (monster.getName().equals(nemeFIeld.getText())) {

                            monster.setDesctiption(descriptionField.getText()) ;
                            monster.setType(typeField.getText());
                            monster.setLvl(lvl);
                            monster.setHp(hp);


                        }

                    }
                    MonsterHandle.flag = 0;
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




