package com.company;

import com.company.BridgeShape;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import sun.corba.Bridge;

/**
 * Created by user on 5/12/2016.
 */
public class BridgrCircle extends BridgeShape {



    public BridgrCircle(double radius) {
        node = new Circle();
        ((Circle) node).setRadius(radius);
    }

    public BridgrCircle(double centreX,double centreY,double radius) {
        this(radius);
        setCenterX(centreX);
        setCenterY(centreY);
    }

    public BridgrCircle(double centreX,double centreY)
    {
        this(centreX,centreY,0);
    }

    public BridgrCircle() {

    }


    public void setCenterX(double value) {
        ((Circle)node).setCenterX(value);
    }

    public void setCenterY(double value) {
        ((Circle)node).setCenterY(value);
    }

    public double getCenterX() {
        return ((Circle)node).getCenterX();
    }

    public void setRadius(double radius) {
         ((Circle)node).setRadius(radius);
    }
    public double getRadius() {
        return ((Circle)node).getRadius();
    }

    public double getCenterY() {
        return ((Circle)node).getCenterY();
    }

    @Override
    public void setStartX(double x) {
        setCenterX(x);
    }

    @Override
    public void setStartY(double y) {
        setCenterY(y);
    }

    @Override
    public double getStartX() {
        return getCenterX();
    }

    @Override
    public double getStartY() {
        return getCenterY();
    }

    @Override
    public void expandToPosition(double x, double y) {
        setRadius(( new Point2D(Math.abs(x-getStartX()),Math.abs(y-getStartY())).magnitude()));
    }

    @Override
    public BridgeShape copy() {
        BridgrCircle circle = new BridgrCircle(getCenterX(),getCenterY(),getRadius());
        circle.setStrokeDetails(getStrokeDetails());
        circle.fill(getFill());
        return circle;
    }
}
