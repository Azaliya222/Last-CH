package all.laba6_1_m.primitives.third;

import all.laba6_1_m.primitives.Point;
import all.laba6_1_m.primitives.second.TCircle;

import java.awt.*;

public class Ellipse extends TCircle {
    private int smallSemiAxis;

    public Ellipse(Point center, int smallSemiAxis, int largeSemiAxis, Color color) {
        super(center, largeSemiAxis);
        this.smallSemiAxis = smallSemiAxis;
        this.setColor(color);
        System.out.println("Ellipse at " + String.valueOf(this.getCenter()));
    }

    public Ellipse(Point center, int smallSemiAxis, int largeSemiAxis) {
        this(center, smallSemiAxis, largeSemiAxis, Color.BLACK);
    }

    public Ellipse(Point center) {
        this(center, 30, 60);
    }

    public void rotate() {
        int tmp = this.smallSemiAxis;
        this.smallSemiAxis = this.getRadius();
        this.setRadius(tmp);
        System.out.println("Ellipse rotated");
    }

    public void changeEllipse(int newSmallSemiAxis, int newLargeSemiAxis) {
        this.smallSemiAxis = newSmallSemiAxis;
        this.setRadius(newLargeSemiAxis);
    }

    public void show(Graphics g) {
        this.setGraphics(g);
        Color lineColor = Color.BLACK;
        if (!this.isVisible()) {
            g.setColor(Color.WHITE);
            g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.smallSemiAxis, this.getRadius() * 2, this.smallSemiAxis * 2);
            g.setColor(Color.WHITE);
            g.drawOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.smallSemiAxis, this.getRadius() * 2, this.smallSemiAxis * 2);
        } else {
            g.setColor(this.getColor());
            g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.smallSemiAxis, this.getRadius() * 2, this.smallSemiAxis * 2);
            g.setColor(this.getColor());
            g.drawOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.smallSemiAxis, this.getRadius() * 2, this.smallSemiAxis * 2);
        }

    }

    public int getSmallSemiAxis() {
        return this.smallSemiAxis;
    }

    public void setSmallSemiAxis(int smallSemiAxis) {
        this.smallSemiAxis = smallSemiAxis;
    }

    public int getLargeSemiAxis() {
        return this.getRadius();
    }

    public void setLargeSemiAxis(int largeSemiAxis) {
        this.setRadius(largeSemiAxis);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Ellipse deleted");
    }
}