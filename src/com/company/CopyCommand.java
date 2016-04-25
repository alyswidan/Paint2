package com.company;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class CopyCommand implements Command {
    private CopyableShape copyable;

    public CopyCommand(CopyableShape copyable) {
        this.copyable = copyable;
    }

    @Override
    public void execute() {
        copyable.copy();
    }

    @Override
    public void undo() {
        ShapeClipboard.getInstance().clear();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}