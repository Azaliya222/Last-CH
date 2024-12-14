package all.laba5.primitives;

import all.laba5.etc.Log;

import java.awt.*;
import java.util.Arrays;

public abstract class TFigure {
    private Point[] points;
    private boolean visible = true;
    private Graphics graphics;

    public TFigure(Point[] points) {
        this.points = points;

        Log.create("figure at " + Arrays.toString(points));
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public final void moveTo(int diffX, int diffY) {
       for (Point point : points) point.moveTo(diffX,diffY);
        show(graphics);

        Log.move("moved to " + Arrays.toString(this.points));
    }

    public void erase() {
        this.visible = false;

        Log.erase("figure at " + Arrays.toString(points));
    }

    public abstract void show(Graphics g);
    public Point[] getCenter() {
        return points;
    }

    //public void setCenter(Point[] points) {
        //this.points= points;
    //}
    public void setPoints(Point[] points) {
        this.points= points;
    }

    public Point[] getPoints() {
        return points;
    }
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    protected void finalize() throws Throwable {
        this.points = null;
        System.gc();

        Log.delete("figure at " + Arrays.toString(points));
    }

    @Override
    public String toString() {
        return "TFigure{" +
                "points=" + Arrays.toString(points) +
                ", visible=" + visible +
                ", graphics=" + graphics +
                '}';
    }

    public void setCenter(java.awt.Point[] points) {
    }
}