package sample.controllers.RightClickContainer;

import sample.controllers.controllersList.actions.Action;
import sample.controllers.controllersList.items.views.Item;
import sample.controllers.controllersList.monster.Monster;

import java.awt.*;

public class RightClickObject {
    public int mapIndex;
    public String mapName;
    public  int x;
    public   int y;
    public   Monster monster;
    public  Item item;
    public Action action;
    public String frontUrl;

    public RightClickObject(int mapIndex, String mapName, int x, int y, Action action) {
        this.mapIndex = mapIndex;
        this.mapName = mapName;
        this.x = x;
        this.y = y;
        this.action = action;
        frontUrl = "sample/image/objects/666.png" ;
    }



    public RightClickObject(int mapIndex, String mapName, int x, int y, Monster monster) {
        this.mapIndex = mapIndex;
        this.mapName = mapName;
        this.x = x;
        this.y = y;
        this.monster = monster;
        frontUrl = "sample/image/objects/66.png";
    }

    public RightClickObject(int mapIndex, String mapName, int x, int y, Item item) {
        this.mapIndex = mapIndex;
        this.mapName = mapName;
        this.x = x;
        this.y = y;
        this.item = item;
        frontUrl = "sample/image/objects/111.png";
    }

    @Override
    public String toString() {
        return "RightClickObject{" +
                "mapIndex=" + mapIndex +
                ", mapName='" + mapName + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
