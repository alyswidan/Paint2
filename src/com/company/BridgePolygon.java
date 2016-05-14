package com.company;

import javafx.collections.ObservableList;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/12/2016.
 */
public class BridgePolygon extends BridgeShape {

    private List<BridgeLine> lines;

    public BridgePolygon() {
        node = new Polygon();
        lines = new ArrayList<>();
    }

    public ObservableList<Double> getPoints() {
        return ((Polygon) node).getPoints();
    }

    @Override
    public BridgePolygon copy() {
        BridgePolygon polygon = new BridgePolygon();
        polygon.getPoints().addAll(this.getPoints());
        polygon.setStrokeDetails(this.getStrokeDetails());
        return polygon;
    }

    @Override
    public void setStart(double x, double y) {
        super.setStart(x, y);
        lines.add(new BridgeLine(x, y, x, y));
    }

    @Override
    public double getStartX() {
        return 0;
    }

    @Override
    public void setStartX(double x) {
        getPoints().add(x);
    }

    @Override
    public double getStartY() {
        return 0;
    }

    @Override
    public void setStartY(double y) {
        getPoints().add(y);
    }

    public List<BridgeLine> getAuxiliaryLines() {
        return lines;
    }

    @Override
    public void expandToPosition(double x, double y) {
        lines.get(lines.size() - 1).expandToPosition(x, y);
    }
}
