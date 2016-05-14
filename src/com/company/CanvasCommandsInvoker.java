package com.company;


import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ADMIN on 5/12/2016.
 */
public class CanvasCommandsInvoker implements Invoker, Observable {

    private static CanvasCommandsInvoker invoker = new CanvasCommandsInvoker();
    Stack<Command> undoCommands = new Stack<>();
    Stack<Command> redoCommands = new Stack<>();
    private CanvasCommandsManager manager = new CanvasCommandsManager();
    private CanvasCommandsTypes currentType;
    private List<Observer> observers = new ArrayList<>();

    private CanvasCommandsInvoker() {
    }

    public static CanvasCommandsInvoker getInstance() {

        return invoker;
    }

    public void execute(MouseEvent event) {
        System.out.println(event.getX() + " " + event.getY());
        Command command = new NullCommand();
        System.out.println(currentType == null);
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

    public BridgeShape makeEraser() {
        return manager.makeEraser();
    }

    public Paint getFill() {
        return manager.getFill();
    }

    public void setFill(Paint fill) {
        manager.setFill(fill);
    }

    public EraserFactory getEraserFactory() {
        return manager.getEraserFactory();
    }

    public void setEraserFactory(EraserFactory eraserFactory) {
        manager.setEraserFactory(eraserFactory);
    }

    public ShapeTypes getShape() {
        return manager.getShape();
    }

    public void setShape(ShapeTypes shape) {
        System.out.println(shape);
        manager.setShape(shape);
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
