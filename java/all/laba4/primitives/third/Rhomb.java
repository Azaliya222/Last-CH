package all.laba4.primitives.third;

import all.laba4.etc.Log;
import all.laba4.primitives.Point;
import all.laba4.primitives.second.TQuadrangle;

import java.awt.*;
import java.util.Arrays;

public class Rhomb extends TQuadrangle {
    public Rhomb(Point center, int diagonal1, int diagonal2, Color color) {
        super(new Point[]{
                new Point(center.getX(), center.getY() - diagonal1/2),
                new Point(center.getX() + diagonal2 /2, center.getY()),
                new Point(center.getX(), center.getY()+diagonal1/2),
                new Point(center.getX() - diagonal2 / 2, center.getY())
        }, color);
        Log.create("rhomb create at: " + getCenter());
    }
    public void change(int newXy,int newYy) {
        Point t = getPoints()[0];
        for (int i = 1; i < getPoints().length; i++) {
            Point point = getPoints()[i];
            int newX = t.getX() + (point.getY() - t.getY());
            int newY = t.getY() - (point.getX() - t.getX());
            point.setX(newX);
            point.setY(newY);
        }
        Log.change("Rhomb: " + this);
    }

    @Override
    public String toString() {
        return ("Rhombus={" +
                "points=" + Arrays.toString(getPoints())+
                "}"
        );
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }

}