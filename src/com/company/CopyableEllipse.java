package com.company;

import javafx.scene.shape.Shape;
import javafx.scene.shape.Ellipse;

/**
 * Created by user on 4/25/2016.
 */
public class CopyableEllipse extends CopyableShape {

    public CopyableEllipse(Shape copyableShape) {
        super(copyableShape);
    }

    @Override
    public void copy() {
        Shape ellipse = new CopyableEllipse(new Ellipse());
        ((Ellipse) ellipse).setCenterX(((Ellipse) copyableShape).getCenterX());
        ((Ellipse) ellipse).setCenterY(((Ellipse) copyableShape).getCenterY());
        ((Ellipse) ellipse).setRadiusX(((Ellipse) copyableShape).getRadiusX());
        ((Ellipse) ellipse).setRadiusY(((Ellipse) copyableShape).getRadiusY());
        ((Ellipse) ellipse).setStyle(copyableShape.getStyle());
        ShapeClipboard.getInstance().set(ellipse);
    }


    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }
}
