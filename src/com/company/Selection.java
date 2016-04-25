package com.company;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Transform;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ADMIN on 4/24/2016.
 */

public class Selection {
    private Rectangle selectionRect;
    private List<Shape> shapes;

    private Selection(double x,double y)
    {
        selectionRect = new Rectangle(x,y);
        format();
    }
    public static Selection fromSingleShape (Shape shape)
    {
        Bounds bounds = shape.getBoundsInLocal();
        Selection selection = fromStartPoint(bounds.getMinX(),bounds.getMinY());
        selection.setStop(bounds.getMaxX() - bounds.getMinX(),bounds.getMaxY() - bounds.getMinY());
        selection.shapes.add(shape);
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
        Bounds bounds = selectionRect.getBoundsInLocal();
        Iterator<Node> drawings = DrawingCanvas.getInstance().getShapes();
        double maxX = 0,maxY = 0,minX = 1000,minY =1000;
        while (drawings.hasNext())
        {
            Bounds currentBounds = drawings.next().getBoundsInLocal();
            if(bounds.contains(currentBounds)||bounds.contains(currentBounds))
            {
                if(currentBounds.getMaxX()>maxX)maxX = currentBounds.getMaxX();
                if(currentBounds.getMaxY()>maxY)maxY = currentBounds.getMaxY();
                if(currentBounds.getMinX()<minX)minX = currentBounds.getMinX();
                if(currentBounds.getMinY()>minY)minY = currentBounds.getMinY();
            }
        }
        selectionRect.setX(minX);
        selectionRect.setY(maxY);
        selectionRect.setWidth(maxX-minX);
        selectionRect.setHeight(maxY-minY);
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

    public void transform(Transform trans)
    {

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
