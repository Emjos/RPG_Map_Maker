package sample.controllers.RightClickContainer;

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

    public RightClickObject(int mapIndex, String mapName, int x, int y, Monster monster) {
        this.mapIndex = mapIndex;
        this.mapName = mapName;
        this.x = x;
        this.y = y;
        this.monster = monster;
    }

    public RightClickObject(int mapIndex, String mapName, int x, int y, Item item) {
        this.mapIndex = mapIndex;
        this.mapName = mapName;
        this.x = x;
        this.y = y;
        this.item = item;
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
