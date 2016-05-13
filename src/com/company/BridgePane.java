package com.company;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

import java.util.Collection;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgePane extends BridgeParent {

    public BridgePane() {
        node = new Pane();
    }

    public void setBackground(Background background) {
        ((Pane) node).setBackground(background);
    }

    public void setStyle(String style){
        ((Pane)node).setStyle(style);
    }

    @Override
    public void addChild(BridgeNode child) {
        System.out.println(child.node);
        ((Pane) node).getChildren().add(child.node);
        getChildren().add(child);
    }

    @Override
    public void addAll(Collection<BridgeNode> children) {
        children.forEach(child ->
        {
            ((Pane) node).getChildren().add(child.node);
            getChildren().add(child);
        });
    }

    @Override
    public void removeChild(BridgeNode child) {
        ((Pane) node).getChildren().remove(child.node);
        getChildren().remove(child);
    }

    @Override
    public void removeAll(Collection<BridgeNode> nodes) {
        nodes.forEach(child -> {
            ((Pane) node).getChildren().remove(child.node);
            getChildren().add(child);
        });
    }


}
