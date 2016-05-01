package com.company;

import javafx.beans.binding.IntegerBinding;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Scale;
import javafx.util.Pair;

/**
 * Created by Amr on 4/27/2016.
 */
public class DrawCommand implements Command {
    EventHandler<MouseEvent> click;
    EventHandler<MouseEvent> release;
    public DrawCommand(String shape) {
        double pivot[] = new double[2];
        DrawingClickFactory clickFactory = new DrawingClickFactory();
        click =  clickFactory.makeHandler(shape);
        release = event ->{
            DrawingCanvas.getInstance().getCanvas().removeEventHandler(MouseEvent.MOUSE_DRAGGED,clickFactory.getDrag());
        };




    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
