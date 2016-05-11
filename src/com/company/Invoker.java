package com.company;

import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by ADMIN on 4/25/2016.
 */
public interface Invoker {
    void undo();
    void redo();
}
