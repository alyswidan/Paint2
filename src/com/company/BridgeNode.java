package com.company;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.transform.Transform;

/**
 * Created by ADMIN on 5/13/2016.
 */
public class BridgeNode {
    Node node;
    public void requestFocus() {
        node.requestFocus();
    }

    public <T extends Event> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        node.addEventHandler(eventType, eventHandler);
    }

    public <T extends Event> void removeEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        node.removeEventHandler(eventType, eventHandler);
    }

    public Bounds getBoundsInLocal() {
        return node.getBoundsInLocal();
    }

    public boolean intersects(Bounds localBounds) {
        return node.intersects(localBounds);
    }

    public ObservableList<Transform> getTransforms() {
        return node.getTransforms();
    }
}
