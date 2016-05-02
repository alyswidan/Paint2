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
    private EventHandler<MouseEvent> click;
    private EventHandler<MouseEvent> release;

    public DrawCommand(String shape) {
        double pivot[] = new double[2];
        DrawingClickFactory clickFactory = new DrawingClickFactory();
        click = clickFactory.makeHandler(shape);
        DrawingReleaseFactory releaseFactory = new DrawingReleaseFactory();
        release = releaseFactory.makeHandler(shape, clickFactory);
    }

    @Override
    public void execute() {
        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_CLICKED, click);
        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_RELEASED, release);
    }

    @Override
    public void undo() {

    }
}
