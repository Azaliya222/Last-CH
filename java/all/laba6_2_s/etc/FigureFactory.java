package all.laba6_2_s.etc;

import all.laba6_2_s.panel.Fpanel;
import all.laba6_2_s.primitives.Point;
import all.laba6_2_s.primitives.TFigure;
import all.laba6_2_s.primitives.second.TCircle;
import all.laba6_2_s.primitives.second.TSquare;
import all.laba6_2_s.primitives.third.Ellipse;
import all.laba6_2_s.primitives.third.Rectangle;
import all.laba6_2_s.primitives.third.Rhomb;

import java.awt.*;
import java.util.Random;


public class FigureFactory {
    private final Random rand = new Random();
    private final Color[] colors;
    private final Fpanel panel;

    public FigureFactory(Fpanel panel) {
        this.colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE};
        this.panel = panel;
    }

    public TFigure[] getNewRandomFigures() {
        TFigure[] figures = new TFigure[30];

        for(int i = 0; i < figures.length; ++i) {
            int figureType = this.rand.nextInt(8);
            switch (figureType) {
                case 0:
                    figures[i] = this.createRandomCircle();
                    break;
                case 1:
                    figures[i] = this.createRandomEllipse();
                    break;
                case 2:
                    figures[i] = this.createRandomSquare();
                    break;
                case 3:
                    figures[i] = this.createRandomRectangle();
                    break;
                case 4:
                    figures[i] = this.createRandomRhombus();
            }
        }

        return figures;
    }

    public TCircle createRandomCircle() {
        Point center = new Point(this.rand.nextInt(this.panel.getWidth()), this.rand.nextInt(this.panel.getHeight()));
        int radius = this.rand.nextInt(100) + 40;
        int colorIndex = this.rand.nextInt(this.colors.length);
        return new TCircle(center, radius, this.colors[colorIndex]);
    }

    public Ellipse createRandomEllipse() {
        Point center = new Point(this.rand.nextInt(this.panel.getWidth()), this.rand.nextInt(this.panel.getHeight()));
        int smallSemiAxis = this.rand.nextInt(100);
        int largeSemiAxis = this.rand.nextInt(100);
        int colorIndex = this.rand.nextInt(this.colors.length);
        return new Ellipse(center, smallSemiAxis, largeSemiAxis, this.colors[colorIndex]);
    }

    public Rectangle createRandomRectangle() {
        Point center = new Point(this.rand.nextInt(this.panel.getWidth()), this.rand.nextInt(this.panel.getHeight()));
        int width = this.rand.nextInt(100) + 40;
        int height = this.rand.nextInt(100) + 40;
        int colorIndex = this.rand.nextInt(this.colors.length);
        return new Rectangle(center, width, height, this.colors[colorIndex]);
    }

    public TSquare createRandomSquare() {
        Point center = new Point(this.rand.nextInt(this.panel.getWidth()), this.rand.nextInt(this.panel.getHeight()));
        int side = this.rand.nextInt(100) + 40;
        int colorIndex = this.rand.nextInt(this.colors.length);
        return new TSquare(center, side, this.colors[colorIndex]);
    }


    public Rhomb createRandomRhombus() {
        Point center = new Point(this.rand.nextInt(this.panel.getWidth()), this.rand.nextInt(this.panel.getHeight()));
        int side = this.rand.nextInt(100) + 40;
        int height = this.rand.nextInt(100) + 40;
        int colorIndex = this.rand.nextInt(this.colors.length);
        return new Rhomb(center, side, height, this.colors[colorIndex]);
    }
}