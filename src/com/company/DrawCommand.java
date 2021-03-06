package com.company;

import javafx.scene.input.MouseEvent;

/**
 * Created by Amr on 4/27/2016.
 */
public class DrawCommand implements Command {
    private MouseEvent event;
    private ShapeTypes shape;
    private DrawingClickFactory clickFactory;

    public DrawCommand(ShapeTypes shape, MouseEvent event) {
        this.shape = shape;
        this.event = event;
        clickFactory = new DrawingClickFactory();
    }

    @Override
    public void execute() {
        (clickFactory.makeHandler(shape)).handle(event);

        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_RELEASED, event1 ->
                new DrawingReleaseFactory().makeHandler(clickFactory).handle(event1));
        clickFactory.getShape().select();
    }

    @Override
    public void undo() {
        DrawingCanvas.getInstance().getCanvas().getChildren().remove(clickFactory.getShape());
    }

    @Override
    public void redo() {
        DrawingCanvas.getInstance().getCanvas().getChildren().add(clickFactory.getShape());
    }

}
