package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.scene.transform.Scale;

/**
 * Created by Amr on 4/27/2016.
 */
public class DrawingClickFactory {

    private EventHandler<MouseEvent> drag = null;
    public   EventHandler<MouseEvent> makeHandler(String string) {
        EventHandler<MouseEvent> click = null;
        double pivot[] = new double[2];
        String style = "-fx-stroke:black;-fx-fill:null;-fx-stroke-width:1px;";
        if (string.compareToIgnoreCase("Circle")==0) {
            Circle circle = new Circle();
            circle.setStyle(style);
            click = event ->
            {
                circle.setCenterX(event.getX());
                circle.setCenterY(event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
                drag = e -> {
                    double dx = event.getX() - pivot[0];
                    double dy = event.getY() - pivot[1];
                    circle.setRadius(Math.sqrt(dx*dx+dy*dy));
                };
            };
        } else if (string.compareToIgnoreCase("rectangle")==0) {
            Rectangle rectangle = new Rectangle();
            rectangle.setStyle(style);
            click = event ->
            {
                rectangle.setX(event.getX());
                rectangle.setY(event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
                drag = e -> {
                    double dx = event.getX() - pivot[0];
                    double dy = event.getY() - pivot[1];
                    rectangle.setWidth(dx);
                    rectangle.setHeight(dy);
                };
            };
        } else if (string.compareToIgnoreCase("ellipse")==0) {//we were trying to find a way to get the \x and y radii given a point on the
            //ellipse provided by the point where mouse is released
            Ellipse ellipse = new Ellipse();
            ellipse.setStyle(style);
            click = event -> {
                ellipse.setCenterX(event.getX());
                ellipse.setCenterY(event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
                drag = e -> {
                    double dx = event.getX() - pivot[0];
                    double dy = event.getY() - pivot[1];
                    ellipse.setRadiusX();
                    ellipse.setRadiusY();
                };
            };
        } else if (string.compareToIgnoreCase("line")==0) {
            Line line = new Line();
            line.setStyle(style);
            click = event -> {
                line.setStartX(event.getX());
                line.setStartY(event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
                drag = e -> {
                    double dx = event.getX() - pivot[0];
                    double dy = event.getY() - pivot[1];
                    line.setEndX(event.getX());
                    line.setEndY(event.getY());
                };
            };
        } else if (string.compareToIgnoreCase("polygon")==0) {
            boolean esc = false;
            Polygon polygon = new Polygon();
            polygon.setStyle(style);
            click = event -> {
                polygon.getPoints().addAll(event.getX(),event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
            };
        }

        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_DRAGGED,drag);
        return click;
    }

    public EventHandler<MouseEvent> getDrag()
    {
        return drag;
    }


}
