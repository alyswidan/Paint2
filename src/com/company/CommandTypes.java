package com.company;

/**
 * Created by ADMIN on 5/4/2016.
 */
public enum CommandTypes {
    COPY, PASTE, DELETE, CUT;


    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
