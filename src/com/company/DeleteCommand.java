package com.company;

/**
 * Created by Amr on 4/25/2016.
 */
public class DeleteCommand implements Command {

    private Selection selection;

    public DeleteCommand(Selection selection) {
        this.selection = selection;
    }

    @Override
    public void execute() {
        DrawingCanvas.getInstance().getCanvas().getChildren().remove(selection.getShapes());
        //yet to push in the stack
    }

    @Override
    public void undo() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
