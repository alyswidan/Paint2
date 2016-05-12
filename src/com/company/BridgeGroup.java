package com.company;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.util.Collection;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class BridgeGroup extends BridgeParent {
    @Override
    public void addShape(BridgeShape shape) {
        ((Group)parent).getChildren().add(shape.shape);
    }

    @Override
    public void removeShape(BridgeShape shape) {
        ((Group)parent).getChildren().add(shape.shape);
    }

    @Override
    public void addAll(Collection<BridgeShape> shapes) {
        shapes.forEach(shape -> ((Pane) parent).getChildren().add(shape.shape));
    }

}
