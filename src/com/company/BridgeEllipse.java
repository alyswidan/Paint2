package com.company;

import com.company.BridgeShape;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * Created by user on 5/12/2016.
 */
public class BridgeEllipse extends BridgeShape {

    public BridgeEllipse(double radiusX, double radiusY) {
        node = new Ellipse();
        ((Ellipse) node).setRadiusX(radiusX);
        ((Ellipse) node).setRadiusY(radiusY);
    }

    @Override
    public void setStartX(double x) {

    }

    @Override
    public void setStartY(double y) {

    }



    @Override
    public double getStartX() {
        return 0;
    }

    @Override
    public double getStartY() {
        return 0;
    }

    @Override
    public void expandToPosition(double x, double y) {

    }

    @Override
    public BridgeShape copy() {
        return null;
    }
}
