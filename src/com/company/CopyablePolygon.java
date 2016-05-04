package com.company;

import javafx.scene.shape.Shape;
import javafx.scene.shape.Polygon;

/**
 * Created by user on 4/25/2016.
 */
public class CopyablePolygon extends CopyableShape {

    public CopyablePolygon(Shape copyableShape) {
        super(copyableShape);
    }

    @Override
    public void copy() {
        Shape polygon = new CopyablePolygon(new Polygon());
        ((Polygon) polygon).getPoints().addAll(((Polygon) copyableShape).getPoints());
        ((Polygon) polygon).setStyle(copyableShape.getStyle());
        ShapeClipboard.getInstance().set(polygon);
    }

    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }
}
