package com.company;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Bounds;
import javafx.scene.Parent;

import java.util.Collection;

/**
 * Created by ADMIN on 5/12/2016.
 */
public abstract class BridgeParent
{
    Parent parent;

    public void requestFocus() {
        parent.requestFocus();
    }

    public <T extends Event> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        parent.addEventHandler(eventType, eventHandler);
    }

    public <T extends Event> void removeEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        parent.removeEventHandler(eventType, eventHandler);
    }

    public Bounds getBoundsInLocal() {
        return parent.getBoundsInLocal();
    }


    public abstract void addShape(BridgeShape shape);

    public abstract void removeShape(BridgeShape shape);

    public abstract void addAll(Collection<BridgeShape> shapes);

}
