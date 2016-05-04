package com.company;

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
    private int startTransformIndex[] = new int[1];
    private Selection selection;

    public moveCommand(Selection selection) {
        this.selection = selection;
        press =event->
        {
            startTransformIndex[0] = selection.getTransforms().size();
            dragContext.setAnchorX(event.getX());
            dragContext.setAnchorY(event.getY());
            drag.setEvent(new MoveFactory(selection,dragContext).makeDragHandler());
            selection.addOnDrag(drag.getEvent());
        };
        release = event -> selection.removeOnDrag(drag.getEvent());

    }

    @Override
    public void execute() {
        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_PRESSED, press);
        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_RELEASED, release);

    }

    @Override
    public void undo() {
        selection.removeTransformsFrom(startTransformIndex[0]);
    }
}
