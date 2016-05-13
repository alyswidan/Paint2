package com.company;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * Created by ADMIN on 5/9/2016.
 */
public class FillCommand implements Command {
    private Paint previousFill;
    private Paint fill;
    private MouseEvent mouseEvent;
    private BridgeShape shape;

    public FillCommand(Paint fill, MouseEvent mouseEvent) {
        this.fill = fill;
        this.mouseEvent = mouseEvent;
        shape = ShapeTypes.valueOf((mouseEvent.getTarget().getClass().getSimpleName().toUpperCase())).makeShape();
    }

    @Override
    public void execute() {
        previousFill = shape.getFill();
        shape.fill(fill);
    }

    @Override
    public void undo() {
        shape.fill(previousFill);
    }

    @Override
    public void redo() {
        shape.fill(fill);
    }
}
