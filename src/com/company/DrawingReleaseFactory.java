package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;

/**
 * Created by user on 5/2/2016.
 */
public class DrawingReleaseFactory {


    public EventHandler<MouseEvent> makeHandler(DrawingClickFactory factory) {

        EventHandler<MouseEvent> release;
        if(factory.getShape() instanceof BridgePolygon)
            release = event -> {};
        else
            release = event -> DrawingCanvas.getInstance().getCanvas().removeEventHandler(MouseEvent.MOUSE_DRAGGED,factory.getDrag());

        return release;
    }
}
