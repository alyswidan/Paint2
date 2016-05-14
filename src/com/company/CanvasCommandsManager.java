package com.company;

import javafx.scene.paint.Paint;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class CanvasCommandsManager {
    private EraserFactory eraserFactory;
    private Paint fill;
    private ShapeTypes shape;
    private Stroke stroke;

    public EraserFactory getEraserFactory() {
        return eraserFactory;
    }

    public void setEraserFactory(EraserFactory eraserFactory) {
        this.eraserFactory = eraserFactory;
    }

    public Paint getFill() {
        return fill;
    }

    public void setFill(Paint fill) {
        this.fill = fill;
    }

    public ShapeTypes getShape() {
        return shape;
    }

    public void setShape(ShapeTypes shape) {
        this.shape = shape;
    }

    public BridgeShape makeEraser() {
        return eraserFactory.makeEraser();
    }

}
