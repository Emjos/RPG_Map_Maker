package sample.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import sample.controllers.helpClass.UrlHandle;
import sample.controllers.windows.AlertWindow;

import java.io.IOException;


public class Controller {

    private final sample.controllers.newPane newPane = new newPane();
    int xPosition;
    int yPosition;
    CreateMapClass test = new CreateMapClass();

    ObjectTilePane objectTilePane;
    ObservableList<String> Menuitems = UrlHandle.menuItems;
    @FXML
    private Button monsterOpenPane;
    @FXML
    private ScrollPane scrollPaneTiles;
    @FXML
    private Button refreshPane;
    @FXML
    private TilePane tilePane;

    @FXML
    private TilePane tileChosen;

    @FXML
    private ListView<String> menu;

    @FXML
    private Button addPane;

    @FXML
    private Button removePane;

    @FXML
    private Button upPane;

    @FXML
    private Button downPane;

    @FXML
    private MenuButton groundMenu;

    @FXML
    private MenuItem terraMenu;

    @FXML
    private MenuItem towerMenu;

    @FXML
    private MenuItem objectMenu;
    @FXML
    private MenuItem mineMenu;

    @FXML
    private MenuItem underMenu;

    @FXML
    private MenuItem castleMenu;

    @FXML
    private MenuItem houseMenu;

    @FXML
    private ScrollPane scrollPaneTilesMenu;

    @FXML
    private TilePane objectscTilePane;

    @FXML
    private Button button;


    @FXML
    private Button itemsOpenPane;

    @FXML
    private Button actionsOpenPane;

    @FXML
    private Button zoomPlusButton;

    @FXML
    private Button zoomMinusButton;

    @FXML
    void create(ActionEvent event) throws Exception {
        menu.setItems(Menuitems);
       tilePane.getChildren().clear();
        test.create(MapClass.width, MapClass.height,"terra");
        UrlHandle.menuItems.add("Index0");

       MapList map = new MapList("Test",MapClass.height,MapClass.width,"terra","test");
        MapClass.mapLists.add(map);
        test.add(tilePane,0);


    }

    @FXML
    void position(MouseEvent event) {
        xPosition = (int) (event.getX() /Tile.width);
        yPosition = (int) (event.getY() / Tile.height);
        System.out.println(" x " + xPosition + "= " +event.getX());
        System.out.println(" y " + yPosition  + "= " +event.getY());
        if(xPosition >= MapClass.width){
            xPosition = MapClass.width-1;
        }
        if(yPosition >= MapClass.width){
            yPosition= MapClass.width-1;
        }
       if (UrlHandle.tillChosee ==0) {
            changePhoto(yPosition, xPosition);
       }
        if(UrlHandle.tillChosee == 1){

             UrlHandle.bdgURL = MapClass.findUrl(yPosition,xPosition,MapClass.index);
            changePhotoClear(yPosition, xPosition);
        }

    }

    void changePhoto(int x, int y) {
        tilePane.getChildren().clear();
       test.update(x, y, UrlHandle.url, MapClass.index);
       test.add(tilePane, MapClass.index);

    }
    void changePhotoClear(int x, int y) {

        tilePane.getChildren().clear();
        test.update(x, y, UrlHandle.url, MapClass.index);
        test.add(tilePane, MapClass.index);
    }

    @FXML
    void terraAction(ActionEvent event) {


        groundMenu.setText("Terra");
    objectTilePane = new ObjectTilePane();

    objectTilePane.create("terra",objectscTilePane,68);
        UrlHandle.tillChosee = 0;
    }
    @FXML
    void mineAction(ActionEvent event) {
        groundMenu.setText("Mine");
        objectTilePane = new ObjectTilePane();
        objectTilePane.create("mines",objectscTilePane,52);
        UrlHandle.tillChosee = 0;
    }
    @FXML
    void towerAction(ActionEvent event) {
        groundMenu.setText("Tower");
        objectTilePane = new ObjectTilePane();
        objectTilePane.create("tower",objectscTilePane,65);
        UrlHandle.tillChosee = 0;
    }
    @FXML
    void objectAction(ActionEvent event) {
        groundMenu.setText("Object");
        objectTilePane = new ObjectTilePane();
        objectTilePane.create("objects",objectscTilePane,25);
        UrlHandle.tillChosee = 1;
    }
    @FXML
    void underAction(ActionEvent event) {
        groundMenu.setText("Underground");
        objectTilePane = new ObjectTilePane();
        objectTilePane.create("under",objectscTilePane,82);
        UrlHandle.tillChosee = 0;

    }
    @FXML
    void castleAction(ActionEvent event) throws Exception {
        groundMenu.setText("Castle");
        objectTilePane = new ObjectTilePane();
        UrlHandle.tillChosee = 0;
      //  objectTilePane.create("castle",objectscTilePane,68);
    }
    @FXML
    void houseAction(ActionEvent event) {
        groundMenu.setText("House");
        objectTilePane = new ObjectTilePane();
        UrlHandle.tillChosee = 0;
        objectTilePane.create("house",objectscTilePane,53);
    }

