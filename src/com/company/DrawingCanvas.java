package com.company;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.Iterator;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class DrawingCanvas {
    private static DrawingCanvas ourInstance;
    private Pane canvas;


    public static DrawingCanvas getInstance() {
        if (ourInstance == null) ourInstance = new DrawingCanvas();
        return ourInstance;
    }

    public Pane getCanvas() {
        return canvas;
    }

    public Iterator<Node> getShapes() {
        return getCanvas().getChildren().iterator();
    }

    private DrawingCanvas() {
        canvas = new Pane();
       

    }
}
