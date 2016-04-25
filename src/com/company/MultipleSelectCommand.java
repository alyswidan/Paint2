package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class MultipleSelectCommand implements Command{
    private EventHandler<MouseEvent> multipleSelectClickHandler;
    EventHandler<MouseEvent> multipleSelectDragStartHandler;
    private EventHandler<MouseEvent> multipleSelectDragReleaseHandler;

        public MultipleSelectCommand() {
            double start[] = new double[2];
            multipleSelectClickHandler = event -> {start[0] = event.getX();start[1] = event.getY();};
            multipleSelectDragReleaseHandler = event -> {Selection selection = Selection.fromStartPoint(start[0],start[1]);
                                                        selection.setStop(event.getX(),event.getY());
                                                        SelectionManager.getInstance().add(selection);};


        }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
