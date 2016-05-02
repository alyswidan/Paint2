package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.scene.transform.Scale;

/**
 * Created by Amr on 4/27/2016.
 */
public class DrawingClickFactory {

    private Shape shape;
    private EventHandler<MouseEvent> drag = null;

    public EventHandler<MouseEvent> makeHandler(String string) {
        EventHandler<MouseEvent> click = null;
        double pivot[] = new double[2];
        String style = "-fx-stroke:black;-fx-fill:null;-fx-stroke-width:1px;";
        if (string.compareToIgnoreCase("Circle") == 0) {
            shape = new Circle();
            shape.setStyle(style);
            click = event ->
            {
                ((Circle) shape).setCenterX(event.getX());
                ((Circle) shape).setCenterY(event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
                drag = e -> {
                    double dx = event.getX() - pivot[0];
                    double dy = event.getY() - pivot[1];
                    ((Circle) shape).setRadius(Math.sqrt(dx * dx + dy * dy));
                };
            };
        } else if (string.compareToIgnoreCase("rectangle") == 0) {
            shape = new Rectangle();
            shape.setStyle(style);
            click = event -> {
                ((Rectangle) shape).setX(event.getX());
                ((Rectangle) shape).setY(event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
                drag = e -> {
                    double dx = event.getX() - pivot[0];
                    double dy = event.getY() - pivot[1];
                    ((Rectangle) shape).setWidth(dx);
                    ((Rectangle) shape).setHeight(dy);
                };
            };
        } else if (string.compareToIgnoreCase("square") == 0) {
            shape = new Rectangle();
            shape.setStyle(style);
            click = event -> {
                ((Rectangle) shape).setX(event.getX());
                ((Rectangle) shape).setY(event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
                drag = e -> {
                    double dx = event.getX() - pivot[0];
                    double dy = event.getY() - pivot[1];
                    double dh = Math.sqrt(dx * dx + dy * dy);
                    ((Rectangle) shape).setWidth(dh * Math.cos(45));
                    ((Rectangle) shape).setHeight(dh * Math.sin(45));
                };
            };
        } else if (string.compareToIgnoreCase("ellipse") == 0) {
            shape = new Ellipse();
            shape.setStyle(style);
            click = event -> {
                ((Ellipse) shape).setCenterX(event.getX());
                ((Ellipse) shape).setCenterY(event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
                drag = e -> {
                    double dx = event.getX() - pivot[0];
                    double dy = event.getY() - pivot[1];
                    //keda zay el paint ka2enak betresize rectangle
                    ((Ellipse) shape).setRadiusX(dx);
                    ((Ellipse) shape).setRadiusY(dy);

                };
            };
        } else if (string.compareToIgnoreCase("line") == 0) {
            shape = new Line();
            shape.setStyle(style);
            click = event -> {
                ((Line) shape).setStartX(event.getX());
                ((Line) shape).setStartY(event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
                drag = e -> {
                    ((Line) shape).setEndX(event.getX());
                    ((Line) shape).setEndY(event.getY());
                };
            };
        } else if (string.compareToIgnoreCase("polygon") == 0) {
            shape = new Polygon();
            shape.setStyle(style);
            click = event -> {
                ((Polygon)shape).getPoints().addAll(event.getX(), event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
            };
        } else if (string.compareToIgnoreCase("triangle") == 0) {
            shape = new Polygon();
            shape.setStyle(style);
            click = event -> {
                ((Polygon)shape).getPoints().addAll(event.getX(), event.getY());
                pivot[0] = event.getX();
                pivot[1] = event.getY();
            };
        }

        DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_DRAGGED, drag);
        return click;
    }

    public EventHandler<MouseEvent> getDrag() {
        return drag;
    }

    public Shape getShape() {
        return shape;
    }
}
