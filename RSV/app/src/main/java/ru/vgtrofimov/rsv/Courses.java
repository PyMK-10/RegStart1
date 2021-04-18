package ru.vgtrofimov.rsv;

import android.graphics.drawable.Drawable;

public class Courses {
    Drawable img;
    String name;
    String text;

    public Courses(Drawable img, String name, String text) {
        this.img = img;
        this.name = name;
        this.text = text;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
