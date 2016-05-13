package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by user on 5/13/2016.
 */
public class Controller {

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
    private Button copy,cut,paste,delete,undo,redo;

    @FXML
    private ListView<Command> commandHistory;

    @FXML
    private GridPane gridShape;

    @FXML
    public void initialize(){
        line.setSelected(true);
        strokeWidth.setText("1");
        colorPicker.setValue(Color.WHITE);
    }

    @FXML
    public void handleDraw(){
        CanvasCommandsInvoker.getInstance().setCurrentType(CanvasCommandsTypes.DRAW);
    }

    @FXML
    public  void handleTools(EventTarget eventTarget){
        if(eventTarget.equals(select)){
            CanvasCommandsInvoker.getInstance().setCurrentType(CanvasCommandsTypes.SELECT);
        }
        else if(eventTarget.equals(fill)){
            CanvasCommandsInvoker.getInstance().setCurrentType(CanvasCommandsTypes.FILL);
        }
        else if(eventTarget.equals(erase)){
            CanvasCommandsInvoker.getInstance().setCurrentType(CanvasCommandsTypes.ERASE);
        }
    }

    @FXML
    public void handleCanvas(ActionEvent actionEvent){
        if(actionEvent.getSource().equals(gridShape)){
            handleDraw();
        }
        else if(actionEvent.getTarget().equals(select) || actionEvent.getTarget().equals(select)
                || actionEvent.getTarget().equals(select)){
            handleTools(actionEvent.getTarget());
        }
    }

    @FXML
    public void handleClipboard(ActionEvent actionEvent){
        if(actionEvent.getTarget().equals(copy)){

        }
        else if(actionEvent.getTarget().equals(cut)){

        }
        else if(actionEvent.getTarget().equals(paste)){

        }
        else if(actionEvent.getTarget().equals(delete)){

        }
    }

}
