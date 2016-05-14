package com.company;

import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by ADMIN on 5/11/2016.
 */
public class SelectionCommandsInvoker implements Observable, Invoker {
    private static SelectionCommandsInvoker invoker;
    Selection selection;
    Stack<Command> undoCommands = new Stack<>();
    Stack<Command> redoCommands = new Stack<>();
    List<Observer> observers = new ArrayList<>();

    private SelectionCommandsInvoker() {
    }

    ;

    public static SelectionCommandsInvoker getInstance() {
        if (invoker == null) {
            invoker = new SelectionCommandsInvoker();
        }
        return invoker;
    }

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    public void execute(MouseEvent event) {
        Point2D point = new Point2D(event.getX(), event.getY());
        Command command;
        if (selection.isAResizeAnchor(point)) command = new ResizeCommand(selection, event);
        else if (selection.getRotationHandlePos().equals(point)) command = new RotateCommand(selection, event);
        else command = new moveCommand(selection, event);
        undoCommands.push(command);
        notifyObservers();
        command.execute();

    }

    public void undo() {
        undoCommands.peek().undo();
        redoCommands.push(undoCommands.pop());
    }

    public void redo() {
        redoCommands.peek().execute();
        undoCommands.push(redoCommands.pop());
    }

    public List<Command> getUndoHistory() {
        return undoCommands.stream().collect(Collectors.toList());
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
