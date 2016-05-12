package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 * Created by ADMIN on 5/8/2016.
 */
public class EraseCommand implements Command{
    private int startEnd[];
    private  EraserFactory eraserFactory;
    private EventHandler<MouseEvent> dragErase;

    public EraseCommand(EraserFactory eraserFactory)
    {
        startEnd = new int[2];
        this.eraserFactory = eraserFactory;
        dragErase = event ->
        {
            Shape eraser = eraserFactory.makeEraser();
            eraser.setTranslateX(event.getX());
            eraser.setTranslateY(event.getY());
            DrawingCanvas.getInstance().getCanvas().getChildren().add(eraser);
        };

    }


    @Override
    public void execute() {

        DrawingCanvas root = DrawingCanvas.getInstance();
        root.getCanvas() .setOnMousePressed(e->{
            root.getCanvas().addEventHandler(MouseEvent.MOUSE_DRAGGED,dragErase);
           startEnd[0]=root.getCanvas().getChildren().size()-1;
        });
        root.getCanvas().setOnMouseReleased(e->{
            root.getCanvas().removeEventHandler(MouseEvent.MOUSE_DRAGGED,dragErase);
            startEnd[1]=root.getCanvas().getChildren().size();
        });
    }

    @Override
    public void undo() {

    }
}
