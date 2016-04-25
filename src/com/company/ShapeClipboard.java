package com.company;

import javafx.scene.shape.Shape;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class ShapeClipboard {
    private static ShapeClipboard clipboard;
    private Shape current;
    private ShapeClipboard() {}
    public static ShapeClipboard getInstance() {
        if(clipboard == null)clipboard = new ShapeClipboard();
        return clipboard;
    }
    public void set(Shape shape) {current = shape;}
    public Shape get(){return current;}
    public void clear(){current = null;}
}
