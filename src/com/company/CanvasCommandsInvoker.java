package com.company;


import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class CanvasCommandsInvoker implements Invoker, Observable {

    private CanvasCommandsManager manager = new CanvasCommandsManager();
    private static CanvasCommandsInvoker invoker;
    private CanvasCommandsTypes currentType;
    private List<Observer> observers = new ArrayList<>();
    Stack<Command> undoCommands = new Stack<>();
    Stack<Command> redoCommands = new Stack<>();

    private CanvasCommandsInvoker() {
    }

    public static CanvasCommandsInvoker getInstance() {
        if (invoker == null) {
            invoker = new CanvasCommandsInvoker();
        }
        return invoker;
    }

    public void execute(MouseEvent event) {
        Command command = null;
        if (currentType.equals(CanvasCommandsTypes.DRAW))
            command = new DrawCommand(getShape(), event);
        else if (currentType.equals(CanvasCommandsTypes.ERASE))
            command = new EraseCommand(getEraserFactory());
        else if (currentType.equals(CanvasCommandsTypes.FILL))
            command = new FillCommand(getFill(), event);
        else if (currentType.equals(CanvasCommandsTypes.SELECT))
            command = new SelectCommand(event);
        command.execute();
        undoCommands.push(command);
    }

    public void setCurrentType(CanvasCommandsTypes currentType) {
        this.currentType = currentType;
    }

    public void setEraserFactory(EraserFactory eraserFactory) {
        manager.setEraserFactory(eraserFactory);
    }

    public void setFill(Paint fill) {
        manager.setFill(fill);
    }

    public void setShape(String shape) {
        manager.setShape(shape);
    }

    public Shape makeEraser() {
        return manager.makeEraser();
    }

    public Paint getFill() {
        return manager.getFill();
    }

    public EraserFactory getEraserFactory() {
        return manager.getEraserFactory();
    }

    public String getShape() {
        return manager.getShape();
    }

    @Override
    public void undo() {
        undoCommands.peek().undo();
        redoCommands.push(undoCommands.pop());
    }

    @Override
    public void redo() {

    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(invoker));
    }


}
