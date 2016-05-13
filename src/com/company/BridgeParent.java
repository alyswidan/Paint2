package com.company;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Bounds;
import javafx.scene.Parent;

import java.util.Collection;
import java.util.List;

/**
 * Created by ADMIN on 5/12/2016.
 */
public abstract class BridgeParent extends BridgeNode
{

    List<BridgeNode> children;

    public abstract void addChild(BridgeNode node);

    public abstract void removeChild(BridgeNode node);

    public abstract void addAll(Collection<BridgeNode> nodes);

    public abstract void removeAll(Collection<BridgeNode> nodes);

    public List<BridgeNode> getChildren(){return children;}

}
