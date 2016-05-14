package com.company;

/**
 * Created by ADMIN on 5/12/2016.
 */
public abstract class BridgeTriangle extends BridgePolygon {

    public double getBaseLeftX() {
        return getPoints().get(4);
    }

    public void setBaseLeftX(double x) {
        if (getPoints().size() < 4)
            getPoints().add(4, x);
        else
            getPoints().set(4, x);
    }

    public double getBaseLeftY() {

        return getPoints().get(5);
    }

    public void setBaseLeftY(double y) {
        if (getPoints().size() < 5)
            getPoints().add(5, y);
        else
            getPoints().set(5, y);
    }

    public double getBaseRightX() {
        return getPoints().get(2);
    }

    public void setBaseRightX(double x) {
        if (getPoints().size() < 2)
            getPoints().add(2, x);
        else
            getPoints().add(2, x);
    }

    public double getBaseRightY() {
        return getPoints().get(3);
    }

    public void setBaseRightY(double y) {
        if (getPoints().size() < 3)
            getPoints().add(3, y);
        else
            getPoints().set(3, y);
    }

    public double getVertexX() {
        return getPoints().get(0);
    }

    public void setVertexX(double x) {

        if (getPoints().size() < 0)
            getPoints().add(0, x);
        else
            getPoints().set(0, x);
    }

    public double getVertexY() {
        return getPoints().get(1);
    }

    public void setVertexY(double y) {
        if (getPoints().size() < 1)
            getPoints().add(1, y);
        else
            getPoints().set(1, y);
    }

    @Override
    public double getStartX() {
        return getVertexX();
    }

    @Override
    public void setStartX(double x) {
        setVertexX(x);
    }

    @Override
    public double getStartY() {
        return getVertexY();
    }

    @Override
    public void setStartY(double y) {
        setVertexY(y);
    }


}
