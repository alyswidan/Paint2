package com.company;

import javafx.scene.input.MouseEvent;

/**
 * Created by ADMIN on 5/10/2016.
 */
public abstract class GeometricCommand implements Command {
    private MouseEvent event;
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
}
