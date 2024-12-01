package all.laba3.primitives.second;

import all.laba3.primitives.TFigure;
import all.laba3.primitives.Point;
import all.laba3.etc.Log;

import java.awt.*;

public class TCircle extends TFigure {
    private int radius;

    private Color color;

    public TCircle(Point center, int radius, Color color) {
        super(center);
        this.radius = radius;
        this.color = color;

        Log.create("circle at " + getCenter());
    }
    public TCircle(Point center, int radius) {
        this(center, radius, Color.BLACK);
    }
    public TCircle(Point center) {
        this(center, 40);
    }

    public void changeRadius(int newRadius) {
        this.radius = newRadius;

        Log.change("circle at: " + getCenter());
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
        g.fillOval(this.getCenter().getX() - radius, this.getCenter().getY() - radius, this.radius * 2, this.radius * 2);

        g.setColor(lineColor);
        g.drawOval(this.getCenter().getX() - radius, this.getCenter().getY() - radius, this.radius * 2, this.radius * 2);
    }
    @Override
    public void moveTo(int dX, int dY) {
        getCenter().moveTo(dX,dY);
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



