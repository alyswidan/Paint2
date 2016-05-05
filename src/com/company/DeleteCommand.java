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
        selection.delete();
    }

    @Override
    public void undo() {
        selection.add();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
