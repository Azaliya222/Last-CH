package all.laba6_1_m.primitives.second;

import all.laba6_1_m.primitives.Point;
import all.laba6_1_m.primitives.TFigure;

import java.awt.*;

public class TSquare extends TFigure {
    private int side;
    private Color color;

    public TSquare(Point center, int side, Color color) {
        super(center);
        this.side = side;
        this.color = color;
        System.out.println("Square at " + String.valueOf(this.getCenter()));
    }

    public TSquare(Point center, int side) {
        this(center, side, Color.BLACK);
    }

    public TSquare(Point center) {
        this(center, 50);
    }

    public void changeSquare(int newSide) {
        this.side = newSide;
    }

    public void show(Graphics g) {
        this.setGraphics(g);
        Color lineColor = Color.BLACK;
        if (!this.isVisible()) {
            g.setColor(Color.WHITE);
            g.fillRect(this.getCenter().getX() - this.side / 2, this.getCenter().getY() - this.side / 2, this.side, this.side);
            g.setColor(Color.WHITE);
            g.drawRect(this.getCenter().getX() - this.side / 2, this.getCenter().getY() - this.side / 2, this.side, this.side);
        }

    }

    public int getSide() {
        return this.side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        this.color = null;
        System.out.println("square deleted");
    }
}

