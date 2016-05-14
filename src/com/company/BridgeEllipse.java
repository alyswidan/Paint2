package com.company;

import javafx.scene.shape.Ellipse;

/**
 * Created by user on 5/12/2016.
 */
public class BridgeEllipse extends BridgeShape {

    private BridgeRectangle boundingRect = new BridgeRectangle();

    public BridgeEllipse() {
        node = new Ellipse();
    }

    public BridgeEllipse(double radiusX, double radiusY) {
        node = new Ellipse(radiusX, radiusY);
    }

    public BridgeEllipse(double centreX, double centreY, double radiusX, double radiusY) {
        node = new Ellipse(centreX, centreY, radiusX, radiusY);
    }

    public double getRadiusY() {
        return ((Ellipse) node).getRadiusY();
    }

    public void setRadiusY(double value) {
        ((Ellipse) node).setRadiusY(value);
    }

    public double getRadiusX() {
        return ((Ellipse) node).getRadiusX();
    }

    public void setRadiusX(double value) {
        ((Ellipse) node).setRadiusX(value);
    }

    public double getCenterY() {
        return ((Ellipse) node).getCenterY();
    }

    public void setCenterY(double value) {
        ((Ellipse) node).setCenterY(value);
    }

    public double getCenterX() {
        return ((Ellipse) node).getCenterX();
    }

    public void setCenterX(double value) {
        ((Ellipse) node).setCenterX(value);
    }

    @Override
    public double getStartX() {
        return boundingRect.getAnchorX();
    }

    @Override
    public void setStartX(double x) {
        boundingRect.setAnchorX(x);
    }

    @Override
    public double getStartY() {
        return boundingRect.getAnchorY();
    }

    @Override
    public void setStartY(double y) {
        boundingRect.setAnchorY(y);
    }

    @Override
    public void expandToPosition(double x, double y) {

        boundingRect.expandToPosition(x, y);
        setCenterX(boundingRect.getCentreX());
        setCenterY(boundingRect.getCentreY());
        setRadiusX(boundingRect.getWidth() / 2);
        setRadiusY(boundingRect.getHeight() / 2);
    }

    @Override
    public BridgeShape copy() {
        BridgeEllipse ellipse = new BridgeEllipse(getCenterX(), getCenterY(), getRadiusX(), getRadiusY());
        ellipse.fill(getFill());
        ellipse.setStrokeDetails(getStrokeDetails());
        return ellipse;
    }
}
