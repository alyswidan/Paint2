package com.company;

import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;

/**
 * Created by user on 4/25/2016.
 */
public class CopyableRectangle extends CopyableShape {

    public CopyableRectangle(Shape copyableShape) {
        super(copyableShape);
    }

    @Override
    public CopyableShape copy() {
        Rectangle rectangle = new Rectangle(((Rectangle)copyableShape).getX(),
                                            ((Rectangle)copyableShape).getY(),
                                            ((Rectangle)copyableShape).getWidth(),
                                            ((Rectangle)copyableShape).getHeight());
        rectangle.setStyle(copyableShape.getStyle());
        CopyableShape  copyOfRect= new CopyableRectangle(rectangle);
        ShapeClipboard.getInstance().set(rectangle);
        return copyOfRect;
    }


    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }
}