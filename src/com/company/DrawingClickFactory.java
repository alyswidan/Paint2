package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;

/**
 * Created by Amr on 4/27/2016.
 */
public class DrawingClickFactory {

    public EventHandler<MouseEvent> makeHandler(Shape shape)
    {
        EventHandler<MouseEvent> click = null;
        if(shape instanceof Circle )
        {
            click = event ->
            {
                ((Circle) shape).setCenterX(event.getX());
                ((Circle) shape).setCenterY(event.getY());
            };
        }
        else if(shape instanceof Rectangle)
        {
            click = event ->
            {
                ((Rectangle) shape).setX(event.getX());
                ((Rectangle) shape).setY(event.getY());
            };
        }
        else if (shape instanceof Ellipse){
            click = event -> {
                ((Ellipse) shape).setCenterX(event.getX());
                ((Ellipse) shape).setCenterY(event.getY());
            };
        }
        else if (shape instanceof Line)
        {
            click = event -> {
                ((Line) shape).setStartX(event.getX());
                ((Line) shape).setStartY(event.getY());
            };
        }


        return click;



    }





}
