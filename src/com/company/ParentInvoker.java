package com.company;

/**
 * Created by ADMIN on 5/11/2016.
 */
public class ParentInvoker implements Observer,Invoker
{
    Invoker lastExcuter;


    @Override
    public void undo() {
        lastExcuter.undo();
    }

    @Override
    public void redo() {
        lastExcuter.redo();
    }

    @Override
    public void update(Invoker invoker) {
        lastExcuter = invoker;

    }
}
