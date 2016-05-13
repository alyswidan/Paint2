package com.company;


import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

/**
 * Created by user on 5/12/2016.
 */
public class BridgeIsoscelesTriangle extends BridgePolygon {


    public BridgeIsoscelesTriangle() {
        super();
    }

    public void expandToPosition(double x, double y){
        setBase2X(x);
        setBase2Y(y);
        setBase1X(2*getStartX()-getBase2X());
        setBase1Y(base2Y);
    }

    public double getStartX() {
        return ((Polygon)shape).getPoints().get(0);
    }

    public void setStartX(double vertX) {((Polygon)shape)}

    public double getStartY() {
        return vertY;
    }

    public void setStartY(double vertY) {
        this.vertY = vertY;
    }

    public double getBase1X() {
        return base1X;
    }

    public void setBase1X(double base1X) {
        this.base1X = base1X;
    }

    public double getBase1Y() {
        return base1Y;
    }

    public void setBase1Y(double base1Y) {
        this.base1Y = base1Y;
    }

    public double getBase2X() {
        return base2X;
    }

    public void setBase2X(double base2X) {
        this.base2X = base2X;
    }

    public double getBase2Y() {
        return base2Y;
    }

    public void setBase2Y(double base2Y) {
        this.base2Y = base2Y;
    }
}