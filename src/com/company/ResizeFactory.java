package com.company;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;

/**
 * Created by user on 5/2/2016.
 */
public class ResizeFactory {

    private double pivotX, pivotY, startX, startY, scaleX, scaleY;
    private EventHandler<MouseEvent> resize;

    public ResizeFactory(String pointPosition, Group group) {
        if (pointPosition.compareToIgnoreCase("upperleft") == 1) {
            resize = event -> {
                this.pivotX = group.getBoundsInLocal().getMaxX();
                this.pivotY = group.getBoundsInLocal().getMaxY();
                this.startX = group.getBoundsInLocal().getMinX();
                this.startY = group.getBoundsInLocal().getMinY();
                this.scaleX = (event.getX() - this.pivotX) / (this.startX - this.pivotX);
                this.scaleY = (event.getY() - this.pivotY) / (this.startY - this.pivotY);
            };
        } else if (pointPosition.compareToIgnoreCase("lowerleft") == 1) {
            resize = event -> {
                this.pivotX = group.getBoundsInLocal().getMaxX();
                this.pivotY = group.getBoundsInLocal().getMinY();
                this.startX = group.getBoundsInLocal().getMinX();
                this.startY = group.getBoundsInLocal().getMaxY();
                this.scaleX = (event.getX() - this.pivotX) / (this.startX - this.pivotX);
                this.scaleY = (event.getY() - this.pivotY) / (this.startY - this.pivotY);
            };
        } else if (pointPosition.compareToIgnoreCase("upperright") == 1) {
            resize = event -> {
                this.pivotX = group.getBoundsInLocal().getMinX();
                this.pivotY = group.getBoundsInLocal().getMaxY();
                this.startX = group.getBoundsInLocal().getMaxX();
                this.startY = group.getBoundsInLocal().getMinY();
                this.scaleX = (event.getX() - this.pivotX) / (this.startX - this.pivotX);
                this.scaleY = (event.getY() - this.pivotY) / (this.startY - this.pivotY);
            };
        } else if (pointPosition.compareToIgnoreCase("lowerright") == 1) {
            resize = event -> {
                this.pivotX = group.getBoundsInLocal().getMinX();
                this.pivotY = group.getBoundsInLocal().getMinY();
                this.startX = group.getBoundsInLocal().getMaxX();
                this.startY = group.getBoundsInLocal().getMaxY();
                this.scaleX = (event.getX() - this.pivotX) / (this.startX - this.pivotX);
                this.scaleY = (event.getY() - this.pivotY) / (this.startY - this.pivotY);
            };
        }
    }

    public EventHandler<MouseEvent> makeHandler(Group group) {
        group.getTransforms().add(new Scale(this.scaleX, this.scaleY, this.pivotX, this.pivotY));
        return resize;
    }

    public double getPivotX() {
        return pivotX;
    }

    public double getPivotY() {
        return pivotY;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getScaleX() {
        return scaleX;
    }

    public double getScaleY() {
        return scaleY;
    }
}
