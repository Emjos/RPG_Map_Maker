package sample.controllers;


import javafx.scene.Group;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import sample.controllers.helpClass.UrlHandle;


class Tile extends StackPane {
        ImageView imageView;
    String urlImage;
    String backgroundUrl;
    static  int height=64;
    static  int width= 64;
    public Tile(String url) {
         urlImage = url;


         Rectangle border = new Rectangle(width, height);
        border.setFill(null);
        Image image = new Image(url);

         imageView = new ImageView(image);

        imageView.setPreserveRatio(true);

        imageView.setFitWidth(width);

        imageView.setFitHeight(height);


        getChildren().addAll(border, imageView);
    }
    public Tile(String url,String bckUrl) {
        urlImage = url;
        backgroundUrl = bckUrl;

        Rectangle border = new Rectangle(width, height);
        border.setFill(null);
        Image image = new Image(url);


        imageView = new ImageView(image);



        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.setFitWidth(width);

        imageView.setFitHeight(height);


        getChildren().addAll(border, imageView);
    }


}