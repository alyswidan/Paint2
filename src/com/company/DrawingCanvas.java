package com.company;

import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class DrawingCanvas {
    private static DrawingCanvas ourInstance;
    private Pane canvas;


    public static DrawingCanvas getInstance() {
        if (ourInstance == null) ourInstance = new DrawingCanvas();
        return ourInstance;
    }

    public Pane getCanvas() {
        return canvas;
    }

    public Iterator<Node> getShapes() {
        return getCanvas().getChildren().iterator();
    }

    private ContextMenu makeContextMenu() {
        ContextMenu menu = new ContextMenu();
        menu.getItems().addAll(new MenuItem("Copy"), new MenuItem("Paste"), new MenuItem("delete"));
        menu.getItems().
                forEach(menuItem -> menuItem.setOnAction(event -> EditCommandsInvoker.getInstance().
                        execute(CommandTypes.valueOf(menuItem.getText().toUpperCase()))));
        return menu;

    }

    private void init() {
        ContextMenu menu = makeContextMenu();
        boolean isOpen[] = new boolean[1];

        canvas.setOnMousePressed(event -> {


            if (event.getButton().equals(MouseButton.SECONDARY)) {
                if (event.getTarget() instanceof Shape)
                    EditCommandsInvoker.getInstance().setSelection(Selection.fromShape((Shape) event.getTarget()));
                isOpen[0] = true;
                menu.show(canvas, event.getScreenX(), event.getScreenY());
            } else {
                if (isOpen[0]) menu.hide();
            }
        });
    }

    public void addShape(BridgeShape shape){
        canvas.getChildren().add(shape.getShape());
    }

    private DrawingCanvas() {
        canvas = new Pane();
        init();
    }
}
