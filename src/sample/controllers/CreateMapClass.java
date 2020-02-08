package sample.controllers;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.geometry.Pos;
import sample.controllers.helpClass.UrlHandle;

public class CreateMapClass {

    int x;
    int y;
    Tile[][] tiles1 = new Tile[x][y];

    public CreateMapClass(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public CreateMapClass(){}

    void create(int x, int y,String url) {
        String fullUrl= "sample/image/"+url+"/1.png";
        Tile[][] tiles = new Tile[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tiles[i][j] = new Tile(fullUrl);
                System.out.println("x " + i + " y " +j);
            }

        }

        MapClass.tilesList.add(tiles);




    }



    void getSize(int index){
        tiles1 = MapClass.tilesList.get(index);
        MapClass.height = tiles1.length;
        MapClass.width = tiles1[0].length;
    }
    String getUrl(int x, int y, int index){
        tiles1 = MapClass.tilesList.get(index);
        return tiles1[x][y].urlImage;
    }

    void  update (int x, int y,String  url,int index){
        tiles1 =    MapClass.tilesList.get(index);
        System.out.println("x to " + x);
        System.out.println("Y to " + y);

        tiles1[x][y] = null;
        tiles1[x][y] = MapClass.changeTille(url);
        if (UrlHandle.tillChosee == 1) {
            String style = "-fx-background-image: url("+UrlHandle.bdgURL+");"+
                    "-fx-background-size: cover;";

            tiles1[x][y].setStyle(style); // przezroczystosc do zdjec z objects
        }

        MapClass.tilesList.set(index,tiles1);

    }
    void add(TilePane tilePane,int index){
        Tile[] [] tileTest =   MapClass.tilesList.get(index);
        int x = tileTest.length;
        int y = tileTest[0].length;
        tilePane.setPrefColumns(y);

      tilePane.setPrefTileHeight(Tile.height);
      tilePane.setPrefTileWidth(Tile.width);
        tilePane.setPrefRows(x);
        tilePane.setVgap(1);
        tilePane.setHgap(1);


        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tilePane.getChildren().add(tileTest[i][j]);
                }
        }
        MapClass.index = index;
        MapClass.height = x;
        MapClass.width = y;

    }

    public void handle(MouseEvent event) {
        System.out.println(event.getSceneX());
        System.out.println(event.getSceneY());
        System.out.println();

    }

}
