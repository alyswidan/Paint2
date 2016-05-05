package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class MultipleSelectCommand implements Command{
    private EventHandler<MouseEvent> multipleSelectClickHandler;
    private EventHandler<MouseEvent> multipleSelectDragStartHandler;
    private EventHandler<MouseEvent> multipleSelectDragReleaseHandler;



    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
