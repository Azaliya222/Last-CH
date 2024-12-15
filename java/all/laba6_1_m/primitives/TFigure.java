package all.laba6_1_m.primitives;

import java.awt.*;

public abstract class TFigure {
    private Point center;
    private boolean visible = true;
    private Graphics graphics;

    public TFigure(Point center) {
        this.center = center;

        System.out.println("figure at " + center + " created");
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public final void moveTo(int diffX, int diffY) {
        this.center.setX(this.center.getX() + diffX);
        this.center.setY(this.center.getY() + diffY);
        show(graphics);

        System.out.println("figure at " + center + " moved to " + this.center);
    }

    public void erase(){
        this.visible = false;

        System.out.println("figure at " + center + " erased");
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

        System.out.println("figure at " + center + " deleted");
    }

}

