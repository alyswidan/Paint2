package com.company;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;

/**
 * Created by ADMIN on 4/24/2016.
 */
public interface Command {
    void execute();

    void undo();
}
