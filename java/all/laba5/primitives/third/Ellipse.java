package all.laba5.primitives.third;

import all.laba5.etc.Log;
import all.laba5.primitives.Point;
import all.laba5.primitives.second.TCircle;

import java.awt.*;
import java.util.Arrays;

public class Ellipse extends TCircle {
    private int smallSemiAxis;

    public Ellipse(Point[] points, int smallSemiAxis, int largeSemiAxis, Color color) {
        super(points, largeSemiAxis);
        this.smallSemiAxis = smallSemiAxis;
        setColor(color);

        Log.create("ellipse at " + Arrays.toString(getCenter()));
    }
    public Ellipse(Point points, int smallSemiAxis, int largeSemiAxis, Color color) {
        super(new Point[]{points}, largeSemiAxis);
        this.smallSemiAxis = smallSemiAxis;
        setColor(color);

        Log.create("ellipse at " + Arrays.toString(getCenter()));
    }

    public Ellipse(Point[] points, int smallSemiAxis, int largeSemiAxis) {
        this(points, smallSemiAxis, largeSemiAxis, Color.BLACK);
    }
    public Ellipse(Point[] points) {
        this(points, 30, 60);
    }
    public void change(int newSmallSemiAxis, int newLargeSemiAxis) {
        this.smallSemiAxis = newSmallSemiAxis;
        setRadius(newLargeSemiAxis);

        Log.change("ellipse at " + getCenter());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        Log.delete("ellipse at " + Arrays.toString(getCenter()));
    }

    public void rotate(){
        int tmp = smallSemiAxis;
        smallSemiAxis = getRadius();
        setRadius(tmp);

        Log.change("ellipse at " + Arrays.toString(getCenter()) + " rotated");
    }

    @Override
    public void show(Graphics g) {
        setGraphics(g);
        Color lineColor = Color.BLACK;
        if(!this.isVisible()){
            lineColor = Color.WHITE;
            setColor(Color.WHITE);
        }

        g.setColor(getColor());
        g.fillOval(this.getCenter()[0].getX() - getRadius(), this.getCenter()[0].getY() - smallSemiAxis, getRadius() * 2, smallSemiAxis * 2);
        g.setColor(lineColor);
        g.drawOval(this.getCenter()[0].getX() - getRadius(), this.getCenter()[0].getY() - smallSemiAxis, getRadius() * 2, smallSemiAxis * 2);
    }

    public int getSmallSemiAxis() {
        return smallSemiAxis;
    }

    public void setSmallSemiAxis(int smallSemiAxis) {
        this.smallSemiAxis = smallSemiAxis;
    }

    public int getLargeSemiAxis() {
        return getRadius();
    }

    public void setLargeSemiAxis(int largeSemiAxis) {
        setRadius(largeSemiAxis);
    }
}