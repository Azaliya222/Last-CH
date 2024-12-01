package all.laba2.primitives;
import all.laba2.main;

import java.awt.*;
import java.util.Scanner;

public class Ellipse {
    private Point center;

    private int smallSemiAxis;
    private int largeSemiAxis;

    private Color color;
    private boolean visible = true;

    public Ellipse(int centerX, int centerY, int smallSemiAxis, int largeSemiAxis, Color color) {
        this.center = new Point(centerX, centerY);
        this.smallSemiAxis = smallSemiAxis;
        this.largeSemiAxis = largeSemiAxis;
        this.color = color;

        checkSizeAndResize();

        System.out.println("Ellipse created");

    }

    public Ellipse(Point center, int smallSemiAxis, int largeSemiAxis, Color color) {
        this.center = center;
        this.smallSemiAxis = smallSemiAxis;
        this.largeSemiAxis = largeSemiAxis;
        this.color = color;

        checkSizeAndResize();

        System.out.println("Ellipse created at " + center + " " + this.smallSemiAxis + " " + this.largeSemiAxis);
    }

    private void checkSizeAndResize() {
        if (this.center.getX() + largeSemiAxis > main.FRAME_WIDTH) {
            largeSemiAxis = main.FRAME_WIDTH - this.center.getX();
        }
        if (this.center.getX() - largeSemiAxis < 0) {
            largeSemiAxis = this.center.getX();
        }
        if (this.center.getY() + smallSemiAxis > main.FRAME_HIGH) {
            smallSemiAxis = main.FRAME_HIGH - this.center.getY();
        }
        if (this.center.getY() - smallSemiAxis < 0) {
            smallSemiAxis = this.center.getY();
        }
    }

    public void moveTo(int diffX, int diffY) {
        this.center.setX(this.center.getX() + diffX);
        this.center.setY(this.center.getY() + diffY);

        System.out.println("Ellipse moved at " + center);
    }

    public void changeForm(int newSmallSemiAxis, int newLargeSemiAxis) {
        this.smallSemiAxis = newSmallSemiAxis;
        this.largeSemiAxis = newLargeSemiAxis;

        System.out.println("Ellipse changed smallSemiAxis: " + smallSemiAxis + ", largeSemiAxis" + largeSemiAxis);
    }

    public void erase() {
        visible = false;

        System.out.println("Ellipse deleted");
    }

    public void show(Graphics graphics) {
        Color lineColor = Color.BLACK;
        if (!visible) {
            color = Color.WHITE;
            lineColor = Color.WHITE;
        }

        graphics.setColor(color);
        graphics.fillOval(center.getX() - largeSemiAxis, center.getY() - smallSemiAxis, largeSemiAxis * 2, smallSemiAxis * 2);
        graphics.setColor(lineColor);
        graphics.drawOval(center.getX() - largeSemiAxis, center.getY() - smallSemiAxis, largeSemiAxis * 2, smallSemiAxis * 2);

    }

    public int getSmallSemiAxis() {
        return smallSemiAxis;
    }

    public void setSmallSemiAxis(int smallSemiAxis) {
        this.smallSemiAxis = smallSemiAxis;
    }

    public int getLargeSemiAxis() {
        return largeSemiAxis;
    }

    public void setLargeSemiAxis(int largeSemiAxis) {
        this.largeSemiAxis = largeSemiAxis;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Ellipse finalized");
    }
}

