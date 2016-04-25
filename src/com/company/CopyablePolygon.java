package com.company;

import javafx.scene.shape.Polygon;

/**
 * Created by user on 4/25/2016.
 */
public class CopyablePolygon implements CopyableShape{

    private Polygon polygon;

    @Override
    public void copy() {
        Polygon polygon2 = new Polygon();
        polygon2.getPoints().addAll(polygon.getPoints());
        polygon2.setStyle(polygon.getStyle());
        ShapeClipboard.getInstance().set(polygon2);
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }
}
