package com.company;

/**
 * Created by ADMIN on 4/24/2016.
 */
public interface Command {
    void execute();

    void undo();
}
