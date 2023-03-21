package com.example.dostandard;

import android.graphics.drawable.Drawable;

public class DataPage {
    int color;
    Drawable title;

    public DataPage(int color, Drawable title){
        this.color = color;
        this.title = title;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Drawable getTitle() {
        return title;
    }


}
