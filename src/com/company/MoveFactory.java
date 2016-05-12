package com.company;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Translate;

/**
 * Created by user on 5/2/2016.
 */
public class MoveFactory {


    private Selection selection;
    private DragContext dragContext;
    public MoveFactory(Selection selection,DragContext dragContext) {
        this.selection = selection;
        this.dragContext = dragContext;
    }

    public EventHandler<MouseEvent> makeDragHandler() {

        return event -> {
            selection.addTransform(new Translate(event.getX()-dragContext.getAnchorX(),event.getY()-dragContext.getAnchorY()));
        };
    }


}
