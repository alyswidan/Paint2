package com.company;

/**
 * Created by ADMIN on 5/12/2016.
 */

import javafx.scene.shape.Rectangle;



/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgeRectangle extends BridgeShape {



    public BridgeRectangle() {
        node = new Rectangle();

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
        return ((Rectangle)node).getWidth();
    }

    public void setWidth(double width) {
        ((Rectangle)node).setWidth(width);
    }

    public double getHeight() {
        return ((Rectangle)node).getWidth();
    }

    public void setHeight(double height) {
        ((Rectangle)node).setWidth(height);
    }

    public void setX(double x)
    {
        ((Rectangle) node).setX(x);
    }

    public void setY(double y)
    {
        ((Rectangle) node).setY(y);
    }

    public void setStartX(double x){setAnchorX(x);}
    public void setStartY(double y){setAnchorY(y);}
    public double getStartX( ){return getAnchorX();}
    public double getStartY(){return getAnchorY();}

    public double getX()
    {
        return ((Rectangle) node).getX();
    }

    public double getY()
    {
        return ((Rectangle) node).getY();
    }



    @Override
    public BridgeRectangle copy()
    {
        BridgeRectangle rectangle = new BridgeRectangle(((Rectangle) node).getX(),
                ((Rectangle) node).getY(),((Rectangle) node).getWidth(),((Rectangle) node).getHeight());
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
