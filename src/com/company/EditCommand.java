package com.company;

/**
 * Created by ADMIN on 5/10/2016.
 */
public abstract class EditCommand implements Command{
    private Selection selection;

    public EditCommand(){};
    public EditCommand(Selection selection) {
        this.selection = selection;
    }

    public Selection getSelection() {
        return selection;
    }
}
