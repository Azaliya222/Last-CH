package all.laba3.primitives;

import java.awt.*;
import all.laba3.etc.Log;

public abstract class TFigure {
    private Point center;
    private boolean visible = true;
    private Graphics graphics;

    public TFigure(Point center) {
        this.center = center;

        Log.create("figure at " + center);
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void moveTo(int diffX, int diffY) {
        this.center.setX(this.center.getX() + diffX);
        this.center.setY(this.center.getY() + diffY);

        Log.move("moved to " + this.center);
    }
    public void erase() {
        this.visible = false;

        Log.erase("figure at " + center);
    }

    public abstract void show(Graphics g);
    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    protected void finalize() throws Throwable {
        this.center = null;
        System.gc();

        Log.delete("figure at " + center);
    }

}