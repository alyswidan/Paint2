package com.company;

import java.util.Stack;

/**
 * Created by ADMIN on 5/11/2016.
 */
public class ParentInvoker implements Observer, Invoker {
    private Stack<Invoker> executersUndo;
    private Stack<Invoker> executersRedo;

    public ParentInvoker() {
        executersUndo = new Stack<>();
        executersRedo = new Stack<>();
        CanvasCommandsInvoker.getInstance().registerObserver(this);
        EditCommandsInvoker.getInstance().registerObserver(this);
        SelectionCommandsInvoker.getInstance().registerObserver(this);
    }

    @Override
    public void undo() {
        executersRedo.push(executersUndo.peek());
        executersUndo.pop().undo();
    }

    @Override
    public void redo() {
        executersRedo.peek();
    }

    @Override
    public void update(Invoker invoker) {
        executersUndo.push(invoker);
    }
}
