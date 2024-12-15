package all.laba6_2_s.primitives.second;

import all.laba6_2_s.primitives.Point;
import all.laba6_2_s.primitives.TFigure;

import java.awt.*;

public class TCircle extends TFigure {
    private int radius;
    private Color color;

    public TCircle(Point center, int radius, Color color) {
        super(center);
        this.radius = radius;
        this.color = color;
        System.out.println("Circle at " + String.valueOf(this.getCenter()));
    }

    public TCircle(Point center, int radius) {
        this(center, radius, Color.BLACK);
    }

    public TCircle(Point center) {
        this(center, 40);
    }

    public void changeRadius(int newRadius) {
        this.radius = newRadius;
    }

    public void show(Graphics g) {
        this.setGraphics(g);
        Color lineColor = Color.BLACK;
        if (!this.isVisible()) {
            g.setColor(Color.WHITE);
            g.fillOval(this.getCenter().getX() - this.radius, this.getCenter().getY() - this.radius, this.radius * 2, this.radius * 2);
            g.setColor(Color.WHITE);
            g.drawOval(this.getCenter().getX() - this.radius, this.getCenter().getY() - this.radius, this.radius * 2, this.radius * 2);
        } else {
            g.setColor(this.color);
            g.fillOval(this.getCenter().getX() - this.radius, this.getCenter().getY() - this.radius, this.radius * 2, this.radius * 2);
            g.setColor(lineColor);
            g.drawOval(this.getCenter().getX() - this.radius, this.getCenter().getY() - this.radius, this.radius * 2, this.radius * 2);
        }

    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.gc();
        System.out.println("Circle deleted");
    }
}



