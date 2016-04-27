package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Scale;

/**
 * Created by Amr on 4/27/2016.
 */
public class DrawingDragFactory {

    public EventHandler<MouseEvent> makeHandler(Shape shape,double startX,double startY  ){
        EventHandler<MouseDragEvent> drag;
        if(shape instanceof Circle || shape instanceof Ellipse)
        {
            drag = event -> {
                shape.getTransforms().add(new Scale(event.getX() - startX,event.getY()-startY));
            };
        }






    }
}
