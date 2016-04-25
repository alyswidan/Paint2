package com.company;

import javafx.scene.shape.Shape;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class SelectCommand implements Command{
    Shape shape;
    public SelectCommand(Shape shape)
    {
        this.shape = shape;
    }

    @Override
    public void execute() {
        SelectionManager.getInstance().add(Selection.fromBounds(shape.getBoundsInLocal()));
    }

    @Override
    public void undo() {
        SelectionManager.getInstance().remove(Selection.fromBounds(shape.getBoundsInLocal()));
    }

}
