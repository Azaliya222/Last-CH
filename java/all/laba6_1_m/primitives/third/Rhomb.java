package all.laba6_1_m.primitives.third;

import all.laba6_1_m.primitives.Point;
import all.laba6_1_m.primitives.second.TSquare;

import java.awt.*;

public class Rhomb extends TSquare {
    private int height;

    public Rhomb(Point center, int side, int height, Color color) {
        super(center, side, color);
        this.height = height;
        System.out.println("Rhombus created");
    }

    public void changeRhomb(int newSide, int newHeight) {
        this.setSide(newSide);
        this.height = newHeight;
        System.out.println("Rhombus changed");
    }

    public void show(Graphics g) {
        this.setGraphics(g);
        int x = this.getCenter().getX();
        int y = this.getCenter().getY();
        int width = (int)Math.sqrt((double)(this.getSide() * this.getSide()) - (double)(this.height * this.height) / (double)4.0F) * 2;
        int x1 = x - width / 2;
        int y2 = y + this.height / 2;
        int x3 = x + width / 2;
        int y4 = y - this.height / 2;
        if (this.isVisible()) {
            g.setColor(this.getColor());
            g.fillPolygon(new int[]{x1, x, x3, x}, new int[]{y, y2, y, y4}, 4);
            g.setColor(Color.BLACK);
            g.drawPolygon(new int[]{x1, x, x3, x}, new int[]{y, y2, y, y4}, 4);
        } else {
            g.setColor(Color.white);
            g.fillPolygon(new int[]{x1, x, x3, x}, new int[]{y, y2, y, y4}, 4);
            g.setColor(Color.white);
            g.drawPolygon(new int[]{x1, x, x3, x}, new int[]{y, y2, y, y4}, 4);
        }

    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Rhombus deleted");
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}