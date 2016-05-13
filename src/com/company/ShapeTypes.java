package com.company;

/**
 * Created by user on 5/13/2016.
 */
public enum ShapeTypes {
    LINE,RECTANGLE,SQUARE,RIGHTTRIANGLE,ISOSCELESTRIANGLE,EQUILATERALTRIANGLE,CIRCLE,ELLIPSE,POLYGON;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
