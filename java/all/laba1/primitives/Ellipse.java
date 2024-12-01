package all.laba1.primitives;

import java.awt.*;

public class Ellipse {
    private int centerX;
    private int centerY;

    private int smallSemiAxis;
    private int largeSemiAxis;

    private Color color;
    private boolean visible = true;

    public Ellipse(int centerX, int centerY, int smallSemiAxis, int largeSemiAxis, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.smallSemiAxis = smallSemiAxis;
        this.largeSemiAxis = largeSemiAxis;
        this.color = color;

        System.out.println("Ellipse created at " + centerX + ", " + centerY);
    }
    public Ellipse(int smallSemiAxis, int largeSemiAxis, Color color) {
        this.centerX = 0;
        this.centerY = 0;
        this.smallSemiAxis = smallSemiAxis;
        this.largeSemiAxis = largeSemiAxis;
        this.color = color;

        System.out.println("Ellipse created at " + centerX + ", " + centerY);
    }

    public void moveTo(int diffX, int diffY){
        centerX += diffX;
        centerY += diffY;

        System.out.println("Ellipse moved at " + centerX + ", " + centerY);
    }
    public void changeForm(int newSmallSemiAxis, int newLargeSemiAxis){
        this.smallSemiAxis = newSmallSemiAxis;
        this.largeSemiAxis = newLargeSemiAxis;

        System.out.println("Ellipse changed smallSemiAxis: " + smallSemiAxis + ", largeSemiAxis: " + largeSemiAxis);
    }
    public void erase(){
        visible = false;

        System.out.println("Ellipse erased");
    }

    public void show(Graphics graphics){
        Color lineColor = Color.BLACK;
        if(!visible){
            color = Color.WHITE;
            lineColor = Color.WHITE;
        }

        graphics.setColor(color);
        graphics.fillOval(centerX - largeSemiAxis, centerY - smallSemiAxis, largeSemiAxis * 2, smallSemiAxis * 2);
        graphics.setColor(lineColor);
        graphics.drawOval(centerX - largeSemiAxis, centerY - smallSemiAxis, largeSemiAxis * 2, smallSemiAxis * 2);

    }

    public int getCenterX() {
        return centerX;
    }
    public int getCenterY() {
        return centerY;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Ellipse finalized");
    }
}

