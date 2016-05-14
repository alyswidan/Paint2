package com.company;

import javafx.scene.shape.Line;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgeLine extends BridgeShape {


    public BridgeLine() {
        node = new Line();
    }

    public BridgeLine(double startX, double startY, double endX, double endY) {
        node = new Line(startX, startY, endX, endY);
    }

    public void expandToPosition(double x, double y) {

        setEndX(x);
        setEndY(y);
    }

    public double getStartX() {
        return ((Line) node).getStartX();
    }

    public void setStartX(double value) {
        ((Line) node).setStartX(value);
    }

    public double getStartY() {
        return ((Line) node).getStartY();
    }

    public void setStartY(double value) {
        ((Line) node).setStartY(value);
    }

    public double getEndX() {
        return ((Line) node).getEndX();
    }

    public void setEndX(double value) {
        ((Line) node).setEndX(value);
    }

    public double getEndY() {
        return ((Line) node).getEndY();
    }

    public void setEndY(double value) {
        ((Line) node).setEndY(value);
    }

    @Override
    public BridgeShape copy() {
        BridgeLine line = new BridgeLine(getStartX(), getStartY(), getEndX(), getEndY());
        line.setStrokeDetails(getStrokeDetails());
        line.fill(getFill());
        return line;
    }
}
