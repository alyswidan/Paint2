package com.company;

import javafx.geometry.Point2D;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgeSquare extends BridgeRectangle{

    @Override
    public void expendToPosition(double x, double y) {
        super.expendToPosition(x,y);
        Point2D delta = new Point2D(Math.abs(startAnchor.getAnchorX()-x), Math.abs(startAnchor.getAnchorY()-y));
        Point2D reference = new Point2D(startAnchor.getAnchorX()+1,startAnchor.getAnchorY()+1);//line at 45 degrees
        double diagonal = delta.dotProduct(reference)/reference.magnitude();
        setHeight(diagonal * Math.cos(45));
        setWidth(diagonal * Math.sin(45));
    }
}

