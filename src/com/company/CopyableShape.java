package com.company;

import javafx.scene.shape.Shape;

/**
 * Created by ADMIN on 4/24/2016.
 */
public abstract class CopyableShape extends Shape {
    protected Shape copyableShape;

    public CopyableShape(Shape copyableShape) {
        this.copyableShape = copyableShape;
    }

    abstract CopyableShape copy();

}
