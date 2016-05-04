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
    private EventHandler<MouseEvent> pressEvent;
    private Selection selection;
    private int startTransformIndex[] = new int[1];

    public ResizeCommand(Selection selection) {
        this.selection = selection;
        pressEvent = event -> {
            // record the number of transforms when mouse is pressed
            //undoing is just removing the transforms added in the drag handler
            startTransformIndex[0] = selection.getTransforms().size();
            dragEvent.setEvent(new ResizeFactory(new Point2D(event.getX(), event.getY()), selection).makeHandler());
            selection.addOnDrag(dragEvent.getEvent());
            selection.addOnPressed(pressEvent);
        };
            selection.addOnRelease(e -> selection.removeOnDrag(dragEvent.getEvent()));
            //group.setOnMouseExited(event -> group.setCursor(Cursor.E_RESIZE));
    }
    @Override
    public void execute() {
        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_PRESSED, pressEvent);
    }

    @Override
    public void undo() {
        //remove all transforms added due to this command being executed
        selection.removeTransformsFrom(startTransformIndex[0]);
    }

}
