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
        if(!SelectionManager.getInstance().isSelected(shape))
            SelectionManager.getInstance().add(Selection.fromBounds(shape.getBoundsInLocal()));//which will be called
    }

    @Override
    public void undo() {
        if(SelectionManager.getInstance().isSelected(shape))
            SelectionManager.getInstance().remove(Selection.fromBounds(shape.getBoundsInLocal()));//which will be called
    }

}
