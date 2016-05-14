package com.company;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

/**
 * Created by ADMIN on 4/25/2016.
 */
public class ResizeCommand extends GeometricCommand {

    private EventHandler<MouseEvent> drag;
    private Selection selection;
    private MouseEvent event;


    public ResizeCommand(Selection selection, MouseEvent event) {
        this.selection = selection;
        this.event = event;
    }

    @Override
    public void execute() {
        // record the number of transforms when mouse is pressed
        //undoing is just removing the transforms added in the drag handler
        startTransformIndex = selection.getTransforms().size();
        drag = (new ResizeFactory(new Point2D(event.getX(),
                event.getY()), selection).makeHandler());
        selection.addOnDrag(drag);
        selection.addOnRelease(e -> selection.removeOnDrag(drag));
    }


}
