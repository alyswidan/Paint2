package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.stream.Collectors;

/**
 * Created by user on 5/2/2016.
 */
public class DrawingReleaseFactory {


    public EventHandler<MouseEvent> makeHandler(DrawingClickFactory factory) {

        EventHandler<MouseEvent> release;
        if (factory.getShape() instanceof BridgePolygon)
            release = event -> {
            };
        else
            release = event -> DrawingCanvas.getInstance().getCanvas().removeEventHandler(MouseEvent.MOUSE_DRAGGED, factory.getDrag());

        if (factory.getShape() instanceof BridgeTriangle) {
            release = event -> DrawingCanvas.getInstance().getCanvas().removeEventHandler(MouseEvent.MOUSE_DRAGGED, factory.getDrag());
            DrawingCanvas.getInstance().getCanvas().removeAll(((BridgeTriangle) factory.getShape()).getAuxiliaryLines().stream().collect(Collectors.toList()));
        }

        return release;
    }
}
