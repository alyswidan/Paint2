package com.company;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ADMIN on 5/3/2016.
 */
public class SelectionGroupBuilder {
    private final double anchorRadius = 5, padding = 5;
    private Selection selection;
    private BridgeRectangle selectionRect;
    private BridgeGroup accessoryGroup;

    public SelectionGroupBuilder(Selection selection) {
        this.selection = selection;
    }

    public BridgeRectangle makeSelectionRect(double x, double y) {
        selectionRect = new BridgeRectangle(x, y);
        selectionRect.setStrokeDetails(new Stroke(1, Color.BLACK));
        selectionRect.fill(Color.TRANSPARENT);
        return selectionRect;
    }

    public SelectionGroupBuilder submitRectangle() {
        selectionRect.setX(selection.getUpperLeft().getX() - padding);
        selectionRect.setY(selection.getUpperLeft().getY() - padding);
        selectionRect.setWidth(selection.getUpperRight().getX() - selection.getUpperLeft().getX() + padding);
        selectionRect.setHeight(selection.getLowerLeft().getY() - selection.getLowerRight().getY() + padding);
        return this;
    }

    public BridgeRectangle getSelectionRect() {
        return selectionRect;
    }

    private BridgrCircle makeAnchor(Point2D position) {
        return new BridgrCircle(position.getX(), position.getY(), anchorRadius);
    }

    private BridgrCircle makeRotationHandle() {
        return new BridgrCircle(selection.getRotationHandlePos().getX(), selection.getRotationHandlePos().getY(), anchorRadius);
    }

    private BridgeLine makeRotationStick() {
        return new BridgeLine(selection.getMidUpper().getX(), selection.getMidUpper().getY(),
                selection.getRotationHandlePos().getX(), selection.getRotationHandlePos().getY());
    }

    private List<BridgeNode> makeAnchors() {
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

    public List<BridgeNode> getSelectionAccessories() {
        List<BridgeNode> accessories = makeAnchors();
        accessories.add(makeRotationHandle());
        accessories.add(makeRotationStick());
        return accessories;
    }

    public BridgeGroup buildSelectionHandleGroup() {
        accessoryGroup = new BridgeGroup();
        accessoryGroup.addChild(selectionRect);
        //accessoryGroup.addAll(getSelectionAccessories());
        return accessoryGroup;
    }

    public BridgeGroup getAccessoryGroup() {
        return accessoryGroup;
    }
}
