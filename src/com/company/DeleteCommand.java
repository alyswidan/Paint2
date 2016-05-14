package com.company;

/**
 * Created by Amr on 4/25/2016.
 */
public class DeleteCommand extends EditCommand {

    private Selection selection;

    public DeleteCommand() {
    }

    public DeleteCommand(Selection selection) {
        this.selection = selection;
    }

    @Override
    public void execute() {
        selection.delete();
    }

    @Override
    public void undo() {
        selection.add();
    }

    @Override
    public void redo() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
