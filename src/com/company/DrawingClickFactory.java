package com.company;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;

/**
 * Created by Amr on 4/27/2016.
 */
public class DrawingClickFactory {

    private BridgeShape shape;
    private EventHandler<MouseEvent> drag = null;

    public EventHandler<MouseEvent> makeHandler(ShapeTypes type) {

        shape = type.makeShape();
        drag = event ->
        {
            System.out.println("sarah");
            shape.expandToPosition(event.getX(),event.getY());
        };

        EventType<MouseEvent> eventType;
        if(type.equals(ShapeTypes.POLYGON))eventType = MouseEvent.MOUSE_MOVED;
        else eventType = MouseEvent.MOUSE_DRAGGED;

        return event -> {
            shape.setStart(event.getX(),event.getY());
            DrawingCanvas.getInstance().getCanvas().addChild(shape);

            DrawingCanvas.getInstance().getCanvas().addEventHandler(eventType, drag);
            //DrawingCanvas.getInstance().getCanvas().node.setOnMouseMoved(drag);
        };
    }

    public EventHandler<MouseEvent> getDrag() {
        return drag;
    }

    public BridgeShape getShape() {
        return shape;
    }
}
