package com.company;

/**
 * Created by user on 5/8/2016.
 */
public class Stroke {

    private String strokeWidth;
    private String strokeStyle;

    public Stroke(String strokeWidth, String strokeStyle) {
        this.strokeWidth = strokeWidth;
        this.strokeStyle = strokeStyle;
    }

    public String getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(String strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public String getStrokeStyle() {
        return strokeStyle;
    }

    public void setStrokeStyle(String strokeStyle) {
        this.strokeStyle = strokeStyle;
    }
}
