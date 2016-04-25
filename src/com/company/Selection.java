package com.company;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class Selection {
    private Rectangle selectionRect;

    private Selection(double X,double Y){
        selectionRect = new Rectangle();
        format();
    }
    public static Selection fromBounds (Bounds bounds)
    {
        Selection selection = fromStartPoint(bounds.getMinX(),bounds.getMinY());
        selection.setStop(bounds.getMaxX() - bounds.getMinX(),bounds.getMaxY() - bounds.getMinY());
        return selection;
    }
    public static Selection fromStartPoint(double X,double Y)
    {
        return new Selection(X, Y);
    }
    public void setStop(double X,double Y)
    {
        selectionRect.setWidth(X-selectionRect.getX());
        selectionRect.setHeight(Y-selectionRect.getY());
    }
    public Bounds getBounds()
    {
        return selectionRect.getBoundsInLocal();
    }
    private void format()
    {
        selectionRect.setFill(null);
        selectionRect.setStroke(Color.BLACK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Selection selection = (Selection) o;

        return selectionRect.equals(selection.selectionRect);
    }

    @Override
    public int hashCode() {
        return selectionRect.hashCode();
    }
}
