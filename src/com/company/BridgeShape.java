package com.company;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * Created by user on 5/12/2016.
 */
public abstract class BridgeShape {

    protected Shape shape;
    private Stroke stroke;

    public void fill(Color color) {
        shape.setFill(color);
    }

    public void setStrokeDetails(Stroke stroke) {
        shape.setStyle(stroke.getStrokeWidth() + stroke.getStrokeStyle());
    }

    public Stroke getStrokeDetails(){
        return stroke;
    }

    public <T extends Event> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        shape.addEventHandler(eventType, eventHandler);
    }

    public <T extends Event> void removeEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        shape.removeEventHandler(eventType, eventHandler);
    }

    public Bounds getBoundsInLocal() {
        return shape.getBoundsInLocal();
    }

    public Selection select(){
        return Selection.fromShape(shape);
    }
}