    @FXML
    void objectMouseClicked(MouseEvent event) {
        MapClass.rotate = 0;
        tileChosen.setRotate(0);
        System.out.println(UrlHandle.url);
        tileChosen.getChildren().clear();
        System.out.println("klikanie to " + MapClass.rotate);
        tileChosen.getChildren().add(MapClass.changeTille(UrlHandle.url));

    }


    @FXML
    void addPaneControll(ActionEvent event) {

        try {
            menu.setItems(Menuitems);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/addPane.fxml"));

            newPane.newPeneClass(fxmlLoader);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    @FXML
    void downAction(ActionEvent event) {
        System.out.println("przed"+MapClass.rotate);
        MapClass.rotate = MapClass.rotate + 90;
        tileChosen.setRotate(MapClass.rotate);
        System.out.println("po"+MapClass.rotate);
        if (MapClass.rotate == 360){
            MapClass.rotate = 0;
        }
    }

    @FXML
    void refreshAction(ActionEvent event) {


         int a = -1;
        a = menu.getSelectionModel().getSelectedIndex();
        if (a != -1) {
            tilePane.getChildren().clear();
            test.getSize(a);
            tillReImplement(a);

            test.add(tilePane, menu.getSelectionModel().getSelectedIndex());
            int b  = 0;
            for (MapList list : MapClass.mapLists) {
                System.out.println("index "+ b +"   "+ list.toString());
                b++;
            }

        }
    }
    @FXML
    void removeAction(ActionEvent event) {
        AlertWindow alertWindow = new AlertWindow();
        if (MapClass.mapLists.size() > 1 || MapClass.tilesList.size() > 1) {
            int index = menu.getSelectionModel().getSelectedIndex();
       menu.getItems().remove( menu.getSelectionModel().getSelectedItem());
       menu.refresh();

        MapClass.mapLists.remove(index);
        MapClass.tilesList.remove(index);
        tilePane.getChildren().clear();

                test.add(tilePane, 0);  }
            else
                alertWindow.setAlert("Its last map in that project");
        }


    @FXML
    void monsterOpenAction(ActionEvent event) {
        try {
            menu.setItems(Menuitems);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/monsterPane.fxml"));

            newPane.newPeneClass(fxmlLoader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void itemOpenAction(ActionEvent event) {
        try {
            menu.setItems(Menuitems);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/itemPane.fxml"));

            newPane.newPeneClass(fxmlLoader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void newPeneClass(FXMLLoader fxmlLoader) throws IOException {
        newPane.newPeneClass(fxmlLoader);
    }

    @FXML
    void zoomMinusAction(ActionEvent event) {

        Tile.height = Tile.height/2;
        Tile.width = Tile.width /2;

        tillReImplement(MapClass.index);

        System.out.println("Szerokosc indexu " + MapClass.width);
        System.out.println("Wyskosc indexu " + MapClass.height);

        tilePane.getChildren().clear();
        test.add(tilePane, MapClass.index);
    }

    @FXML
    void zoomPlusAction(ActionEvent event) {


        Tile.height = Tile.height*2;
        Tile.width = Tile.width *2;
        tillReImplement(MapClass.index);

        tilePane.getChildren().clear();
        test.add(tilePane, MapClass.index);
    }

    private void tillReImplement(int index) {
        for (int x = 0; x < MapClass.height; x++) {
            for (int y = 0; y < MapClass.width; y++) {
                String url = test.getUrl(x, y, index);
                System.out.println(url);
                test.update(x, y, url, index);

            }
        }
    }



}
