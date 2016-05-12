package com.company;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * Created by user on 5/12/2016.
 */
public abstract class BridgeShape {

    protected Shape shape;
    private Stroke stroke;

    public void fill(Paint color) {
        shape.setFill(color);
    }

    public Paint getFill(){return shape.getFill();}
    public void setStrokeDetails(Stroke stroke) {
        shape.setStyle("-fx-stroke:"+stroke.getColor()+";-fx-stroke-width:"+stroke.getStrokeWidth()+"px;");
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

    public boolean intersects(Bounds localBounds) {
        return shape.intersects(localBounds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BridgeShape that = (BridgeShape) o;

        return shape != null ? shape.equals(that.shape) : that.shape == null;

    }

    @Override
    public int hashCode() {
        return shape != null ? shape.hashCode() : 0;
    }

    public abstract BridgeShape copy();
}
