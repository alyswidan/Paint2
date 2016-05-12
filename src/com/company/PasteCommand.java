package com.company;

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

        DrawingCanvas.getInstance().getCanvas().getChildren().addAll(selection.getShapes());
    }

    @Override
    public void undo() {

    }
}
