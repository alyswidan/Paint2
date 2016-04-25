package com.company;

import javafx.scene.shape.Shape;
import javafx.scene.transform.Translate;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class moveCommand implements Command {
    private Selection selection;
    private Translate translate;

    public moveCommand(Selection selection, double x, double y) {
        this.selection = selection;
        translate = new Translate(x,y);
    }

    @Override
    public void execute() {
        selection.addTransform(translate);
    }

    @Override
    public void undo() {
        selection.addTransform(translate.createInverse());
    }
}
