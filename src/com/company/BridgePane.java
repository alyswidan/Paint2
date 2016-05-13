package com.company;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.util.Collection;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgePane extends BridgeParent {


    @Override
    public void addChild(BridgeNode child)
    {
        ((Pane)node).getChildren().add(child.node);
    }

    @Override
    public void addAll(Collection<BridgeNode> children) {
        children.forEach(child -> ((Pane) node).getChildren().add(child.node));
    }

    @Override
    public void removeChild(BridgeNode child) {
        ((Pane)node).getChildren().add(child.node);
    }


}
