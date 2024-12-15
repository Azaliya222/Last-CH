package all.laba6_2_s.primitives.third;

import all.laba6_2_s.primitives.Point;
import all.laba6_2_s.primitives.second.TSquare;

import java.awt.*;

public class Rectangle extends TSquare {
    private int width;

    public Rectangle(Point center, int width, int height, Color color) {
        super(center, height);
        this.width = width;
        this.setColor(color);
        System.out.println("Rectangle at " + String.valueOf(this.getCenter()));
    }

    public Rectangle(Point center, int width, int height) {
        this(center, width, height, Color.BLACK);
    }

    public Rectangle(Point center) {
        this(center, 80, 40, Color.BLACK);
    }

    public void changeRectangle(int newHeight, int newWidth) {
        this.setSide(newHeight);
        this.setWidth(newWidth);
    }

    public void show(Graphics g) {
        this.setGraphics(g);
        Color lineColor = Color.BLACK;
        if (!this.isVisible()) {
            g.setColor(Color.WHITE);
            g.fillRect(this.getCenter().getX() - this.width / 2, this.getCenter().getY() - this.getSide() / 2, this.width, this.getSide());
            g.setColor(Color.WHITE);
            g.drawRect(this.getCenter().getX() - this.width / 2, this.getCenter().getY() - this.getSide() / 2, this.width, this.getSide());
        } else {
            g.setColor(this.getColor());
            g.fillRect(this.getCenter().getX() - this.width / 2, this.getCenter().getY() - this.getSide() / 2, this.width, this.getSide());
            g.setColor(lineColor);
            g.drawRect(this.getCenter().getX() - this.width / 2, this.getCenter().getY() - this.getSide() / 2, this.width, this.getSide());
        }

    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.getSide();
    }

    public void setHeight(int height) {
        this.setSide(height);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Rectangle deleted");
    }
}