package com.company;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;

/**
 * Created by user on 5/2/2016.
 */
public class ResizeFactory {

    private Point2D start, pivot;
    private Selection selection;
    private void setParameters(Point2D start,Point2D pivot) {
        this.start = start;
        this.pivot = pivot;
    }

    public ResizeFactory(Point2D anchor, Selection selection) {
        this.selection = selection;
        setParameters(anchor,selection.getOpposite(anchor));
    }

    private Transform getScaleToPosition(double x, double y) {
        double scaleX = (x - getPivotX()) / (getStartX() - getPivotX());
        double scaleY = (y - getPivotY()) / (getStartY() - getPivotY());
        return new Scale(scaleX > 0 ? scaleX : 1, scaleY > 0 ? scaleY : 1, getPivotX(), getPivotY());
    }

    public EventHandler<MouseEvent> makeHandler() {
        return event -> {
            selection.addTransform(getScaleToPosition(event.getX(), event.getY()));
        };
    }

    public double getPivotX() {
        return pivot.getX();
    }

    public double getPivotY() {
        return pivot.getY();
    }

    public double getStartX() {
        return start.getX();
    }

    public double getStartY() {return start.getY();}

}
