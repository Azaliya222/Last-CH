package all.laba1.primitives;

import java.awt.*;

public class Line {
    private int X1;
    private int Y1;
    private int X2;
    private int Y2;
    private int size;
    private int newLength;

    private Color color;
    private boolean visible = true;

    public Line(int X1, int Y1, int X2, int Y2, Color color) {
        this.X1 = X1;
        this.Y1 = Y2;
        this.X2 = X2;
        this.Y2 = Y2;
        this.color = color;


        System.out.println("Line created from (" + X1 + ", " + Y1 + ") to (" + X2 + ", " + Y2 + ")");
    }
    public Line(int size) {
        this.size = size;

    }
    public Line() {
        this.newLength = 10;

    }

    public void erase() {
        visible = false;

        System.out.println("Line erased");
    }

    public void moveTo(int diffX1, int diffY1, int diffX2, int diffY2) {
        X1 += diffX1;
        Y1 += diffY1;
        X2 += diffX2;
        Y2 += diffY2;
        System.out.println("Line moved to (" + X1 + ", " + Y1 + ") to (" + X2 + ", " + Y2 + ")");
    }

    public void changeColor(Color newColor) {
        this.color = newColor;
        System.out.println("Line color changed to " + newColor);
    }

    public void show(Graphics graphics) {
        if (visible) {
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.setColor(color);
            //graphics.setColor(color);
            g2d.setStroke(new BasicStroke(3)); // Здесь 3 - это толщина линии

            g2d.drawLine(X1, Y1, X2, Y2);
        } else {
            System.out.println("Segment is not visible");
        }
    }
    public void changeForm(int diffSize) {
        // Вычисляем длину отрезка
        double currentLength = Math.sqrt(Math.pow(X2 - X1, 2) + Math.pow(Y2 - Y1, 2));

        // Вычисляем новые координаты конечной точки
        double newLength = currentLength + diffSize;
        double angle = Math.atan2(Y2 - Y1, X2 - X1);

        // Вычисляем новые координаты конечной точки
        X2 = X1 + (int) (newLength * Math.cos(angle));
        Y2 = Y1 + (int) (newLength * Math.sin(angle));

        System.out.println("Segment changed to new length: " + newLength +
                ", new end point: (" + X2 + ", " + Y2 + ")");
    }

    // Геттеры для координат
    public int X1() {
        return X1;
    }

    public int Y1() {
        return Y2;
    }

    public int X2() {
        return X2;
    }

    public int Y2() {
        return Y2;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Line finalized");
    }


}

