package com.company;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class CanvasCommandsManager {
    private EraserFactory eraserFactory;
    private Paint fill;
    private String shape;
    private Stroke stroke;


    public void setEraserFactory(EraserFactory eraserFactory) {
        this.eraserFactory = eraserFactory;
    }

    public void setFill(Paint fill) {
        this.fill = fill;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public EraserFactory getEraserFactory() {
        return eraserFactory;
    }

    public Paint getFill() {
        return fill;
    }

    public String getShape() {
        return shape;
    }

    public Shape makeEraser() {
        return eraserFactory.makeEraser();
    }

}
