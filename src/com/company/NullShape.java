package com.company;

/**
 * Created by ADMIN on 5/13/2016.
 */
public class NullShape extends BridgeShape {
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
