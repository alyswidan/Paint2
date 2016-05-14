package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Created by user on 5/13/2016.
 */
public class Controller {

    @FXML
    private VBox root;

    @FXML
    private ToggleButton line, rectangle, square, righttriangle, isoscelestriangle,
            equilateraltriangle, circle, ellipse, polygon, select, fill, erase;
    @FXML
    private TextField strokeWidth;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private CheckBox gridView;

    @FXML
    private Button copy, cut, paste, delete, undo, redo;

    @FXML
    private ListView<Command> commandHistory;

    @FXML
    private GridPane gridShape;

    @FXML
    public void initialize() {
        line.setSelected(true);
        strokeWidth.setText("1");
        colorPicker.setValue(Color.BLACK);
        root.setVgrow(DrawingCanvas.getInstance().getCanvas().node, Priority.ALWAYS);
        DrawingCanvas.getInstance().getCanvas().node.minWidth(1360);
        ((Pane) DrawingCanvas.getInstance().getCanvas().node).getChildren().add(new Line(0, 0, 1360, 0));
        root.getChildren().add(DrawingCanvas.getInstance().getCanvas().node);
        root.getChildren().forEach(node -> System.out.println(node.getId() + node.getLayoutX()));
    }

    @FXML
    public void handleDraw() {
        CanvasCommandsInvoker.getInstance().setCurrentType(CanvasCommandsTypes.DRAW);
    }

    @FXML
    public void handleTools(EventTarget eventTarget) {
        if (eventTarget.equals(select)) {
            CanvasCommandsInvoker.getInstance().setCurrentType(CanvasCommandsTypes.SELECT);
        } else if (eventTarget.equals(fill)) {
            CanvasCommandsInvoker.getInstance().setCurrentType(CanvasCommandsTypes.FILL);
        } else if (eventTarget.equals(erase)) {
            CanvasCommandsInvoker.getInstance().setCurrentType(CanvasCommandsTypes.ERASE);
        }
    }

    @FXML
    public void handleCanvas(MouseEvent actionEvent) {
        System.out.println(actionEvent.getTarget());

        if (actionEvent.getTarget().equals(line)) {
            CanvasCommandsInvoker.getInstance().setShape(ShapeTypes.LINE);
            handleDraw();
        } else if (actionEvent.getTarget().equals(rectangle)) {
            CanvasCommandsInvoker.getInstance().setShape(ShapeTypes.RECTANGLE);
            handleDraw();
        } else if (actionEvent.getTarget().equals(square)) {
            CanvasCommandsInvoker.getInstance().setShape(ShapeTypes.SQUARE);
            handleDraw();
        } else if (actionEvent.getTarget().equals(righttriangle)) {
            CanvasCommandsInvoker.getInstance().setShape(ShapeTypes.RIGHTTRIANGLE);
            handleDraw();
        } else if (actionEvent.getTarget().equals(isoscelestriangle)) {
            CanvasCommandsInvoker.getInstance().setShape(ShapeTypes.ISOSCELESTRIANGLE);
            handleDraw();
        } else if (actionEvent.getTarget().equals(equilateraltriangle)) {
            CanvasCommandsInvoker.getInstance().setShape(ShapeTypes.EQUILATERALTRIANGLE);
            handleDraw();
        } else if (actionEvent.getTarget().equals(circle)) {
            CanvasCommandsInvoker.getInstance().setShape(ShapeTypes.CIRCLE);
            handleDraw();
        } else if (actionEvent.getTarget().equals(ellipse)) {
            CanvasCommandsInvoker.getInstance().setShape(ShapeTypes.ELLIPSE);
            handleDraw();
        } else if (actionEvent.getTarget().equals(polygon)) {
            CanvasCommandsInvoker.getInstance().setShape(ShapeTypes.POLYGON);
            handleDraw();
        }

        /*else if (actionEvent.getTarget().equals(select) || actionEvent.getTarget().equals(select)
                || actionEvent.getTarget().equals(select)) {
            handleTools(actionEvent.getTarget());
        }*/
    }

    @FXML
    public void handleClipboard(ActionEvent actionEvent) {
        if (actionEvent.getTarget().equals(copy)) {

        } else if (actionEvent.getTarget().equals(cut)) {

        } else if (actionEvent.getTarget().equals(paste)) {

        } else if (actionEvent.getTarget().equals(delete)) {

        }
    }

}
