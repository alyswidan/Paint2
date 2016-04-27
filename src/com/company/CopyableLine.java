package com.company;

import javafx.scene.input.Clipboard;
import javafx.scene.shape.Line;

/**
 * Created by Amr on 4/27/2016.
 */
public class CopyableLine implements CopyableShape {

    Line line;

    @Override
    public void copy() {
        Line line2 = new Line(line.getStartX(),line.getStartY(),line.getEndX(),line.getEndY());
        line2.setStyle(line.getStyle());
        ShapeClipboard.getInstance().set(line2);
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
