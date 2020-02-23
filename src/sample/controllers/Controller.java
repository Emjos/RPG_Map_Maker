package sample.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import sample.controllers.RightClickContainer.ListOfObjects;
import sample.controllers.RightClickContainer.RightClickObject;
import sample.controllers.controllersList.actions.Action;
import sample.controllers.controllersList.actions.ActionHandle;
import sample.controllers.controllersList.items.ItemHandle;
import sample.controllers.controllersList.items.views.Item;
import sample.controllers.controllersList.monster.Monster;
import sample.controllers.controllersList.monster.MonsterHandle;
import sample.controllers.helpClass.UrlHandle;
import sample.controllers.windows.AlertWindow;

import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.Color.CYAN;
import static javafx.scene.paint.Color.SALMON;


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
    public void initialize()
    {
        addRightMenu();


    }
    ContextMenu contextMenu = new ContextMenu();
    static public Menu menuMonster = new Menu("Add Monster");
    static public Menu menuItem = new Menu("Add Item");
    static public Menu menuAction = new Menu("Add Action");
    static public MenuItem delete = new MenuItem("Delete");

    public  void addRightMenu() {
        contextMenu.getItems().add(menuMonster);
        contextMenu.getItems().add(menuItem);
        contextMenu.getItems().add(menuAction);
        contextMenu.getItems().add(delete);
    }
    public  void updateRightMenu() {
        menuMonster.getItems().clear();
        menuAction.getItems().clear();
        menuItem.getItems().clear();

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ListOfObjects.deleteItem(MapClass.index,yPosition,xPosition);
                changePhotoClear3(yPosition,xPosition,test.getbgdUrl(yPosition,xPosition,MapClass.index),test.getbgdUrl(yPosition,xPosition,MapClass.index) );
            }
        });

        for (Monster monster : MonsterHandle.monsterList) {

            MenuItem menuMonsters = new MenuItem(monster.getName());
            menuMonsters.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    RightClickObject rightClickObject = new RightClickObject(MapClass.index, MapClass.mapLists.get(MapClass.index).name, xPosition, yPosition, monster);

                    if (ListOfObjects.checkAndAdd(rightClickObject)) {
                        changePhotoClear2(yPosition, xPosition, "sample/image/objects/66.png");

                    }
                }

            });
            menuMonster.getItems().add(menuMonsters);


        }

        for (Item item : ItemHandle.itemsList) {
            MenuItem menuItems = new MenuItem(item.getName());
            menuItems.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    RightClickObject rightClickObject;
                    rightClickObject = new RightClickObject(MapClass.index, MapClass.mapLists.get(MapClass.index).name, xPosition, yPosition, item);
                    if (ListOfObjects.checkAndAdd(rightClickObject)) {
                        changePhotoClear2(yPosition, xPosition, "sample/image/objects/111.png");


                    }
                  //  MapClass.tilesList.get(MapClass.index);// aktualna mapa


                }
            });
            menuItem.getItems().add(menuItems);

        }

        for (Action action : ActionHandle.actionList)
        {
            MenuItem actionItem = new MenuItem(action.getName());
            actionItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    RightClickObject rightClickObject;
                    rightClickObject = new RightClickObject(MapClass.index, MapClass.mapLists.get(MapClass.index).name, xPosition, yPosition, action);
                    if (ListOfObjects.checkAndAdd(rightClickObject)) {
                        changePhotoClear2(yPosition, xPosition, "sample/image/objects/666.png");


                    }
                }
            });
            menuAction.getItems().add(actionItem);
        }

    }

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
        MouseButton button = event.getButton();

        xPosition = (int) (event.getX() / Tile.width);
         yPosition = (int) (event.getY() / Tile.height);
         String frontURl = "";
         String backUrl;
        System.out.println(" x " + xPosition + "= " + event.getX());
        System.out.println(" y " + yPosition + "= " + event.getY());


        if(button==MouseButton.PRIMARY) {
            contextMenu.hide();

            if (xPosition >= MapClass.width) {
                xPosition = MapClass.width - 1;
            }
            if (yPosition >= MapClass.width) {
                yPosition = MapClass.width - 1;
            }
            if (UrlHandle.tillChosee == 0) {
                int checkIsAction  = 0;
                changePhoto(yPosition, xPosition);
                for (RightClickObject r : ListOfObjects.rightClickObjectList) {
                    if (r.mapIndex == MapClass.index
                            && r.y == yPosition
                            && r.x == xPosition) {
                    checkIsAction = 1;
                    frontURl = r.frontUrl;
                    break;
                    }
                }
                if (checkIsAction == 0)
                {
                    frontURl = test.getUrl(yPosition,xPosition,MapClass.index);
                    System.out.println("CheckIsAction = 0");
                    System.out.println("Item bgd is " + test.getbgdUrl(yPosition,xPosition,MapClass.index));
                    System.out.println("Item front is " + frontURl);
                    changePhoto(yPosition, xPosition);
                }
                else {
                    System.out.println("CheckIsAction = 1");
                    System.out.println("Item bgd is " + test.getbgdUrl(yPosition,xPosition,MapClass.index));
                    System.out.println("Item front is " + frontURl);
                    changePhotoClear3(yPosition, xPosition,frontURl, UrlHandle.url);
                }
            }
            if (UrlHandle.tillChosee == 1) {

                //UrlHandle.bdgURL = MapClass.findUrl(yPosition, xPosition, MapClass.index);

                changePhotoClear3(yPosition, xPosition,UrlHandle.url,test.getbgdUrl(yPosition,xPosition,MapClass.index));
            }
        }
        else if(button==MouseButton.SECONDARY) {
            for(RightClickObject r : ListOfObjects.rightClickObjectList)
            {
                System.out.println("----");
                System.out.println(r.toString());
            }


                contextMenu.hide();
                updateRightMenu();




                tilePane.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

                    @Override
                    public void handle(ContextMenuEvent event) {

                       contextMenu.show(tilePane, event.getScreenX(), event.getScreenY());
                    }

                });


        }



    }

    void changePhoto(int x, int y) {
        tilePane.getChildren().clear();
       test.update2(x, y,UrlHandle.url, UrlHandle.url, MapClass.index);
       test.add(tilePane, MapClass.index);

    }
    void changePhotoClear(int x, int y) {

        tilePane.getChildren().clear();
        test.update2(x, y, UrlHandle.url,UrlHandle.bdgURL, MapClass.index);
        test.add(tilePane, MapClass.index);
    }
    void changePhotoClear2(int x, int y,String dgbURL) {

        tilePane.getChildren().clear();
        System.out.println(UrlHandle.url);
        String back = test.getbgdUrl(x,y,MapClass.index);
        test.update2(x, y,dgbURL,back, MapClass.index);
        test.add(tilePane, MapClass.index);
    }
    void changePhotoClear3(int x, int y,String front,String url) {

        tilePane.getChildren().clear();


        System.out.println("Front" + " " + front);
        System.out.println("Back" + " " + url);
        test.update2(x, y,front,url, MapClass.index);
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
    @FXML
    void actionOpenAction(ActionEvent event) {
        try {
            menu.setItems(Menuitems);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/actionPane.fxml"));

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
                String bgrurl = test.getbgdUrl(x, y, index);
                System.out.println(url);
                test.update2(x, y,url, bgrurl, index);

            }
        }
    }



}

