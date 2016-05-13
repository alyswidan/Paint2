package com.company;

import javafx.scene.shape.Polygon;

/**
 * Created by user on 5/12/2016.
 */
public class BridgeRightTriangle extends BridgeTriangle {


    public void expandToPosition(double x, double y){

        setBaseRightX(x);
        setBaseRightY(y);
        setBaseLeftX(getStartX());
        setBaseLeftY(y);
    }



}
