package com.company;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class moveCommand implements Command {

    private EventHandler<MouseEvent> move;

    public moveCommand(Group group) {
        group.setOnMouseDragged(event -> {
            MoveFactory moveFactory = new MoveFactory(group);
            move = moveFactory.makeHandler(group);
            group.setCursor(Cursor.MOVE);
        });
        group.setOnMouseDragReleased(event -> group.removeEventHandler(MouseEvent.MOUSE_DRAGGED, move));
    }

    @Override
    public void execute() {
        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_DRAGGED, move);
    }

    @Override
    public void undo() {

    }
}
