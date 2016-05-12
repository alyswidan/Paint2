package com.company;

/**
 * Created by ADMIN on 5/12/2016.
 */

import javafx.scene.shape.Rectangle;



/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgeRectangle extends BridgeShape {

    protected DragContext startAnchor;

    public BridgeRectangle() {
        shape = new Rectangle();
        startAnchor = new DragContext();
    }
    public BridgeRectangle(double x,double y)
    {
        this();
        setX(x);
        setY(y);
    }
    public BridgeRectangle(double x,double y,double width,double height )
    {
        this(x,y);
        setWidth(width);
        setHeight(height);
    }


    public double getWidth() {
        return ((Rectangle)shape).getWidth();
    }

    public void setWidth(double width) {
        ((Rectangle)shape).setWidth(width);
    }

    public double getHeight() {
        return ((Rectangle)shape).getWidth();
    }

    public void setHeight(double height) {
        ((Rectangle)shape).setWidth(height);
    }

    public void setX(double x)
    {
        ((Rectangle) shape).setX(x);
    }

    public void setY(double y)
    {
        ((Rectangle) shape).setY(y);
    }


    public double getX()
    {
        return ((Rectangle) shape).getX();
    }

    public double getY()
    {
        return ((Rectangle) shape).getY();
    }

    @Override
    public BridgeRectangle copy()
    {
        BridgeRectangle rectangle = new BridgeRectangle(((Rectangle) shape).getX(),
                ((Rectangle) shape).getY(),((Rectangle) shape).getWidth(),((Rectangle) shape).getHeight());
        rectangle.setStrokeDetails(getStrokeDetails());
        rectangle.fill(getFill());
        return rectangle;
    }
    public void expendToPosition(double x,double y)
    {
        double dx = Math.abs(startAnchor.getAnchorX()-x);
        double dy = Math.abs(startAnchor.getAnchorY()-y);

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
