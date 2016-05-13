package com.company;

import com.company.BridgeTriangle;
import javafx.geometry.Point2D;

/**
 * Created by user on 5/12/2016.
 */
public class BridgeEquilateralTriangle extends BridgeTriangle {

    @Override
    public void expandToPosition(double x, double y) {

        Point2D delta = new Point2D(Math.abs(getStartX()-x), Math.abs(getStartY()-y));
        Point2D reference = new Point2D(getStartX()+Math.sin(30),getStartY()+Math.cos(30));//line at 30 degrees
        double diagonal = delta.dotProduct(reference)/reference.magnitude();
        setBaseRightX(getStartX()+diagonal * Math.cos(30));
        setBaseRightY(getStartY()+diagonal * Math.sin(30));

    }


}
