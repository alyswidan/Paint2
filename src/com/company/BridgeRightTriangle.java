package com.company;

import javafx.scene.shape.Polygon;

/**
 * Created by user on 5/12/2016.
 */
public class BridgeRightTriangle extends BridgePolygon {


    public void expandToPosition(double x, double y){

        setEndX(x);
        setEndY(y);
        setBaseX(getStartX());
        setBaseY(y);
    }

    public double getStartX() {
        return ((Polygon)node).getPoints().get(0);
    }

    public void setStartX(double startX) {
        ((Polygon)node).getPoints().set(0,startX);
    }

    public double getStartY() {
        return ((Polygon)node).getPoints().get(1);
    }

    public void setStartY(double startY) {
        ((Polygon)node).getPoints().set(1,startY);
    }

    public double getEndX() {
        return ((Polygon)node).getPoints().get(2);
    }

    public void setEndX(double endX) {
        ((Polygon)node).getPoints().set(2,endX);
    }

    public double getEndY() {
        return ((Polygon)node).getPoints().get(3);
    }

    public void setEndY(double endY) {
        ((Polygon)node).getPoints().set(3,endY);
    }

    public double getBaseX() {
        return ((Polygon)node).getPoints().get(4);
    }

    public void setBaseX(double baseX) {
        ((Polygon)node).getPoints().set(4,baseX);
    }

    public double getBaseY() {
        return ((Polygon)node).getPoints().get(5);
    }

    public void setBaseY(double baseY) {
        ((Polygon)node).getPoints().set(5,baseY);
    }
}
