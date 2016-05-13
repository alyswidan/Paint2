package com.company;

import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Transform;

import java.util.List;

/**
 * Created by ADMIN on 5/10/2016.
 */
public abstract class GeometricCommand implements Command {
    private MouseEvent event;
    protected List<Transform> transforms;
    protected int startTransformIndex;
    private Selection selection;

    public GeometricCommand(){}
    public GeometricCommand(MouseEvent event, Selection selection) {
        this.event = event;
        this.selection = selection;
    }

    public void setEvent(MouseEvent event) {
        this.event = event;
    }

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    public MouseEvent getEvent() {
        return event;
    }

    public Selection getSelection() {
        return selection;
    }

    @Override
    public void undo() {
        transforms = selection.getTransforms().subList(startTransformIndex,selection.getTransforms().size());
        selection.removeTransformsFrom(startTransformIndex);
    }

    @Override
    public void redo() {
        selection.getTransforms().addAll(transforms);
    }
}
