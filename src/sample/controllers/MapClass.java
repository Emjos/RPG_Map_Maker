package sample.controllers;

import java.util.ArrayList;
import java.util.List;

public class MapClass {



    static int index;
    static int width = 5;
    static int height = 5;
    static String url="terra";

    static double rotate = 0;


    static List<MapList> mapLists = new ArrayList<>();
    static List<Tile[][]> tilesList = new ArrayList<>();

   static void findIndex(String name){

        for(int i = 0; i < mapLists.size();i++){

            if(mapLists.get(i).name.equals(name))
                index = i;
            break;
            }

    }
    static Tile changeTille(String url) {
        System.out.println(rotate);

       Tile tile1 = new Tile(url);
       tile1.imageView.setRotate(rotate);
       return tile1;

    }

    static String findUrl(int x, int y,int index){
            Tile[][] tile = tilesList.get(index);
        return tile[x][y].urlImage;
    }

}


