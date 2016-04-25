package com.company;

import javafx.scene.shape.Rectangle;

/**
 * Created by user on 4/25/2016.
 */
public class CopyableRectangle implements CopyableShape{

    Rectangle rectangle;

    @Override
    public void copy() {
        Rectangle rectangle2 = new Rectangle();
        rectangle2.setX(rectangle.getX());
        rectangle2.setY(rectangle.getY());
        rectangle2.setWidth(rectangle.getWidth());
        rectangle2.setHeight(rectangle.getHeight());
        rectangle2.setStyle(rectangle.getStyle());
        ShapeClipboard.getInstance().set(rectangle2);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
