package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

import java.nio.file.WatchEvent;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class SingleSelectCommand implements Command {
    private EventHandler<MouseEvent> singleSelectHandler;
    SingleSelectCommand()
    {
        singleSelectHandler = event -> SelectionManager.getInstance().add(Selection.fromSingleShape((Shape) event.getSource()));
    }
    @Override
    public void execute() {
        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_CLICKED,singleSelectHandler);
    }

    @Override
    public void undo() {
        DrawingCanvas.getInstance().getCanvas().removeEventHandler(MouseEvent.MOUSE_CLICKED,singleSelectHandler);
    }
}