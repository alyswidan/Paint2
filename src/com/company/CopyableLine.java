package com.company;

import javafx.scene.input.Clipboard;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

/**
 * Created by Amr on 4/27/2016.
 */
public class CopyableLine extends CopyableShape {

    public CopyableLine(Shape copyableShape) {
        super(copyableShape);
    }

    @Override
    public void copy() {
        Shape line = new CopyableLine(new Line(((Line) copyableShape).getStartX(), ((Line) copyableShape).getStartY()
                , ((Line) copyableShape).getEndX(), ((Line) copyableShape).getEndY()));
        line.setStyle(((Line) copyableShape).getStyle());
        ShapeClipboard.getInstance().set(line);
    }

    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }
}
