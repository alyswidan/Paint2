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
    public CopyableShape copy() {
        Line line = new Line(((Line) copyableShape).getStartX(), ((Line) copyableShape).getStartY()
                , ((Line) copyableShape).getEndX(), ((Line) copyableShape).getEndY());
        line.setStyle((copyableShape).getStyle());
        CopyableShape cpyOfLine = new CopyableLine(line);
        ShapeClipboard.getInstance().set(line);
        return cpyOfLine;
    }

    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        return null;
    }
}
