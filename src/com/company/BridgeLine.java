package com.company;

import javafx.scene.shape.Line;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgeLine extends BridgeShape{
    Line line = new Line();

    public BridgeLine(double startX,double startY,double endX,double endY) {
        shape = new Line(startX,startY,endX,endY);
    }

    public void setStartX(double value) {
        line.setStartX(value);
    }

    public double getStartX() {
        return line.getStartX();
    }

    public void setStartY(double value) {
        line.setStartY(value);
    }

    public double getStartY() {
        return line.getStartY();
    }

    public void setEndX(double value) {
        line.setEndX(value);
    }

    public double getEndX() {
        return line.getEndX();
    }

    public void setEndY(double value) {
        line.setEndY(value);
    }

    public double getEndY() {
        return line.getEndY();
    }

    @Override
    public BridgeShape copy() {
        BridgeLine line = new BridgeLine(getStartX(),getStartY(),getEndX(),getEndY());
        line.setStrokeDetails(getStrokeDetails());
        line.fill(getFill());
        return line;
    }
}
