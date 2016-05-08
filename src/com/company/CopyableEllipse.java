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
    public CopyableShape copy() {
        Ellipse ellipse = new Ellipse(((Ellipse) copyableShape).getCenterX(),
                                    ((Ellipse) copyableShape).getCenterY(),
                                    ((Ellipse) copyableShape).getRadiusX(),
                                    ((Ellipse) copyableShape).getRadiusY());
        ellipse.setStyle(copyableShape.getStyle());
        CopyableShape copyOfEllipse = new CopyableEllipse(ellipse);
        ShapeClipboard.getInstance().set(ellipse);
        return copyOfEllipse;

    }


    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }
}
