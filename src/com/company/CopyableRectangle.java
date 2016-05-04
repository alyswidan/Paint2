package com.company;

import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;

/**
 * Created by user on 4/25/2016.
 */
public class CopyableRectangle extends CopyableShape {

    public CopyableRectangle(javafx.scene.shape.Shape copyableShape) {
        super(copyableShape);
    }

    @Override
    public void copy() {
        Shape rectangle = new CopyableRectangle(new Rectangle());
        ((Rectangle)rectangle).setX(((Rectangle)copyableShape).getX());
        ((Rectangle)rectangle).setY(((Rectangle)copyableShape).getY());
        ((Rectangle)rectangle).setWidth(((Rectangle)copyableShape).getWidth());
        ((Rectangle)rectangle).setHeight(((Rectangle)copyableShape).getHeight());
        ((Rectangle)rectangle).setStyle(((Rectangle)copyableShape).getStyle());
        ShapeClipboard.getInstance().set(rectangle);
    }

    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }
}