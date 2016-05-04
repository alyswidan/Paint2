package com.company;

import javafx.scene.shape.Shape;

import java.util.*;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class SelectionManager {
    private static SelectionManager ourInstance;
    private List<Selection> selections;

    public static SelectionManager getInstance() {
        if (ourInstance == null)
            ourInstance = new SelectionManager();
        return ourInstance;

    }

    private SelectionManager() {
    }

    public void add(Selection selection) {
        selections.add(selection);
    }

    public void cancelAll()
    {
        selections.forEach(Selection::cancel);
        for (int i = 0; i <selections.size() ; i++) {
            selections.remove(i);
        }
    }
    public void remove(Selection selection) {selections.remove(selection);}
    public List<Selection> getSelections(){return selections;}
/*
    public boolean isSelected(Shape shape) {
        Selection required = Selection.fromSingleShape(shape);//check this siwii
        if (selections.containsKey(required)) return true;
        for (Selection selection : selections.keySet())
            if (selections.get(selection).getBounds().contains(required.getBounds())) return true;
        return false;
    }
*/

}
