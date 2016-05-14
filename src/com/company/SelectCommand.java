package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class SelectCommand implements Command {

    MouseEvent event;
    EventHandler<MouseEvent> release;
    EventHandler<MouseEvent> drag;

    Selection selection;

    public SelectCommand(MouseEvent event) {
        this.event = event;

    }

    @Override
    public void execute() {
        drag = e -> {
            selection.expandRectToPos(event.getX(), event.getY());
        };

        release = e -> {
            selection.getSelection();
            selection.submitSelection();
            DrawingCanvas.getInstance().getCanvas().removeEventHandler(MouseEvent.MOUSE_DRAGGED, drag);
        };

        if (SelectionManager.getInstance().getSelections().size() > 0) {
            if (!SelectionManager.getInstance().isInSelection(event.getX(), event.getY()).isPresent())
                SelectionManager.getInstance().cancelAll();
            DrawingCanvas.getInstance().getCanvas().removeEventHandler(MouseEvent.MOUSE_RELEASED, release);
        } else {
            selection = Selection.fromStartPoint(event.getX(), event.getY());
            selection.addRect();
            DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_DRAGGED, drag);
            DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_RELEASED, release);
        }
    }

    @Override
    public void undo() {
        selection.cancel();
    }

    @Override
    public void redo() {
        selection.add();
    }
}
