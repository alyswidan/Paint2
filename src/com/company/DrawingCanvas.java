package com.company;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class DrawingCanvas {
    private static DrawingCanvas ourInstance=null;
    private BridgePane canvas;


    public static DrawingCanvas getInstance() {
        if (ourInstance == null) ourInstance = new DrawingCanvas();
        return ourInstance;
    }

    public BridgePane getCanvas() {
        return canvas;
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

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {


            if (event.getButton().equals(MouseButton.SECONDARY)) {
                if (event.getTarget() instanceof Shape)
                    EditCommandsInvoker.getInstance().setSelection(Selection.fromShape((Shape) event.getTarget()));
                isOpen[0] = true;
                menu.show(canvas.node, event.getScreenX(), event.getScreenY());
            } else {
                if (isOpen[0]) menu.hide();
            }
        });
    }


    public List<BridgeNode> getChildren(){return canvas.getChildren();}

    private DrawingCanvas() {
        canvas = new BridgePane();
        canvas.node.setId("canvas");
        canvas.node.setLayoutX(0);
        canvas.node.setLayoutY(120);
        canvas.node.minHeight(600);
        canvas.node.minWidth(1360);
        canvas.setStyle("-fx-background-color:white;");
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,event ->
        {
            System.out.println("world");
            CanvasCommandsInvoker c = CanvasCommandsInvoker.getInstance();
            System.out.println(event.getY());
            c.execute(event);
            System.out.println("tttttt");
        });
        init();
    }
}
