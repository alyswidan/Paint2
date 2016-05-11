package com.company;

/**
 * Created by user on 4/26/2016.
 */
public class PasteCommand implements Command {

    Selection selection;

    public PasteCommand() {
        this.selection = ShapeClipboard.getInstance().get();
    }

    @Override
    public void execute() {
        selection.add();
    }

    @Override
    public void undo() {
        selection.delete();
    }
}
