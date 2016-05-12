package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class SingleSelectCommand implements Command {
    private EventHandler<MouseEvent> singleSelectHandler;
    SingleSelectCommand()
    {
        //BridgeShape mot shape
        singleSelectHandler = event -> SelectionManager.getInstance().add(Selection.fromShape((BridgeShape) event.getSource()));
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