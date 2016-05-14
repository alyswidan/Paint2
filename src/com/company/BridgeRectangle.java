package com.company;

/**
 * Created by ADMIN on 5/12/2016.
 */

import javafx.scene.shape.Rectangle;


/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgeRectangle extends BridgeShape {

    private DragContext startAnchor = new DragContext();

    public BridgeRectangle() {
        node = new Rectangle();

    }

    public BridgeRectangle(double x, double y) {
        this();
        setX(x);
        setY(y);
    }

    public BridgeRectangle(double x, double y, double width, double height) {
        this(x, y);
        setWidth(width);
        setHeight(height);
    }


    public double getWidth() {
        return ((Rectangle) node).getWidth();
    }

    public void setWidth(double width) {
        ((Rectangle) node).setWidth(width);
    }

    public double getHeight() {
        return ((Rectangle) node).getWidth();
    }

    public void setHeight(double height) {
        ((Rectangle) node).setWidth(height);
    }

    public double getStartX() {
        return getAnchorX();
    }

    public void setStartX(double x) {
        setAnchorX(x);
    }

    public double getStartY() {
        return getAnchorY();
    }

    public void setStartY(double y) {
        setAnchorY(y);
    }

    public double getX() {
        return ((Rectangle) node).getX();
    }

    public void setX(double x) {
        ((Rectangle) node).setX(x);
    }

    public double getY() {
        return ((Rectangle) node).getY();
    }

    public void setY(double y) {
        ((Rectangle) node).setY(y);
    }

    public double getCentreX() {
        return getX() + getWidth() / 2;
    }

    public double getCentreY() {
        return getY() + getHeight() / 2;
    }

    public double getAnchorX() {
        return startAnchor.getAnchorX();
    }

    public void setAnchorX(double anchorX) {
        startAnchor.setAnchorX(anchorX);
    }

    public double getAnchorY() {
        return startAnchor.getAnchorY();
    }

    public void setAnchorY(double anchorY) {
        startAnchor.setAnchorY(anchorY);
    }

    @Override
    public BridgeRectangle copy() {
        BridgeRectangle rectangle = new BridgeRectangle(((Rectangle) node).getX(),
                ((Rectangle) node).getY(), ((Rectangle) node).getWidth(), ((Rectangle) node).getHeight());
        rectangle.setStrokeDetails(getStrokeDetails());
        rectangle.fill(getFill());
        return rectangle;
    }

    public void expandToPosition(double x, double y) {
        double dx = Math.abs(startAnchor.getAnchorX() - x);
        double dy = Math.abs(startAnchor.getAnchorY() - y);

        if (x > startAnchor.getAnchorX() && y > startAnchor.getAnchorY()) {
            setX(startAnchor.getAnchorX());
            setY(startAnchor.getAnchorY());

        } else if (x < startAnchor.getAnchorX() && y < startAnchor.getAnchorY()) {
            setX(x);
            setY(y);

        } else if (x > startAnchor.getAnchorX() && y < startAnchor.getAnchorY()) {
            setX(startAnchor.getAnchorX());
            setY(y);

        } else {
            setX(x);
            setY(startAnchor.getAnchorY());
        }
        setHeight(dy);
        setWidth(dx);
    }
}
