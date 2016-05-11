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

    public FillCommand(Paint fill, MouseEvent mouseEvent) {
        this.fill = fill;
        this.mouseEvent = mouseEvent;
    }

    @Override
    public void execute() {
        previousFill = ((Shape)this.mouseEvent.getTarget()).getFill();
        ((Shape)this.mouseEvent.getTarget()).setFill(fill);
    }

    @Override
    public void undo() {
        ((Shape)this.mouseEvent.getTarget()).setFill(previousFill);
    }
}
