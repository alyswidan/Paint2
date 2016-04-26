package com.company;

import javafx.scene.Node;

import java.util.Collection;

/**
 * Created by user on 4/26/2016.
 */
public class PasteCommand implements Command{

    Selection selection;

    public PasteCommand(Selection selection) {
        this.selection = selection;
    }

    @Override
    public void execute() {
        DrawingCanvas.getInstance().getCanvas().getChildren().addAll((Collection<? extends Node>) selection.getShapes());
    }

    @Override
    public void undo() {

    }
}
