package com.company;

import java.util.Stack;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class ShapeClipboard {
    private static ShapeClipboard clipboard;
    private Stack<Selection> previous;
    private Selection current;

    private ShapeClipboard() {
        previous = new Stack<>();
    }

    public static ShapeClipboard getInstance() {
        if (clipboard == null) clipboard = new ShapeClipboard();
        return clipboard;
    }

    public void set(Selection selection) {
        previous.push(current);
        current = selection;
    }

    public Selection get() {

        return current;
    }

    public void undoLast() {
        current = previous.pop();
    }
}
