package all.laba4.primitives.second;

import all.laba4.etc.Log;
import all.laba4.primitives.Point;
import all.laba4.primitives.TFigure;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class TQuadrangle extends TFigure {
    private Point[] points; // Массив для хранения вершин четырехугольника
    private Color color;

    public TQuadrangle(Point[] points, Color color) {
        super(points);
        if (points.length != 4) throw new IllegalArgumentException("Четырехугольник должен иметь 4 вершины.");
        this.points = orderPoints(points);
        Log.create("TQuadrangle at " +getCenter());
    }


    public void changeSize(int deltaX, int deltaY) {
        Point center = getPoints()[0];
        for (Point point : points) {
            int newX = center.getX() + (point.getY() - center.getY());
            int newY = center.getY() - (point.getX() - center.getX());
            point.setX(newX);
            point.setY(newY);
        }
        Log.change("quadrilateral at: " + getCenter());
    }

    public Point[] getPoints() {
        return points;
    }
    public void setPoints(Point[] points) {
        if (points.length != 4) throw new IllegalArgumentException("Четырехугольник должен иметь 4 вершины.");
        this.points = orderPoints(points);
    }

    private Point[] orderPoints(Point[] points) {
        int centerX = 0;
        int centerY = 0;
        for (Point point : points) {
            centerX += point.getX();
            centerY += point.getY();
        }
        centerX /= 4;
        centerY /= 4;

        final int finalCenterX = centerX;
        final int finalCenterY = centerY;
        Arrays.sort(points, Comparator.comparingDouble(point -> Math.atan2(point.getY() - finalCenterY, point.getX() - finalCenterX)));
        return points;
    }

    @Override
    public void show(Graphics g) {
        if (!isVisible()) return;
        setGraphics(g);
        g.setColor(color);

        int[] xPoints = new int[4];
        int[] yPoints = new int[4];

        for (int i = 0; i < 4; i++) {
            xPoints[i] = points[i].getX();
            yPoints[i] = points[i].getY();
        }
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(Color.BLUE);
        g.drawPolygon(xPoints, yPoints, 4);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.gc();

        Log.delete("quadrilateral at " + getCenter());
    }


    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }
}


