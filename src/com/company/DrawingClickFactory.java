package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;

/**
 * Created by Amr on 4/27/2016.
 */
public class DrawingClickFactory {

    private Shape shape;
    private EventHandler<MouseEvent> drag = null;
    private DragContext pivot = new DragContext();
    private EventHandler<MouseEvent> click;
    public EventHandler<MouseEvent> makeHandler(String string) {

        String style = "-fx-stroke:black;-fx-fill:null;-fx-stroke-width:1px;";
        if (string.compareToIgnoreCase("Circle") == 0) {
            shape = new Circle();
            shape.setStyle(style);
            drag = e -> {
                double dx = e.getX() - pivot.getAnchorX();
                double dy = e.getY() - pivot.getAnchorY();
                ((Circle) shape).setRadius(Math.sqrt(dx * dx + dy * dy));
            };
            click = event ->
            {
                ((Circle) shape).setCenterX(event.getX());
                ((Circle) shape).setCenterY(event.getY());
                pivot.setAnchorX(event.getX());
                pivot.setAnchorY(event.getY());

            };
        } else if (string.compareToIgnoreCase("rectangle") == 0) {
            shape = new Rectangle();
            drag = e -> {
                double dx = e.getX() - pivot.getAnchorX();
                double dy = e.getY() - pivot.getAnchorY();
                ((Rectangle) shape).setWidth(dx);
                ((Rectangle) shape).setHeight(dy);
            };
            shape.setStyle(style);

            click = event -> {
                ((Rectangle) shape).setX(event.getX());
                ((Rectangle) shape).setY(event.getY());
                pivot.setAnchorX(event.getX());
                pivot.setAnchorY(event.getY());
            };
        } else if (string.compareToIgnoreCase("square") == 0) {
            shape = new Rectangle();
            shape.setStyle(style);
            drag = e -> {
                double dx = e.getX() - pivot.getAnchorX();
                double dy = e.getY() - pivot.getAnchorY();
                double dh = Math.sqrt(dx * dx + dy * dy);
                ((Rectangle) shape).setWidth(dh * Math.cos(45));
                ((Rectangle) shape).setHeight(dh * Math.sin(45));
            };
            click = event -> {
                ((Rectangle) shape).setX(event.getX());
                ((Rectangle) shape).setY(event.getY());
                pivot.setAnchorX(event.getX());
                pivot.setAnchorY(event.getY());


            };
        } else if (string.compareToIgnoreCase("ellipse") == 0) {
            shape = new Ellipse();
            shape.setStyle(style);
            drag = e -> {
                double dx = e.getX() -pivot.getAnchorX();
                double dy = e.getY() - pivot.getAnchorY();
                //keda zay el paint ka2enak betresize rectangle
                ((Ellipse) shape).setRadiusX(dx);
                ((Ellipse) shape).setRadiusY(dy);
            };
            click = event -> {
                ((Ellipse) shape).setCenterX(event.getX());
                ((Ellipse) shape).setCenterY(event.getY());
                pivot.setAnchorX(event.getX());
                pivot.setAnchorY(event.getY());

            };
        } else if (string.compareToIgnoreCase("line") == 0) {
            shape = new Line();
            shape.setStyle(style);
            drag = e -> {
                ((Line) shape).setEndX(e.getX());
                ((Line) shape).setEndY(e.getY());
            };
            click = event -> {
                ((Line) shape).setStartX(event.getX());
                ((Line) shape).setStartY(event.getY());
            };
        } else if (string.compareToIgnoreCase("polygon") == 0) {
            shape = new Polygon();
            shape.setStyle(style);
            click = event -> {
                ((Polygon) shape).getPoints().addAll(event.getX(), event.getY());

            };
        } else if (string.compareToIgnoreCase("triangle") == 0) {
            shape = new Polygon();
            shape.setStyle(style);
            click = event -> {
                ((Polygon) shape).getPoints().addAll(event.getX(), event.getY());

            };
        } else if (string.compareToIgnoreCase("righttriangle") == 0) {
            shape = new Polygon();
            shape.setStyle(style);
            drag = e -> {
                ((Polygon) shape).getPoints().addAll(pivot.getAnchorX(), e.getY(), e.getX(), e.getY());
            };
            click = event -> {
                ((Polygon) shape).getPoints().addAll(event.getX(), event.getY());
                pivot.setAnchorX(event.getX());
                pivot.setAnchorY(event.getY());

            };
        } else if (string.compareToIgnoreCase("isoscelestriangle") == 0) {
            shape = new Polygon();
            shape.setStyle(style);
            drag = e -> {
                if (e.getX() > pivot.getAnchorX()) {
                    ((Polygon) shape).getPoints().addAll(e.getX(), e.getY(), e.getX() - pivot.getAnchorX(), e.getY());
                } else {
                    ((Polygon) shape).getPoints().addAll(e.getX(), e.getY(), e.getX() + pivot.getAnchorX(), e.getY());
                }
            };
            click = event -> {
                ((Polygon) shape).getPoints().addAll(event.getX(), event.getY());
                pivot.setAnchorX(event.getX());
                pivot.setAnchorY(event.getY());

            };
        }


        return event -> {
            click.handle(event);
            DrawingCanvas.getInstance().getCanvas().addEventHandler(MouseEvent.MOUSE_DRAGGED, drag);

        };
    }

    public EventHandler<MouseEvent> getDrag() {
        return drag;
    }

    public Shape getShape() {
        return shape;
    }
}
