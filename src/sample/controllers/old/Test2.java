package sample.controllers.old;

public class Test2 {

    /*
package sample.controllers;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.geometry.Pos;
public class CreateMapClass {
    private final String url =
            "sample/image/terra/1.png";
    int x;
    int y;
    Tile[][] tiles1 = new Tile[x][y];

    public CreateMapClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void create(int x, int y) {

       Tile[][] tiles = new Tile[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tiles[i][j] = new Tile(url);
                System.out.println("x " + i + " y " +j);
            }

        }
        tiles1 = tiles;




    }

    void  update (int x, int y,String  url){

       tiles1[x][y] = new Tile(url);

    }
    void add(TilePane tilePane,Tile[][] tiles,int x, int y){
       tilePane.setPrefColumns(x-1);
        tilePane.setTileAlignment(Pos.CENTER);
        tilePane.setPrefRows(y-1);
        tilePane.setVgap(2);
        tilePane.setHgap(2);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tilePane.getChildren().add(tiles[i][j]);

            }
        }

   }

    public void handle(MouseEvent event) {
        System.out.println(event.getSceneX());
        System.out.println(event.getSceneY());
        System.out.println();

    }

}

     */
}





/*
package sample.controllers;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class CreateMapClass {
    private final String url =
            "sample/image/terra/1.png";
    int x;
    int y;
    List<Tile> tileList = new ArrayList<>();

    public List<Tile> getTileList() {
        return tileList;
    }

    public void setTileList(List<Tile> tileList) {
        this.tileList = tileList;
    }

    public CreateMapClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void create(int x, int y,TilePane tilePane) {
    tilePane.getChildren().clear();

        for (int i = 0; i < x*y; i++) {

                tileList.add(new Tile(url));
            System.out.println(i);
            }

        }
    void  update (int x, int y,String  url){

       // tileList.set() = new Tile(url);

    }

    void add(TilePane tilePane,int x, int y){
       tilePane.setPrefColumns(x);
        tilePane.setTileAlignment(Pos.CENTER);
        tilePane.setPrefRows(y);
        tilePane.setVgap(2);
        tilePane.setHgap(2);

                tilePane.getChildren().addAll(tileList);

        }

   }






 */