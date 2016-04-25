package com.company;

import javafx.scene.shape.Ellipse;

/**
 * Created by Mohamed on 4/25/2016.
 */
public class CopyableEllipse implements CopyableShape {

    Ellipse ellipse;

    @Override
    public void copy() {
        Ellipse ellipse2 = new Ellipse();
        ellipse2.setCenterX(ellipse.getCenterX());
        ellipse2.setCenterY(ellipse.getCenterY());
        ellipse2.setRadiusX(ellipse.getRadiusX());
        ellipse2.setRadiusY(ellipse.getRadiusY());
        ellipse2.setStyle(ellipse.getStyle());
        ShapeClipboard.getInstance().set(ellipse2);
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    public void setEllipse(Ellipse ellipse) {
        this.ellipse = ellipse;
    }
}
