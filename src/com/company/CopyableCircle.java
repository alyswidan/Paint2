package com.company;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class CopyableCircle implements CopyableShape{
    private Circle circle;

    @Override
    public void copy() {
        ShapeClipboard.getInstance().set(new Circle(circle.getCenterX(),circle.getCenterY(),circle.getRadius(),circle.getFill()));
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
