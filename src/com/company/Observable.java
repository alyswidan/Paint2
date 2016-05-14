package com.company;

/**
 * Created by ADMIN on 5/11/2016.
 */
public interface Observable {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();


}
