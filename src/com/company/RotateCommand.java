package com.company;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Rotate;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class RotateCommand implements Command {
    private Selection selection;
    private EventHandler<MouseEvent> press;
    private EventHandler<MouseEvent> drag;
    private EventHandler<MouseEvent> release;
    int startTransformIndex[] = new int[1];


    public RotateCommand(Selection selection) {
        drag = event -> {
            Point2D delta = new Point2D(event.getX(),event.getY()).subtract(selection.getRotationHandlePos());
            selection.addTransform(new Rotate(Math.atan2(delta.getY(),delta.getX())));
        };

        release = event -> {
            selection.removeOnDrag(drag);
        };
        press = event -> {
            startTransformIndex[0] = selection.getTransforms().size();
            if(new Point2D(event.getX(),event.getY()).equals(selection.getRotationHandlePos()))
                selection.addOnDrag(drag);
        };

        this.selection = selection;

    }

    @Override
    public void execute() {
        selection.addOnPressed(press);
        selection.addOnRelease(release);
    }

    @Override
    public void undo() {
        selection.removeTransformsFrom(startTransformIndex[0]);
    }
}
