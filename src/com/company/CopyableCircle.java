package com.company;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class CopyableCircle implements CopyableShape {
    private Circle circle;

    @Override
    public void copy() {
        Circle circle2 = new Circle();
        circle2.setCenterX(circle.getCenterX());
        circle2.setCenterY(circle.getCenterY());
        circle2.setStyle(circle.getStyle());
        ShapeClipboard.getInstance().set(circle2);
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
