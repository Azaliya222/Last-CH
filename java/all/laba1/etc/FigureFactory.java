package all.laba1.etc;

import all.laba1.primitives.Ellipse;
import all.laba1.primitives.Rectangle;
import all.laba1.primitives.Line;


import java.awt.*;
import java.util.Random;


public class FigureFactory {
    private Random rand = new Random();
    private Color[] colors = new Color[]{Color.PINK, Color.LIGHT_GRAY, Color.BLUE};

    private final int COUNT_OF_FIGURES_IN_GROUP = 10;

    private final int frameWidth;
    private final int frameHeight;

    public FigureFactory(int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }


    public Ellipse createRandomEllipse() {
        int smallSemiAxis = rand.nextInt(100) + 20;
        int largeSemiAxis = rand.nextInt(100) + 20;
        int centerX = rand.nextInt(frameWidth);
        int centerY = rand.nextInt(frameHeight);

        int colorIndex = rand.nextInt(3);

        return new Ellipse(centerX, centerY, smallSemiAxis, largeSemiAxis, colors[colorIndex]);
    }

    public Rectangle createRandomRectangle() {
        int width = rand.nextInt(100) + 20;
        int high = rand.nextInt(100) + 20;
        int centerX = rand.nextInt(frameWidth);
        int centerY = rand.nextInt(frameHeight);

        int colorIndex = rand.nextInt(3);

        return new Rectangle(centerX, centerY, width, high, colors[colorIndex]);
    }

    public Line createRandomLine() {

        int X1 = rand.nextInt(frameWidth) + 100;
        int Y1 = rand.nextInt(frameHeight) + 100;
        int X2 = rand.nextInt(frameHeight) + 100;
        int Y2 = rand.nextInt(frameHeight) + 100;


        int colorIndex = rand.nextInt(3);

        return new Line(X1,Y1,X2,Y2,colors[colorIndex]);
    }

    public Ellipse[] createRandomEllipseList() {
        Ellipse[] ellipses = new Ellipse[COUNT_OF_FIGURES_IN_GROUP];
        for (int i = 0; i < ellipses.length; i++) {
            ellipses[i] = createRandomEllipse();
        }
        return ellipses;
    }

    public Rectangle[] createRandomRectangularList() {
        Rectangle[] rectangles = new Rectangle[COUNT_OF_FIGURES_IN_GROUP];
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = createRandomRectangle();
        }
        return rectangles;
    }

    public Line[] createRandomLineList() {
        Line[] lines = new Line[COUNT_OF_FIGURES_IN_GROUP];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = createRandomLine();
        }
        return lines;
    }
}

