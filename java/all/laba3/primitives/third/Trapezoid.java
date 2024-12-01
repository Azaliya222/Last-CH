package all.laba3.primitives.third;

import all.laba3.etc.Log;
import  all.laba3.primitives.second.TQuadrangle;
import all.laba3.primitives.Point;


import java.awt.*;
import java.util.Arrays;

public class Trapezoid extends TQuadrangle {
    public Trapezoid(Point  topLeft, int topWidth, int bottomWidth, int height, Color color) {
        super(new Point[]{
                topLeft,
                new Point(topLeft.getX() + topWidth, topLeft.getY()),
                new Point(topLeft.getX() + (bottomWidth - topWidth) / 2, topLeft.getY() + height),
                new Point(topLeft.getX() - (bottomWidth - topWidth), topLeft.getY() + height),
        }, color);
        Log.create("Trapezoid create at: " + getCenter());
    }

    public void change(int newd, int newk) {
        Point topLeft = getPoints()[0];

        for (int i = 1; i < getPoints().length; i++) {
            Point point = getPoints()[i];
            int newX = topLeft.getX() + (point.getY() - topLeft.getY());
            int newY = topLeft.getY() - (point.getX() - topLeft.getX());
            point.setX(newX);
            point.setY(newY);
        }
        System.out.println("[ROTATE] " + this);
    }

    @Override
    public String toString() {
        return "Trapezoid={" +
                "points=" + Arrays.toString(getPoints()) +
                "}";
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }
}


