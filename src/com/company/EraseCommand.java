package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ADMIN on 5/8/2016.
 */
public class EraseCommand implements Command{
    private int startEnd[];
    private  EraserFactory eraserFactory;
    private EventHandler<MouseEvent> dragErase;
    private List<BridgeNode> erased;

    public EraseCommand(EraserFactory eraserFactory)
    {
        startEnd = new int[2];
        this.eraserFactory = eraserFactory;
        dragErase = event ->
        {
            BridgeShape eraser = eraserFactory.makeEraser();
            eraser.setTranslateX(event.getX());
            eraser.setTranslateY(event.getY());
            DrawingCanvas.getInstance().getCanvas().addChild(eraser);
        };
    }


    @Override
    public void execute() {

        BridgePane canvas = DrawingCanvas.getInstance().getCanvas();
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,e->{
            canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,dragErase);
           startEnd[0]=canvas.getChildren().size()-1;
        });
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,e->{
            canvas.removeEventHandler(MouseEvent.MOUSE_DRAGGED,dragErase);
            startEnd[1] = canvas.getChildren().size();
        });
    }

    @Override
    public void undo() {
        erased = DrawingCanvas.getInstance().getCanvas().getChildren().subList(startEnd[0],startEnd[1]);
        DrawingCanvas.getInstance().getCanvas().removeAll(erased);
    }

    @Override
    public void redo() {
        DrawingCanvas.getInstance().getCanvas().addAll(erased);
    }
}
