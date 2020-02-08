package sample.controllers;





public class MapList {
    String name;
    int height;
    int width;
    String scene;
    String description;
    int indexMapy;
    static int indexMapyCounter =0;


    public MapList(String name, int height, int width, String scene, String description) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.scene = scene;
        this.description = description;
        indexMapy = indexMapyCounter;
        indexMapyCounter++;

    }

    @Override
    public String toString() {
        return "MapList{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", scene='" + scene + '\'' +
                ", description='" + description + '\'' +
                ", indexmapy='" + indexMapy + '\'' +
                '}';
    }
}
