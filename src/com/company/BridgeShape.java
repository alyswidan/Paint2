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
    protected DragContext startAnchor = new DragContext();
    public void fill(Paint color) {
        ((Shape)node).setFill(color);
    }

    public Paint getFill(){return ((Shape)node).getFill();}
    public void setStrokeDetails(Stroke stroke) {
        node.setStyle("-fx-stroke:"+stroke.getColor()+";-fx-stroke-width:"+stroke.getStrokeWidth()+"px;");
    }


    public Stroke getStrokeDetails(){
        return stroke;
    }

    public <T extends Event> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        ((Shape)node).addEventHandler(eventType, eventHandler);
    }

    public <T extends Event> void removeEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        ((Shape)node).removeEventHandler(eventType, eventHandler);
    }

    public Bounds getBoundsInLocal() {
        return ((Shape)node).getBoundsInLocal();
    }

    public Selection select(){
        return Selection.fromShape(((Shape)node));
    }

    public abstract void setStartX(double x);
    public abstract void setStartY(double y);
    public abstract double getStartX();
    public abstract double getStartY();
    public abstract void expandToPosition(double x,double y);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BridgeShape that = (BridgeShape) o;

        return node != null ? node.equals(that.node) : that.node == null;

    }

    public double getAnchorX() {
        return startAnchor.getAnchorX();
    }

    public double getAnchorY() {
        return startAnchor.getAnchorY();
    }

    public void setAnchorY(double anchorY) {
        startAnchor.setAnchorY(anchorY);
    }

    public void setAnchorX(double anchorX) {
        startAnchor.setAnchorX(anchorX);
    }



    @Override
    public int hashCode() {
        return node != null ? node.hashCode() : 0;
    }

    public abstract BridgeShape copy();
}
