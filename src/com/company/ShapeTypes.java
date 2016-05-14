package com.company;

/**
 * Created by user on 5/13/2016.
 */
public enum ShapeTypes {
    LINE, RECTANGLE, SQUARE, RIGHTTRIANGLE, ISOSCELESTRIANGLE, EQUILATERALTRIANGLE, CIRCLE, ELLIPSE, POLYGON;

    public BridgeShape makeShape() {
        if (this.equals(LINE)) return new BridgeLine();
        else if (this.equals(RECTANGLE)) return new BridgeRectangle();
        else if (this.equals(SQUARE)) return new BridgeSquare();
        else if (this.equals(RIGHTTRIANGLE)) return new BridgeRightTriangle();
        else if (this.equals(ISOSCELESTRIANGLE)) return new BridgeIsoscelesTriangle();
        else if (this.equals(EQUILATERALTRIANGLE)) return new BridgeEquilateralTriangle();
        else if (this.equals(CIRCLE)) return new BridgrCircle();
        else if (this.equals(ELLIPSE)) return new BridgeEllipse();
        else if (this.equals(POLYGON)) return new BridgePolygon();
        else return new NullShape();
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
