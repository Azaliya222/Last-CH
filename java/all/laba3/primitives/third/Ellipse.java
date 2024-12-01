package all.laba3.primitives.third;

import all.laba3.primitives.Point;
import all.laba3.primitives.second.TCircle;
import all.laba3.etc.Log;

import java.awt.*;

public class Ellipse extends TCircle {
    private int smallSemiAxis;

    public Ellipse(Point center, int smallSemiAxis, int largeSemiAxis, Color color) {
        super(center, largeSemiAxis);
        this.smallSemiAxis = smallSemiAxis;
        setColor(color);

        Log.create("ellipse at " + getCenter());
    }

    public Ellipse(Point center, int smallSemiAxis, int largeSemiAxis) {
        this(center, smallSemiAxis, largeSemiAxis, Color.BLACK);
    }
    public Ellipse(Point center) {
        this(center, 30, 60);
    }
    public void change(int newSmallSemiAxis, int newLargeSemiAxis) {
        this.smallSemiAxis = newSmallSemiAxis;
        setRadius(newLargeSemiAxis);

        Log.change("ellipse at " + getCenter());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        System.out.println("[DEL]\t\tellipse");
    }

    public void rotate(){
        int tmp = smallSemiAxis;
        smallSemiAxis = getRadius();
        setRadius(tmp);

        Log.change("ellipse at " + getCenter() + " rotated");
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
        g.fillOval(this.getCenter().getX() - getRadius(), this.getCenter().getY() - smallSemiAxis, getRadius() * 2, smallSemiAxis * 2);
        g.setColor(lineColor);
        g.drawOval(this.getCenter().getX() - getRadius(), this.getCenter().getY() - smallSemiAxis, getRadius() * 2, smallSemiAxis * 2);
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