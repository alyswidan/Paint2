package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class SelectionManager {
    private static SelectionManager ourInstance;
    private List<Selection> selections;

    private SelectionManager() {
        selections = new ArrayList<>();
    }

    public static SelectionManager getInstance() {
        if (ourInstance == null)
            ourInstance = new SelectionManager();
        return ourInstance;

    }

    public void add(Selection selection) {
        selections.add(selection);
    }

    public void cancelAll() {
        selections.forEach(Selection::cancel);
        selections.forEach(selections::remove);
    }

    public void remove(Selection selection) {
        selections.remove(selection);
    }

    public List<Selection> getSelections() {
        return selections;
    }

    public Optional<Selection> isInSelection(double x, double y) {
        return selections.stream().filter(selection -> selection.contains(x, y)).findFirst();
    }

}
