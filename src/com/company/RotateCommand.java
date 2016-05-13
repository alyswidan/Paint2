package com.company;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class RotateCommand extends GeometricCommand {
    private Selection selection;
    private MouseEvent event;
    private EventHandler<MouseEvent> drag;

    public RotateCommand(Selection selection,MouseEvent event) {
        this.event = event;
        this.selection = selection;
    }

    @Override
    public void execute() {
        drag = e -> {
            Point2D delta = new Point2D(e.getX(),e.getY()).subtract(selection.getRotationHandlePos());
            selection.addTransform(new Rotate(Math.atan2(delta.getY(),delta.getX())));
        };
        startTransformIndex= selection.getTransforms().size();
        if(new Point2D((event).getX(),(event).getY()).equals(selection.getRotationHandlePos()))
            selection.addOnDrag(drag);
        selection.addOnRelease(e -> selection.removeOnDrag(drag));

    }



}
