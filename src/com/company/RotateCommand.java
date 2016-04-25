package com.company;

import javafx.geometry.Bounds;
import javafx.scene.shape.Shape;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Rotate;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class RotateCommand implements Command {
    private Shape shape;
    private Rotate rotate;
    private Rotate reverse;

    public RotateCommand(Shape shape,Selection selection,double angle)  {
        Bounds bounds = selection.getBounds();
        rotate = new Rotate(angle,bounds.getMinX()+bounds.getWidth(),bounds.getMinY()+bounds.getHeight());

        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.getTransforms().add(rotate);
    }

    @Override
    public void undo() {
        shape.getTransforms().remove(rotate);
    }
}
