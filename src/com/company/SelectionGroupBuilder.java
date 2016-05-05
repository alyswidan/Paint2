package com.company;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ADMIN on 5/3/2016.
 */
public class SelectionGroupBuilder {
    private Selection selection;
    private final double anchorRadius = 5,padding = 5;
    private Rectangle selectionRect;
    private Group accessoryGroup;
    public SelectionGroupBuilder(Selection selection) {
        this.selection = selection;
    }

    public Rectangle makeSelectionRect(double x,double y)
    {
        this.selectionRect = new Rectangle(x,y);
        selectionRect.setStyle("-fx-stroke:black;-fx-fill:transparent;-fx-stroke-width:1px;");
        return selectionRect;
    }

    public Rectangle submitRectangle()
    {
        selectionRect.setX(selection.getUpperLeft().getX()- padding);
        selectionRect.setY(selection.getUpperLeft().getY()  - padding );
        selectionRect.setWidth(selection.getUpperRight().getX() - selection.getUpperLeft().getX() + padding);
        selectionRect.setHeight(selection.getLowerLeft().getY() - selection.getLowerRight().getY() + padding);
        return selectionRect;
    }

    public Rectangle getSelectionRect()
    {
        return selectionRect;
    }
    private Circle makeAnchor(Point2D position){
        return new Circle(position.getX(),position.getY(),anchorRadius);
    }

    private Circle makeRotationHandle()
    {
        return new Circle(selection.getRotationHandlePos().getX(),selection.getRotationHandlePos().getY(),anchorRadius);
    }

    private Line makeRotationStick()
    {
        return new Line(selection.getMidUpper().getX(),selection.getMidUpper().getY(),
                selection.getRotationHandlePos().getX(),selection.getRotationHandlePos().getY());
    }

    private List<Shape> makeAnchors()
    {
        return Arrays.asList(
                makeAnchor(selection.getLowerLeft()),
                makeAnchor(selection.getLowerRight()),
                makeAnchor(selection.getUpperLeft()),
                makeAnchor(selection.getUpperRight()),
                makeAnchor(selection.getMidLeft()),
                makeAnchor(selection.getMidRight()),
                makeAnchor(selection.getMidLower()),
                makeAnchor(selection.getMidUpper()));
    }

    public List<Shape> getSelectionAccessories()
    {
        List<Shape> accessories = makeAnchors();
        accessories.add(makeRotationHandle());
        accessories.add(makeRotationStick());
        return accessories;
    }

    public Group buildSelectionHandleGroup()
    {
        accessoryGroup= new Group();
        accessoryGroup.getChildren().add(selectionRect);
        accessoryGroup.getChildren().addAll(getSelectionAccessories());
        return accessoryGroup;
    }
    public Group getAccessoryGroup()
    {
        return accessoryGroup;
    }
}
