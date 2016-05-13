package com.company;

/**
 * Created by ADMIN on 5/12/2016.
 */
public abstract class BridgeTriangle extends BridgePolygon {

    public double getBaseLeftX() {
        return getPoints().get(4);
    }

    public void setBaseLeftX(double x) {
        getPoints().add(4,x);
    }

    public void setBaseLeftY(double y) {
        getPoints().add(5,y);
    }

    public double getBaseLeftY() {
        return getPoints().get(5);
    }


    public double getBaseRightX() {
        return getPoints().get(2);
    }

    public double getBaseRightY() {
        return getPoints().get(3);
    }

    public void setBaseRightX(double x) {
        getPoints().add(2,x);
    }
    public void setBaseRightY(double y) {
        getPoints().add(3,y);
    }

    public void setVertexX(double x)
    {
        getPoints().add(0,x);
    }

    public void setVertexY(double y)
    {
        getPoints().add(1,y);
    }

    public double getVertexX()
    {
        return getPoints().get(0);
    }

    public double getVertexY()
    {
        return getPoints().get(1);
    }


    @Override
    public void setStartX(double x) {
        setVertexX(x);
    }

    @Override
    public void setStartY(double y) {
        setVertexY(y);
    }

    @Override
    public double getStartX() {
        return getVertexX();
    }

    @Override
    public double getStartY() {
        return getVertexY();
    }


}
