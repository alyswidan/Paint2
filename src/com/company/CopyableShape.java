package com.company;

import javafx.scene.shape.*;

/**
 * Created by ADMIN on 4/24/2016.
 */
public class CopyableShape {
    private Shape shape;

    public CopyableShape(Shape copyableShape) {
        this.shape = copyableShape;
    }
    private CopyableShape(){this.shape = null;}
    //should return copyableshape but not yet updated

     Shape copy()
     {
         Shape copyableVersion = null;
         if(shape instanceof Circle)
            copyableVersion = copyCircle();
         else if(shape instanceof Rectangle)
            copyableVersion = copyRect();
         else if(shape instanceof Line)
             copyableVersion = copyLine();
         else if(shape instanceof Polygon)
             copyableVersion = copyPolygon();
         else if (shape instanceof Ellipse)
             copyableVersion = copyPolygon();

         return copyableVersion;
     }





    private Shape copyCircle() {
        Circle circle = new Circle(((Circle) shape).getCenterX(),
                ((Circle) shape).getCenterY(),
                ((Circle) shape).getRadius());
        circle.setStyle(shape.getStyle());
        return circle;
    }


    private Shape copyRect() {
        Rectangle rectangle = new Rectangle(((Rectangle)shape).getX(),
                ((Rectangle)shape).getY(),
                ((Rectangle)shape).getWidth(),
                ((Rectangle)shape).getHeight());
        rectangle.setStyle(shape.getStyle());
        return rectangle;
    }

    private Shape copyEllipse()
    {
        Ellipse ellipse = new Ellipse(((Ellipse) shape).getCenterX(),
                ((Ellipse) shape).getCenterY(),
                ((Ellipse) shape).getRadiusX(),
                ((Ellipse) shape).getRadiusY());
        ellipse.setStyle(shape.getStyle());
        return ellipse;
    }

    private Shape copyLine()
    {
        Line line = new Line(((Line) shape).getStartX(), ((Line) shape).getStartY()
                , ((Line) shape).getEndX(), ((Line) shape).getEndY());
        line.setStyle((shape).getStyle());
        return line;
    }

    private Shape copyPolygon()
    {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(((Polygon) shape).getPoints());
        polygon.setStyle(shape.getStyle());
        return  polygon;
    }

    private Shape copyEmpty()
    {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CopyableShape that = (CopyableShape) o;

        return shape != null ? shape.equals(that.shape) : that.shape == null;

    }

    @Override
    public int hashCode() {
        return shape != null ? shape.hashCode() : 0;
    }
}
