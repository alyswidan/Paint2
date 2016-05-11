package com.company;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class moveCommand implements Command {

    private EventHandler<MouseEvent> press;
    private EventHandler<MouseEvent> release;
    private TemporaryEventHolder<EventHandler<MouseEvent>> drag = new TemporaryEventHolder<>();
    private DragContext dragContext = new DragContext();
    private int startTransformIndex;
    private Selection selection;
    private MouseEvent event;


    public moveCommand(Selection selection,MouseEvent event) {
        this.selection = selection;
        this.event = event;

    }

    @Override
    public void execute() {
        startTransformIndex = selection.getTransforms().size();
        dragContext.setAnchorX(event.getX());
        dragContext.setAnchorY(event.getY());
        drag.setEvent(new MoveFactory(selection,dragContext).makeDragHandler());
        selection.addOnDrag(drag.getEvent());
        selection.addOnRelease(e -> selection.removeOnDrag(drag.getEvent()));
    }

    @Override
    public void undo() {
        selection.removeTransformsFrom(startTransformIndex);
    }
}
