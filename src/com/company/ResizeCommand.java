package com.company;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Scale;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class ResizeCommand implements Command {

    private TemporaryEventHolder<EventHandler<MouseEvent>> dragEvent = new TemporaryEventHolder<>();
    private Selection selection;
    private int startTransformIndex;
    private MouseEvent event;


    public ResizeCommand(Selection selection,MouseEvent event) {
        this.selection = selection;
        this.event = event;

    }
    @Override
    public void execute() {
        // record the number of transforms when mouse is pressed
        //undoing is just removing the transforms added in the drag handler
        startTransformIndex = selection.getTransforms().size();
        dragEvent.setEvent(new ResizeFactory(new Point2D(event.getX(),
                            event.getY()), selection).makeHandler());
        selection.addOnDrag(dragEvent.getEvent());
        selection.addOnRelease(e -> selection.removeOnDrag(dragEvent.getEvent()));
    }

    @Override
    public void undo() {
        //remove all transforms added due to this command being executed
        selection.removeTransformsFrom(startTransformIndex);
    }

}
