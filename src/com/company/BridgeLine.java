package com.company;

import javafx.scene.shape.Line;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgeLine extends BridgeShape{
    Line line = new Line();

    public BridgeLine(){};
    public BridgeLine(double startX,double startY,double endX,double endY) {
        node = new Line(startX,startY,endX,endY);
    }
    public void expandToPosition(double x,double y)
    {
        setEndX(x);
        setEndY(y);
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
