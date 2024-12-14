package all.laba5.primitives.third;

import all.laba5.etc.Log;
import all.laba5.primitives.Point;
import all.laba5.primitives.second.TQuadrangle;

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
        Log.create("rhomb create at: " + Arrays.toString(getCenter()));
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
    public void show(Graphics g) {
        setGraphics(g);

        // Устанавливаем цвет заливки
        g.setColor(getColor());

        // Получаем точки ромба
        Point[] points = getPoints();

        // Создаем массив координат для рисования
        int[] xPoints = new int[points.length];
        int[] yPoints = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            xPoints[i] = points[i].getX();
            yPoints[i] = points[i].getY();
        }

        // Рисуем заполненный ромб
        g.fillPolygon(xPoints, yPoints, points.length);

        // Рисуем контур ромба
        g.setColor(Color.BLACK); // Устанавливаем цвет линии для обводки
        g.drawPolygon(xPoints, yPoints, points.length);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("[DELETE] " + this);
    }

}