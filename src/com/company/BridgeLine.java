package com.company;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgeLine extends BridgeShape{


    public BridgeLine(){node = new Line();}
    public BridgeLine(double startX,double startY,double endX,double endY) {
        node = new Line(startX,startY,endX,endY);
    }
    public void expandToPosition(double x,double y)
    {
        System.out.println("Child"+((Pane) DrawingCanvas.getInstance().getCanvas().node).getChildren());
        node.setStyle("-fx-stroke-width:10px;-fx-stroke:black;");
        System.out.println("exp");
        setEndX(x);
        setEndY(y);
        System.out.println("salma "+node);
    }
    public void setStartX(double value) {
        ((Line)node).setStartX(value);
    }

    public double getStartX() {
        return ((Line)node).getStartX();
    }

    public void setStartY(double value) {
        ((Line)node).setStartY(value);
    }



    public double getStartY() {
        return ((Line)node).getStartY();
    }

    public void setEndX(double value) {
        ((Line)node).setEndX(value);
    }

    public double getEndX() {
        return ((Line)node).getEndX();
    }

    public void setEndY(double value) {
        ((Line)node).setEndY(value);
    }

    public double getEndY() {
        return ((Line)node).getEndY();
    }

    @Override
    public BridgeShape copy() {
        BridgeLine line = new BridgeLine(getStartX(),getStartY(),getEndX(),getEndY());
        line.setStrokeDetails(getStrokeDetails());
        line.fill(getFill());
        return line;
    }
}
