package com.example.demo6;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ImageInfo {
    private Image image;
    private String caption;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;

    // Getters and setters for image, caption, and fileName
    private void showImageDetails(Stage primaryStage, ImageInfo imageInfo) {
        // Access image details from imageInfo object (e.g., imageInfo.getCaption())
        System.out.println("Caption: " + imageInfo.getCaption());
    }
}
