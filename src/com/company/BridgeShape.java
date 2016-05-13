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
public abstract class BridgeShape extends BridgeNode {


    private Stroke stroke;

    public void fill(Paint color) {
        ((Shape)node).setFill(color);
    }

    public Paint getFill(){return ((Shape)node).getFill();}
    public void setStrokeDetails(Stroke stroke) {
        node.setStyle("-fx-stroke:"+stroke.getColor()+";-fx-stroke-width:"+stroke.getStrokeWidth()+"px;");
    }

    public void setTranslateY(double value) {
        node.setTranslateY(value);
    }

    public void setTranslateX(double value) {
        node.setTranslateX(value);
    }

    public Stroke getStrokeDetails(){
        return stroke;
    }

    public <T extends Event> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        node.addEventHandler(eventType, eventHandler);
    }

    public <T extends Event> void removeEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        node.removeEventHandler(eventType, eventHandler);
    }

    public Bounds getBoundsInLocal() {
        return node.getBoundsInLocal();
    }

    public Selection select(){
        return Selection.fromShape(((Shape)node));
    }

    public abstract void setStartX(double x);
    public abstract void setStartY(double y);

    public abstract double getStartX();
    public abstract double getStartY();
    public abstract void expandToPosition(double x,double y);
    public  void setStart(double x,double y){
        setStartX(x);
        setStartY(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BridgeShape that = (BridgeShape) o;

        return node != null ? node.equals(that.node) : that.node == null;

    }

    @Override
    public int hashCode() {
        return node != null ? node.hashCode() : 0;
    }

    public abstract BridgeShape copy();
}
