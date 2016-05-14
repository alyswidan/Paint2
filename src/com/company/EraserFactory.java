package com.company;

/**
 * Created by ADMIN on 5/8/2016.
 */
@FunctionalInterface
public interface EraserFactory {
    //imagine each eraser being inscribed in a circle to generify the design to any shape
    BridgeShape makeEraser();
}
