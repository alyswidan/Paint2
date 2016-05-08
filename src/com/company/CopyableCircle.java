package com.company;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class CopyableCircle extends CopyableShape {

    public CopyableCircle(Shape copyableShape) {
        super(copyableShape);
    }

    @Override
    public CopyableShape copy() {
        Circle circle = new Circle(((Circle) copyableShape).getCenterX(),
                                    ((Circle) copyableShape).getCenterY(),
                                    ((Circle) copyableShape).getRadius());
        circle.setStyle(copyableShape.getStyle());
        CopyableShape copyOfCircle = new CopyableCircle(circle);
        ShapeClipboard.getInstance().set(copyOfCircle);
        return copyOfCircle;
    }

    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }
}
