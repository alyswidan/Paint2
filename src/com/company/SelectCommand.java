package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class SelectCommand implements Command {

    EventHandler<MouseEvent> press;
    EventHandler<MouseEvent> release;
    EventHandler<MouseEvent> drag;
    Selection selection[] = new Selection[1];

    public SelectCommand() {
        press = event -> {
            if(SelectionManager.getInstance().getSelections().size()>0)
            {
                if(!SelectionManager.getInstance().isInSelection(event.getX(),event.getY()).isPresent())
                     SelectionManager.getInstance().cancelAll();
                DrawingCanvas.getInstance().getCanvas().removeEventHandler(MouseEvent.MOUSE_RELEASED,release);
            }
            else {
                selection[0] = Selection.fromStartPoint(event.getX(),event.getY());
                selection[0].addRect();
                DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_DRAGGED,drag);
                DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_RELEASED,release);
            }
        };

        drag = event -> {
            selection[0].expandRectToPos(event.getX(),event.getY());
        };

        release = event -> {
            selection[0].submitSelection();
            DrawingCanvas.getInstance().getCanvas().removeEventHandler(MouseEvent.MOUSE_DRAGGED,drag);
        };


    }

    @Override
    public void execute() {
        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_PRESSED,press);
        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_RELEASED,release);
    }

    @Override
    public void undo() {
        selection[0].cancel();
    }

}
