package com.company;


import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

/**
 * Created by user on 5/12/2016.
 */
public class BridgeIsoscelesTriangle extends BridgeTriangle {

    public void expandToPosition(double x, double y){
        setBaseRightX(x);
        setBaseRightY(y);
        setBaseLeftX(2*getStartX()-getBaseRightX());
        setBaseLeftY(getBaseRightY());
    }


}
