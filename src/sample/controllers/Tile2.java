package sample.controllers;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import sample.controllers.helpClass.UrlHandle;

class Tile2 extends StackPane {
    ImageView imageView;
    String urlImage;
    public Tile2(String url) {
        urlImage = url;
        Rectangle border = new Rectangle(61, 61);
        border.setFill(null);
        Image image = new Image(url);
        imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(45);
        imageView.setFitHeight(45);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                UrlHandle.url = url;
            }
        });
        getChildren().addAll(border, imageView);
    }



}