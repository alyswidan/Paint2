package com.company;

import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by ADMIN on 5/11/2016.
 */
public class EditCommandsInvoker implements Observable,Invoker {

    Selection selection;
    private Stack<Command> undoCommands = new Stack<>();
    private Stack<Command> redoCommands = new Stack<>();
    private List<Observer> observers = new ArrayList<>();
    List<Class<? extends Command>> commands = new ArrayList<>();
    private static EditCommandsInvoker invoker;

    private EditCommandsInvoker() {
        commands.set(CommandTypes.PASTE.ordinal(), PasteCommand.class);
        commands.set(CommandTypes.COPY.ordinal(), CopyCommand.class);
        commands.set(CommandTypes.DELETE.ordinal(), DeleteCommand.class);
    }

    ;

    public static EditCommandsInvoker getInstance() {
        if (invoker == null) {
            invoker = new EditCommandsInvoker();
        }
        return invoker;
    }

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    public void execute(CommandTypes type) {
        try {
            Command command;
            if (type.equals(CommandTypes.PASTE))
                command = commands.get(type.ordinal()).getConstructor().newInstance();
            else command = commands.get(type.ordinal()).getConstructor(Selection.class).newInstance(selection);
            undoCommands.push(command);
            notifyObservers();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void undo() {
        undoCommands.peek().undo();
        redoCommands.push(undoCommands.pop());
    }
    @Override
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
