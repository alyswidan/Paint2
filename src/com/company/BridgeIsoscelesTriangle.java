package com.company;


import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

/**
 * Created by user on 5/12/2016.
 */
public class BridgeIsoscelesTriangle extends BridgePolygon {

    //private double vertX,vertY,base1X,base1Y,base2X,base2Y;//base1 on the left, base2 on the right

    public BridgeIsoscelesTriangle() {
        super();
    }

    public BridgeIsoscelesTriangle(double startX,double startY,double endX,double endY){
        setVertX(startX);
        setVertY(startY);
        setBase2X(endX);
        setBase2Y(endY);
    }

    public void expandToPosition(double x, double y){
        setBase2X(x);
        setBase2Y(y);
        setBase1X(2*getVertX()-getBase2X());
        setBase1Y(getBase2Y());
    }

    public double getVertX() {
        return ((Polygon)shape).getPoints().get(0);
    }

    public void setVertX(double vertX) {
        ((Polygon)shape ).getPoints().set(0,vertX);
    }

    public double getVertY() {
        return ((Polygon)shape).getPoints().get(1);
    }

    public void setVertY(double vertY) {
        ((Polygon)shape ).getPoints().set(1,vertY);
    }

    public double getBase1X() {
        return ((Polygon)shape).getPoints().get(2);
    }

    public void setBase1X(double base1X) {
        ((Polygon)shape ).getPoints().set(2,base1X);
    }

    public double getBase1Y() {
        return ((Polygon)shape).getPoints().get(3);
    }

    public void setBase1Y(double base1Y) {
        ((Polygon)shape ).getPoints().set(3,base1Y);
    }

    public double getBase2X() {
        return ((Polygon)shape).getPoints().get(4);
    }

    public void setBase2X(double base2X) {
        ((Polygon)shape ).getPoints().set(4,base2X);
    }

    public double getBase2Y() {
        return ((Polygon)shape).getPoints().get(5);
    }

    public void setBase2Y(double base2Y) {
        ((Polygon)shape ).getPoints().set(5,base2Y);
    }

    @Override
    public  BridgeIsoscelesTriangle copy(){
        BridgeIsoscelesTriangle isoscelesTriangle = new BridgeIsoscelesTriangle(getVertX(),getVertY(),getBase2X(),getBase2Y());
        isoscelesTriangle.fill(getFill());
        return isoscelesTriangle;
    }
}
