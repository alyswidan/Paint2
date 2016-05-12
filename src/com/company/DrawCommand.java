package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Amr on 4/27/2016.
 */
public class DrawCommand implements Command {
    private MouseEvent event;
    private String shape;
    private DrawingClickFactory clickFactory;

    public DrawCommand(String shape,MouseEvent event) {
        this.shape = shape;
        this.event = event;
        clickFactory = new DrawingClickFactory();

    }

    @Override
    public void execute() {
        (clickFactory.makeHandler(shape)).handle(event);
        (new DrawingReleaseFactory().makeHandler(shape,clickFactory)).handle(event);
    }

    @Override
    public void undo() {
        DrawingCanvas.getInstance().getCanvas().getChildren().remove(clickFactory.getShape());
    }
}
