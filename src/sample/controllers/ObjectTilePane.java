package sample.controllers;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;

import java.util.ArrayList;
import java.util.List;

public class ObjectTilePane {
    static String url = "sample/image/";
    String urlImage;
    List<Tile2> tileList = new ArrayList<>();

    void create(String ground, TilePane tilePane,int size){

        tilePane.getChildren().clear();
        for (int i = 1; i < size; i++) {
        tileList.add(new Tile2(url+ground+"/"+i+".png"));


        }
        tilePane.setPrefColumns(3);
        tilePane.setHgap(2);
        tilePane.setVgap(2);
        tilePane.setTileAlignment(Pos.CENTER);



           tilePane.getChildren().addAll(tileList);


        }


    }

