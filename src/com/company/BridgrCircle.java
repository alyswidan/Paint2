package com.company;

import com.company.BridgeShape;
import javafx.scene.shape.Circle;
import sun.corba.Bridge;

/**
 * Created by user on 5/12/2016.
 */
public class BridgrCircle extends BridgeShape {


    public BridgrCircle(double radius) {
        shape = new Circle();
        ((Circle) shape).setRadius(radius);
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

    public void setCenterX(double value) {
        ((Circle)shape).setCenterX(value);
    }

    public void setCenterY(double value) {
        ((Circle)shape).setCenterY(value);
    }

    public double getCenterX() {
        return ((Circle)shape).getCenterX();
    }

    public double getRadius() {
        return ((Circle)shape).getRadius();
    }

    public double getCenterY() {
        return ((Circle)shape).getCenterY();
    }

    @Override
    public BridgeShape copy() {
        return null;
    }
}
