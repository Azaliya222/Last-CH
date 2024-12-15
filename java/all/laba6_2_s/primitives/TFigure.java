package all.laba6_2_s.primitives;

import java.awt.*;

public abstract class TFigure {
    private Point center;
    private boolean visible = true;
    private Graphics graphics;

    public TFigure(Point center) {
        this.center = center;
        System.out.println("Figure created");
    }

    public Graphics getGraphics() {
        return this.graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public final void moveTo(int diffX, int diffY) {
        this.center.setX(this.center.getX() + diffX);
        this.center.setY(this.center.getY() + diffY);
        this.show(this.graphics);
        System.out.println("Figure moved to " + String.valueOf(this));
    }

    public void erase() {
        this.visible = false;
        System.out.println("Figure erased");
    }

    public abstract void show(Graphics var1);

    public Point getCenter() {
        return this.center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    protected void finalize() throws Throwable {
        this.center = null;
        System.gc();
        System.out.println("Figure deleted");
    }
}

