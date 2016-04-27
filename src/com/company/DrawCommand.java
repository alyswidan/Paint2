package com.company;

import javafx.beans.binding.IntegerBinding;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Scale;
import javafx.util.Pair;

/**
 * Created by Amr on 4/27/2016.
 */
public class DrawCommand implements Command {
    EventHandler<MouseEvent> click;
    EventHandler<MouseEvent> drag;
    EventHandler<MouseEvent> release;
    public DrawCommand(Shape shape) {
        double pivot[] = new double[2];
        click = event -> {
            pivot[0] = event.getX();
            pivot[1] = event.getY();

        };

        drag = event -> {
            shape.getTransforms().add(new Scale(event.getX() - pivot[0],event.getY()-pivot[1]));
        };


    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
