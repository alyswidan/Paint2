package com.company;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Transform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ADMIN on 4/24/2016.
 */

public class Selection {
    private Group selectionGroup;
    private SelectionGroupBuilder selectionGroupBuilder;
    private DragContext startAnchor;
    private final double padding = 5;//padding of rectangle

    private Selection(double x, double y) {
        selectionGroupBuilder = new SelectionGroupBuilder(this);
        startAnchor = new DragContext();
        selectionGroup = new Group();
        selectionGroupBuilder.makeSelectionRect(x,y);
    }

    public static Selection fromStartPoint(double x, double y)
    {
        Selection selection = new Selection(x, y);
        selection.startAnchor.setAnchorX(x);
        selection.startAnchor.setAnchorY(y);
        return selection;
    }
    public void addRect(){DrawingCanvas.getInstance().getCanvas().getChildren().add(selectionGroupBuilder.getSelectionRect());}
    public void expandRectToPos(double x,double y)
    {
        selectionGroupBuilder.getSelectionRect().setWidth(x - startAnchor.getAnchorX());
        selectionGroupBuilder.getSelectionRect().setHeight(y - startAnchor.getAnchorY());
    }
    public void submitSelection() {
        selectionGroup
                .getChildren()
                .addAll(DrawingCanvas.getInstance()
                .getCanvas()
                        .getChildren()
                        .stream().filter(node ->
                ( selectionGroupBuilder.getSelectionRect().getBoundsInLocal().contains(node.getBoundsInLocal())
                || node.intersects( selectionGroupBuilder.getSelectionRect().getBoundsInLocal()))
                && ! selectionGroupBuilder.getSelectionRect().equals(node)).collect(Collectors.toList()));

        DrawingCanvas.getInstance().getCanvas().getChildren().add(selectionGroup);
        selectionGroup.getChildren().add(selectionGroupBuilder.buildSelectionHandleGroup());
        SelectionManager.getInstance().add(this);
    }

    public void cancel()
    {
        selectionGroup.getChildren().remove(selectionGroupBuilder.getAccessoryGroup());
        DrawingCanvas.getInstance().getCanvas().getChildren().remove(selectionGroup);
        DrawingCanvas.getInstance().getCanvas().getChildren().addAll(selectionGroup.getChildren());
        SelectionManager.getInstance().remove(this);
    }

    public List<Node> getShapes(){return selectionGroup.getChildren().subList(0,selectionGroup.getChildren().size());}

    public Bounds getBounds() {
        return selectionGroup.getBoundsInLocal();
    }

    public void addTransform(Transform transform)
    {
        selectionGroup.getTransforms().add(transform);
    }

    public List<Transform> getTransforms(){return selectionGroup.getTransforms();}
    public void removeTransformsFrom(int start){
        for (int i = start; i <getTransforms().size() ; i++)
            getTransforms().remove(i);

    }
    public void reverseTransform(Transform transform)
    {
        try {
            selectionGroup.getTransforms().add(transform.createInverse());
        } catch (NonInvertibleTransformException e) {
            e.printStackTrace();
        }
    }

    public Point2D getOpposite(Point2D anchor)
    {
        Point2D opposite = null;

        if (anchor.equals(getUpperLeft())) opposite =  getLowerRight();

        else if (anchor.equals(getLowerLeft())) opposite =  getUpperLeft();

        else if (anchor.equals(getUpperRight())) opposite = getLowerLeft();

        else if (anchor.equals(getLowerRight())) opposite =  getUpperLeft();

        else if(anchor.equals(getMidLower())) opposite =  getMidUpper();

        else if(anchor.equals(getMidUpper())) opposite = getMidLower();

        else if(anchor.equals(getMidRight())) opposite =  getMidLeft();

        else if (anchor.equals(getMidLeft())) opposite =  getMidRight();

        return opposite;
    }
    //getters for handle positions
    public Point2D getRotationHandlePos(){return new Point2D(getMidUpper().getX(),getMidUpper().getY()-4*padding);}
    public Point2D getUpperLeft(){return new Point2D(getBounds().getMaxX(),getBounds().getMaxY());}
    public Point2D getLowerRight(){return new Point2D(getBounds().getMinX(),getBounds().getMinY());}
    public Point2D getUpperRight(){return new Point2D(getUpperLeft().getX()+getBounds().getWidth(),getUpperLeft().getY());}
    public Point2D getLowerLeft(){return new Point2D(getUpperLeft().getX(),getUpperLeft().getY()+getBounds().getHeight());}
    public Point2D getMidRight(){return new Point2D(getUpperLeft().getX()+getBounds().getWidth(),getUpperLeft().getY()+getBounds().getHeight()/2);}
    public Point2D getMidLeft(){return new Point2D(getBounds().getMaxX(),getBounds().getMaxY()+getBounds().getHeight()/2);}
    public Point2D getMidUpper(){return  new Point2D(getBounds().getMaxX()+getBounds().getWidth()/2,getBounds().getMaxY());}
    public Point2D getMidLower(){return new Point2D(getUpperLeft().getX()+getBounds().getWidth()/2,getUpperLeft().getY()+getBounds().getHeight());}
   //methods to add and remove event handlers
    public void addOnDrag(EventHandler<MouseEvent> drag){selectionGroup.addEventHandler(MouseEvent.MOUSE_DRAGGED,drag);}
    public void removeOnDrag(EventHandler<MouseEvent> drag){selectionGroup.removeEventHandler(MouseEvent.MOUSE_DRAGGED,drag);}
    public void addOnPressed(EventHandler<MouseEvent> press){selectionGroup.addEventHandler(MouseEvent.MOUSE_PRESSED,press);}
    public void removeOnPressed(EventHandler<MouseEvent> press){selectionGroup.removeEventHandler(MouseEvent.MOUSE_PRESSED,press);}
    public void addOnRelease(EventHandler<MouseEvent> release){selectionGroup.addEventHandler(MouseEvent.MOUSE_RELEASED,release);}
    public void removeOnRelease(EventHandler<MouseEvent> release){selectionGroup.removeEventHandler(MouseEvent.MOUSE_RELEASED,release);}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Selection selection = (Selection) o;

        return selectionGroup.equals(selection.selectionGroup);
    }

    @Override
    public int hashCode() {
        return selectionGroup.hashCode();
    }

}
