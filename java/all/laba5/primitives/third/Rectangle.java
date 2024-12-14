package all.laba5.primitives.third;

import all.laba5.etc.Log;
import all.laba5.primitives.Point;
import all.laba5.primitives.second.TQuadrangle;

import java.awt.*;
import java.util.Arrays;

public class Rectangle extends TQuadrangle {
    private int width;
    private int height;

    public Rectangle(Point topLeft, int width, int height, Color color) {
        super(new Point[]{
                topLeft,
                new Point(topLeft.getX() + width, topLeft.getY()), // Верхний правый угол
                new Point(topLeft.getX() + width, topLeft.getY() + height), // Нижний правый угол
                new Point(topLeft.getX(), topLeft.getY() + height) // Нижний левый угол
        }, color);
        this.width = width;
        this.height = height;
        Log.create("Rectangle " + getCenter());
    }

    public Rectangle(Point topLeft, int width, int height) {
        this(topLeft, width, height, Color.RED);
    }

    public void change(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;

        Point topLeft = getPoints()[0];
        Point[] points = new Point[4];
        points[0] = topLeft;
        points[1] = new Point(points[0].getX() + newHeight, points[0].getY());
        points[2] = new Point(points[1].getX(), points[0].getY()+ newHeight);
        points[3] = new Point(points[0].getX(), points[0].getY()+newHeight);

        setPoints(points);
        Log.change("rectangle at: " + Arrays.toString(getCenter()));
    }

    @Override
    public void show(Graphics g) {
        if (!isVisible()) return;
        setGraphics(g);
        g.setColor(getColor()); //
        Point[] vertices = getPoints();

        g.fillRect(vertices[0].getX(), vertices[0].getY(), width, height);
        g.setColor(Color.BLACK); // Устанавливаем цвет границы
        g.drawRect(vertices[0].getX(), vertices[0].getY(), width, height); // Рисуем границу
    }

    public void setWidth(int width) {
        this.width = width;
        changeSize(width, height); // Обновляем размеры
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        changeSize(width, height); // Обновляем размеры
    }
}
