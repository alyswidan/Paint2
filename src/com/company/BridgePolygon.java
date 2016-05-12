package com.company;

import javafx.collections.ObservableList;
import javafx.scene.shape.Polygon;

/**
 * Created by user on 5/12/2016.
 */
public class BridgePolygon extends BridgeShape {

    public BridgePolygon() {
        shape = new Polygon();
    }

    public ObservableList<Double> getPoints() {
        return ((Polygon)shape).getPoints();
    }

    @Override
    public BridgePolygon copy(){
        BridgePolygon polygon = new BridgePolygon();
        polygon.getPoints().addAll(this.getPoints());
        polygon.setStrokeDetails(this.getStrokeDetails());
        return  polygon;
    }
}
