package com.company;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Translate;

/**
 * Created by user on 5/2/2016.
 */
public class MoveFactory {

    private double startX, startY, translateX, translateY;
    private EventHandler<MouseEvent> move;

    public MoveFactory(Group group) {
        move = event -> {
            this.startX = group.getBoundsInLocal().getMinX();
            this.startY = group.getBoundsInLocal().getMinY();
            this.translateX = event.getX() - this.startX;
            this.translateY = event.getY() - this.startY;
        };
    }

    public EventHandler<MouseEvent> makeHandler(Group group) {
        group.getTransforms().add(new Translate(this.translateX, this.translateY));
        return move;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getTranslateX() {
        return translateX;
    }

    public double getTranslateY() {
        return translateY;
    }
}
