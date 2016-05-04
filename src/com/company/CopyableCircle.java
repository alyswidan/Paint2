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
    public void copy() {
        Shape circle = new CopyableCircle(new Circle());
        ((Circle) circle).setCenterX(((Circle) copyableShape).getCenterX());
        ((Circle) circle).setCenterY(((Circle) copyableShape).getCenterY());
        circle.setStyle(((Circle) copyableShape).getStyle());
        ShapeClipboard.getInstance().set(circle);
    }

    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }
}
