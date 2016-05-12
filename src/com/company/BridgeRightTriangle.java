package com.company;

import javafx.scene.shape.Polygon;

/**
 * Created by user on 5/12/2016.
 */
public class BridgeRightTriangle extends BridgePolygon {


    public BridgeRightTriangle() {
        super();
    }

    public void expandToPosition(double x, double y){
        setEndX(x);
        setEndY(y);
        setBaseX(getStartX());
        setBaseY(getEndY());
    }

    public double getStartX() {
        return ((Polygon)shape).getPoints().get(0);
    }

    public void setStartX(double startX) {
        ((Polygon)shape).getPoints().set(0,startX);
    }

    public double getStartY() {
        return ((Polygon)shape).getPoints().get(1);
    }

    public void setStartY(double startY) {
        ((Polygon)shape).getPoints().set(1,startY);
    }

    public double getEndX() {
        return ((Polygon)shape).getPoints().get(2);
    }

    public void setEndX(double endX) {
        ((Polygon)shape).getPoints().set(2,endX);
    }

    public double getEndY() {
        return ((Polygon)shape).getPoints().get(3);
    }

    public void setEndY(double endY) {
        ((Polygon)shape).getPoints().set(3,endY);
    }

    public double getBaseX() {
        return ((Polygon)shape).getPoints().get(4);
    }

    public void setBaseX(double baseX) {
        ((Polygon)shape).getPoints().set(4,baseX);
    }

    public double getBaseY() {
        return ((Polygon)shape).getPoints().get(5);
    }

    public void setBaseY(double baseY) {
        ((Polygon)shape).getPoints().set(5,baseY);
    }
}
