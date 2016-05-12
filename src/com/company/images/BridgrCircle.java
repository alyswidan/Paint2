package com.company.images;

import com.company.BridgeShape;
import javafx.scene.shape.Circle;
import sun.corba.Bridge;

/**
 * Created by user on 5/12/2016.
 */
public class BridgrCircle extends BridgeShape {

    public BridgrCircle(double radius) {
        shape = new Circle();
        ((Circle) shape).setRadius(radius);
    }

}
