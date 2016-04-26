package com.company;

import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Scale;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class ResizeCommand implements Command {

    private Selection selection;
    private Scale scale;

    public ResizeCommand(Selection selection, double factorX, double factorY) {
        this.selection = selection;
        scale = new Scale(factorX, factorX, (selection.getBounds().getMinX() + selection.getBounds().getWidth()) / 2,
                (selection.getBounds().getMinY() + selection.getBounds().getHeight()) / 2);
    }

    @Override
    public void execute() {
        selection.addTransform(scale);
    }

    @Override
    public void undo() {
        try {
            selection.addTransform(scale.createInverse());
        } catch (NonInvertibleTransformException e) {
            e.printStackTrace();
        }
    }

}
