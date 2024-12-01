package all.laba4.primitives.third;

import all.laba4.etc.Log;
import all.laba4.primitives.Point;
import all.laba4.primitives.second.TQuadrangle;

import java.awt.*;

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

        Point[] vertices = getPoints();
        vertices[1].moveTo(vertices[0].getX() + newWidth, vertices[0].getY()); // Верхний правый угол
        vertices[2].moveTo(vertices[1].getX(), vertices[1].getY() + newHeight); // Нижний правый угол
        vertices[3].moveTo(vertices[0].getX(), vertices[0].getY() + newHeight); // Нижний левый угол

        setPoints(vertices);
        Log.change("rectangle at: " + getCenter());
    }

    @Override
    public void show(Graphics g) {
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
