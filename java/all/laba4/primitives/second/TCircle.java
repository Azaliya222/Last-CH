package all.laba4.primitives.second;

import all.laba4.etc.Log;
import all.laba4.primitives.Point;
import all.laba4.primitives.TFigure;

import java.awt.*;
import java.util.Arrays;

public class TCircle extends TFigure {
    private int radius;

    private Color color;

    public TCircle(Point[] points, int radius, Color color) {
        super(points);
        this.radius = radius;
        this.color = color;

        Log.create("circle at " + Arrays.toString(getCenter()));
    }
    public TCircle(Point[] points, int radius) {
        this(points, radius, Color.BLACK);
    }
    public TCircle(Point[] points) {
        this(points, 40);
    }

    public void changeRadius(int newRadius) {
        this.radius = newRadius;

        Log.change("circle at: " + Arrays.toString(getCenter()));
    }
    @Override
    public void show(Graphics g){
        setGraphics(g);
        Color lineColor = Color.BLACK;
        if(!isVisible()){
            lineColor = Color.WHITE;
            color = Color.WHITE;
        }
        g.setColor(color);
        g.fillOval(this.getCenter()[0].getX() - radius, this.getCenter()[0].getY() - radius, this.radius * 2, this.radius * 2);

        g.setColor(lineColor);
        g.drawOval(this.getCenter()[0].getX() - radius, this.getCenter()[0].getY() - radius, this.radius * 2, this.radius * 2);
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.gc();

        Log.delete("circle at " + getCenter());
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}



