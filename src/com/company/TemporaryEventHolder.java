package com.company;

import javafx.event.EventHandler;

/**
 * Created by ADMIN on 5/3/2016.
 */
public class TemporaryEventHolder<T extends EventHandler> {
    private T event;



    public T getEvent() {
        return event;
    }

    public void setEvent(T event) {
        this.event = event;
    }
}
