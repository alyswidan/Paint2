package com.company;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * Created by user on 4/25/2016.
 */
public class CopyablePolygon extends CopyableShape {

    public CopyablePolygon(Shape copyableShape) {
        super(copyableShape);
    }

    @Override
    public CopyableShape copy() {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(((Polygon) copyableShape).getPoints());
        polygon.setStyle(copyableShape.getStyle());
        CopyableShape copyOfPolygon = new CopyablePolygon(polygon);
        ShapeClipboard.getInstance().set(polygon);
        return copyOfPolygon;
    }

    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }
}
