package com.example.demo6;

import javafx.scene.image.Image;

public class Gallary {
    private String Name;
    private Image thumbnail;

    public Gallary(Image thumbnail,String name) {
        this.Name=name;
        this.thumbnail = thumbnail;
    }

    public Image getThumbnail() {
        return thumbnail;
    }
    public void setName(String name) {
        this.Name=name;
    }
    public String getName() {
        return Name;
    }
}
