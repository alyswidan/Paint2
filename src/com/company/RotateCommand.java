package com.company;

import javafx.geometry.Bounds;
import javafx.scene.shape.Shape;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Rotate;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class RotateCommand implements Command {
    private Selection selection;
    private Rotate rotate;


    public RotateCommand(Selection selection,double angle)  {
        this.selection = selection;
        Bounds bounds = selection.getBounds();
        rotate = new Rotate(angle,(bounds.getMinX()+bounds.getWidth())/2,(bounds.getMinY()+bounds.getHeight())/2);
    }

    @Override
    public void execute() {
        selection.addTransform(rotate);

    }

    @Override
    public void undo() {
        //shape.getTransforms().remove(rotate);
        try {
            selection.addTransform(rotate.createInverse());
        } catch (NonInvertibleTransformException e) {
            e.printStackTrace();
        }
    }
}
