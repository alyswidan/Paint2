package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class Invoker {
    List<Command> commands = new ArrayList<>(CommandTypes.values().length);
    Stack<Command> undoCommands = new Stack<>();
    Stack<Command> redoCommands = new Stack<>();

    public void setCommand(CommandTypes type,Command command)
    {
        commands.set(type.ordinal(),command);
    }

    public void execute(CommandTypes type){
        commands.get(type.ordinal()).execute();
        undoCommands.push(commands.get(type.ordinal()));
    }
    public void undo()
    {
        undoCommands.peek().undo();
        redoCommands.push(undoCommands.pop());
    }

    public void redo()
    {
        redoCommands.peek().execute();
        undoCommands.push(redoCommands.pop());
    }

    public List<Command> getUndoHistory()
    {
        return Arrays.asList(undoCommands.toArray(new Command[undoCommands.size()]));
    }











}
