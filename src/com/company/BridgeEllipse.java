package com.company;

import com.company.BridgeShape;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * Created by user on 5/12/2016.
 */
public class BridgeEllipse extends BridgeShape {

    public BridgeEllipse(double raduisX, double raduisY) {
        shape = new Ellipse();
        ((Ellipse) shape).setRadiusX(raduisX);
        ((Ellipse) shape).setRadiusY(raduisY);
    }

    @Override
    public BridgeShape copy() {
        return null;
    }
}
