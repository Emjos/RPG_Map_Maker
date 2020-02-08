package sample.controllers.controllersList.monster;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import sample.controllers.helpClass.newPane;

import java.io.IOException;

public class MonsterController {


    private final sample.controllers.helpClass.newPane newPane = new newPane();
    @FXML
    private ListView<String> monsterLists;
    @FXML
    private Button newMonster;

    @FXML
    private Button editMonster;

    @FXML
    private Button deleteMonster;

    static ObservableList<String> monsterItems = FXCollections.observableArrayList();

 @FXML
 public void initialize(){
     monsterLists.setItems(monsterItems);
 }


    @FXML
    void deleteMosterAction(ActionEvent event) {

            if(MonsterHandle.monsterList.size() != 0) {

             MonsterHandle.delete(monsterLists.getSelectionModel().getSelectedItem());
             monsterLists.getItems().remove(monsterLists.getSelectionModel().getSelectedItem());

         }

    }

    @FXML
    void editMonsterAction(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/addMonsterPane.fxml"));
        MonsterHandle.flag = 1;
        String name = monsterLists.getSelectionModel().getSelectedItem();
        MonsterHandle.find(name);
        newPane.newPeneClass(fxmlLoader);




    }

    @FXML
    void newMonsterAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/addMonsterPane.fxml"));

            newPane.newPeneClass(fxmlLoader);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }





     void newPeneClass(FXMLLoader fxmlLoader) throws IOException {

         newPane.newPeneClass(fxmlLoader);
     }

}
