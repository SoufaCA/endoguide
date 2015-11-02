package com.eldorado.endoguide.model;

import java.io.Serializable;

/**
 * Created by msi-pc on 11/1/2015.
 */
public class Description implements Serializable {
    private String text;
    private int drawableId;

    public Description(String text, int drawableId) {
        this.text = text;
        this.drawableId = drawableId;
    }

    public Description(String text) {
        this.text = text;
    }

    public Description(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }
}
