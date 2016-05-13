package com.company;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Transform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class moveCommand extends GeometricCommand {


    private EventHandler<MouseEvent> drag;
    private DragContext dragContext = new DragContext();
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
        drag = (new MoveFactory(selection,dragContext).makeDragHandler());
        selection.addOnDrag(drag);
        selection.addOnRelease(e -> selection.removeOnDrag(drag));
    }

}
