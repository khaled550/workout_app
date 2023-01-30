package com.abeer.workoutapp.model;

public class Exercise {

    String title;
    int imgPath;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgPath() {
        return imgPath;
    }

    public void setImgPath(int imgPath) {
        this.imgPath = imgPath;
    }

    public Exercise(String title, int imgPath) {
        this.title = title;
        this.imgPath = imgPath;
    }
}
