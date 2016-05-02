package com.company;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Scale;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class ResizeCommand implements Command {

    private EventHandler<MouseEvent> resize;

    public ResizeCommand(Group group) {
        group.setOnMousePressed(event -> {
            if (event.getX() == group.getBoundsInLocal().getMinX()
                    && event.getY() == group.getBoundsInLocal().getMinY()) {
                ResizeFactory resizeFactory = new ResizeFactory("upperleft", group);
                resize = resizeFactory.makeHandler(group);
            } else if (event.getX() == group.getBoundsInLocal().getMinX()
                    && event.getY() == group.getBoundsInLocal().getMaxY()) {
                ResizeFactory resizeFactory = new ResizeFactory("lowerleft", group);
                resize = resizeFactory.makeHandler(group);
            } else if (event.getX() == group.getBoundsInLocal().getMaxX()
                    && event.getY() == group.getBoundsInLocal().getMinY()) {
                ResizeFactory resizeFactory = new ResizeFactory("upperright", group);
                resize = resizeFactory.makeHandler(group);
            } else if (event.getX() == group.getBoundsInLocal().getMaxX()
                    && event.getY() == group.getBoundsInLocal().getMaxY()) {
                ResizeFactory resizeFactory = new ResizeFactory("lowerright", group);
                resize = resizeFactory.makeHandler(group);
            }
        });
        group.setOnMouseExited(event -> group.setCursor(Cursor.E_RESIZE));
        group.setOnMouseReleased(event -> group.removeEventHandler(MouseEvent.MOUSE_DRAGGED, resize));
    }

    @Override
    public void execute() {
        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_PRESSED, resize);
    }

    @Override
    public void undo() {
        
    }

}
