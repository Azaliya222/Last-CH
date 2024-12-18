package all.laba1.primitives;

import java.awt.*;

public class Rectangle {
    private int centerX;
    private int centerY;

    private int width;
    private int high;

    private Color color;
    private boolean visible = true;

    public Rectangle(int centerX, int centerY, int width, int high, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.high = high;
        this.color = color;

        System.out.println("Rectangle created at " + centerX + ", " + centerY);
    }

    public Rectangle(int centerX, int centerY, Color color) {
        this.color = color;
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = 30;
        this.high = 10;

        System.out.println("Rectangle created at " + centerX + ", " + centerY);
    }
    public Rectangle(){
        this.centerX = 0;
        this.centerY = 0;
        this.width = 10;
        this.high = 34;

        System.out.println("Rectangle created at " + centerX + ", " + centerY);
    }

    public void erase(){
        visible = false;

        System.out.println("Rectangle erased");
    }
    public void moveTo(int diffX, int diffY){
        centerX += diffX;
        centerY += diffY;

        System.out.println("Rectangle moved at " + centerX + ", " + centerY);
    }
    public void changeForm(int newSmallSemiAxis, int newLargeSemiAxis){
        this.width = newSmallSemiAxis;
        this.high = newLargeSemiAxis;

        System.out.println("Rectangle changed width: " + width + ", high: " + high);
    }

    public void show(Graphics graphics){
        Color lineColor = Color.BLACK;
        if(!visible){
            lineColor = Color.WHITE;
            color = Color.WHITE;
        }



        graphics.setColor(color);
        graphics.fillRect(centerX - width / 2, centerY - high / 2, width, high);

        graphics.setColor(lineColor);
        graphics.drawRect(centerX - width / 2, centerY - high / 2, width, high);


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
        System.out.println("Rectangle finalized");
    }
}

