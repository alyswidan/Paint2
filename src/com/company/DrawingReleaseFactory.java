package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;

/**
 * Created by user on 5/2/2016.
 */
public class DrawingReleaseFactory {


    public EventHandler<MouseEvent> makeHandler(String string, DrawingClickFactory clickFactory) {
        EventHandler<MouseEvent> release = null;
        boolean[] esc = {false};
        if (string.compareToIgnoreCase("circle") == 0 || string.compareToIgnoreCase("ellipse") == 0 ||
                string.compareToIgnoreCase("rectangle") == 0 || string.compareToIgnoreCase("line") == 0 ||
                string.compareToIgnoreCase("square") == 0 || string.compareToIgnoreCase("righttriangle") == 0 ||
                string.compareToIgnoreCase("isoscelestriangle") == 0) {
            release = event -> {
                DrawingCanvas.getInstance().getCanvas().removeEventHandler(MouseEvent.MOUSE_DRAGGED, clickFactory.getDrag());
            };
        } else if (string.compareToIgnoreCase("polygon") == 0) {
            while (esc[0] != true) {
                EventHandler<KeyEvent> keyEvent = event3 -> {
                    if (event3.getCode() == KeyCode.ESCAPE) {
                        esc[0] = true;
                    }
                };
                release = event -> {
                    EventHandler<MouseEvent> click = event2 -> {
                        ((Polygon) clickFactory.getShape()).getPoints().addAll(event2.getX(), event2.getY());
                    };
                };
            }
        } else if (string.compareToIgnoreCase("triangle") == 0) {
            int count = 1;
            while (count != 3) {
                release = event -> {
                    EventHandler<MouseEvent> click = event2 -> {
                        ((Polygon) clickFactory.getShape()).getPoints().addAll(event2.getX(), event2.getY());
                    };
                };
                count++;
            }
        }
        else if (string.compareToIgnoreCase("righttriangle") == 0) {
            int count = 1;
            while (count != 3) {
                release = event -> {
                    EventHandler<MouseEvent> click = event2 -> {
                        ((Polygon) clickFactory.getShape()).getPoints().addAll(event2.getX(), event2.getY());
                    };
                };
                count++;
            }
        }
        return release;
    }
}
