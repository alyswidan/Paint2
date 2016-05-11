package com.company;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class CopyCommand extends EditCommand {
    private Selection selection;
    public CopyCommand(){}
    public CopyCommand(Selection selection) {
        this.selection = selection;
    }

    @Override
    public void execute() {
        ShapeClipboard.getInstance().set(selection);
        selection.copy();
    }

    @Override
    public void undo() {
        ShapeClipboard.getInstance().undoLast();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
