package com.company;

import javafx.geometry.Point2D;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgeSquare extends BridgeRectangle{

    @Override
    public void expandToPosition(double x, double y) {
        super.expandToPosition(x,y);
        Point2D delta = new Point2D(Math.abs(getStartY()-x), Math.abs(getStartY()-y));
        Point2D reference = new Point2D(getStartX()+1,getStartY()+1);//line at 45 degrees
        double diagonal = delta.dotProduct(reference)/reference.magnitude();
        setHeight(diagonal * Math.cos(45));
        setWidth(diagonal * Math.sin(45));
    }
}

