package com.company;

import javafx.scene.shape.Rectangle;

/**
 * Created by user on 4/25/2016.
 */
public class CopyableSquare extends CopyableRectangle {

    @Override
    public void copy() {
        Rectangle square = new Rectangle();
        square.setX(super.rectangle.getX());
        square.setY(super.rectangle.getY());
        square.setHeight(super.rectangle.getHeight());
        square.setWidth(super.rectangle.getHeight());
        square.setStyle(square.getStyle());
        ShapeClipboard.getInstance().set(square);
    }

    @Override
    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
