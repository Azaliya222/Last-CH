package all.laba2.nwmod;
import all.laba2.primitives.Ellipse;
import all.laba2.primitives.Point;

import java.awt.*;


public class Ring {
    private Ellipse in;
    private Ellipse out;

    private int thickness;

    public Ring(int centerX, int centerY, int largeSemiAxis, int smallSemiAxis, int thickness, Color color){
        all.laba2.primitives.Point center = new Point(centerX, centerY);
        this.out = new Ellipse(center, smallSemiAxis, largeSemiAxis, color);
        this.in = new Ellipse(center, this.out.getSmallSemiAxis() - thickness, this.out.getLargeSemiAxis() - thickness, Color.WHITE);
        this.thickness  = thickness;

        System.out.println("Ring created at " + center);
    }

    public Ring(int centerX, int centerY, int largeSemiAxis, int smallSemiAxis, int thickness){
        all.laba2.primitives.Point center = new Point(centerX, centerY);
        this.out = new Ellipse(center, smallSemiAxis, largeSemiAxis, Color.PINK);
        this.in = new Ellipse(center, this.out.getSmallSemiAxis() - thickness, this.out.getLargeSemiAxis() - thickness, Color.WHITE);
        this.thickness = thickness;

        System.out.println("Ring created at " + center);
    }

    public void moveTo(int diffX, int diffY) {
        this.in.moveTo(diffX, diffY);
        this.out.moveTo(diffX, diffY);

        System.out.println("Ring moved at " + this.in);
    }

    public void changeForm(int newSmallSemiAxis, int newLargeSemiAxis) {
        this.in.changeForm(newSmallSemiAxis - thickness, newLargeSemiAxis - thickness);
        this.out.changeForm(newSmallSemiAxis, newLargeSemiAxis);

        System.out.println("Ellipse changed smallSemiAxis: " + this.out.getSmallSemiAxis() + ", largeSemiAxis" + this.out.getLargeSemiAxis());
    }

    public void erase() {
        this.out.erase();
        this.in.erase();

        System.out.println("Ring deleted");
    }

    public void show(Graphics graphics) {
        this.out.show(graphics);
        this.in.show(graphics);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.in = null;
        this.out = null;
        System.out.println("Ring finalized");
    }
}




