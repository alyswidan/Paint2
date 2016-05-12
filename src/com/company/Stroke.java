package com.company;

import javafx.scene.paint.Paint;



/**
 * Created by user on 5/8/2016.
 */
public class Stroke {

    private int strokeWidth;
    private String strokeStyle;
    private Paint color;

    public Stroke(int strokeWidth,Paint color, String strokeStyle) {
        this.strokeWidth = strokeWidth;
        this.strokeStyle = strokeStyle;
        this.color = color;
    }
    public Stroke(int strokeWidth,Paint color) {
        this.strokeWidth = strokeWidth;
        this.color = color;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public String getStrokeStyle() {
        return strokeStyle;
    }

    public void setStrokeStyle(String strokeStyle) {
        this.strokeStyle = strokeStyle;
    }
}
