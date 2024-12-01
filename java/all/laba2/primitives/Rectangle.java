package all.laba2.primitives;

import all.laba2.main;

import java.awt.*;

public class Rectangle {
    private Point center;
    private int width;
    private int high;

    private Color color;
    private boolean visible = true;

    public Rectangle(int centerX, int centerY, int width, int high, Color color) {
        this.center = new Point(centerX, centerY);
        this.width = width;
        this.high = high;
        this.color = color;

        checkSizeAndResize();

        System.out.println("Rectangle created at " + center);
    }

    public Rectangle(int centerX, int centerY, Color color) {
        this.color = color;
        this.center = new Point(centerX, centerY);
        this.width = 10;
        this.high = 20;

        checkSizeAndResize();

        System.out.println("Rectangle created at " + center);
    }
    public Rectangle(){
        this.center = new Point(0, 0);
        this.width = 10;
        this.high = 20;

        checkSizeAndResize();

        System.out.println("Rectangle created at " + center);
    }

    private void checkSizeAndResize() {
        if (this.center.getX() + width / 2 > main.FRAME_WIDTH) {
            width = main.FRAME_WIDTH - this.center.getX();
        }
        if (this.center.getX() - width / 2 < 0) {
            width = this.center.getX() * 2;
        }
        if (this.center.getY() + high / 2 > main.FRAME_HIGH) {
            high = main.FRAME_HIGH - this.center.getY();
        }
        if (this.center.getY() - high / 2 < 0) {
            high = this.center.getY() * 2;
        }
    }

    public void erase(){
        visible = false;

        System.out.println("Rectangle deleted");
    }
    public void moveTo(int diffX, int diffY){
        this.center.setX(this.center.getX() + diffX);
        this.center.setY(this.center.getY() + diffY);

        System.out.println("Rectangle moved at " + center);
    }
    public void changeForm(int newhigh, int newLargeSemiAxis){
        this.width = newhigh;
        this.high = newLargeSemiAxis;

        System.out.println("Rectangle changed width: " + width + ", high" + high);
    }

    public void show(Graphics graphics){
        Color lineColor = color == Color.WHITE ? Color.WHITE : Color.BLACK;
        if(!visible){
            lineColor = Color.WHITE;
            color = Color.WHITE;
        }
        graphics.setColor(color);
        graphics.fillRect(center.getX() - width / 2, this.center.getY() - high / 2, width, high);

        graphics.setColor(lineColor);
        graphics.drawRect(this.center.getX() - width / 2, this.center.getY() - high / 2, width, high);


    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Rectangle finalized");
    }

    public int getWidth() {
        return width;
    }

    public int getHigh() {
        return high;
    }
}