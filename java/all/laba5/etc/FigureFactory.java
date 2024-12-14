package all.laba5.etc;

import all.laba5.main;
import all.laba5.primitives.Point;
import all.laba5.primitives.TFigure;
import all.laba5.primitives.second.TCircle;
import all.laba5.primitives.second.TQuadrangle;
import all.laba5.primitives.third.Ellipse;
import all.laba5.primitives.third.Rectangle;
import all.laba5.primitives.third.Rhomb;
import all.laba5.primitives.third.Trapezoid;
import all.laba5.panel.Fpanel;

import java.awt.*;
import java.util.Random;


public class FigureFactory {
    private final Random rand = new Random();
    private final Color[] colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE};

    private final Fpanel panel;

    public FigureFactory(Fpanel panel) {
        this.panel = panel;
    }

    public TFigure[] getNewRandomFigures() {

        TFigure[] figures = new TFigure[30];

        for (int i = 0; i < figures.length; i++) {
            int figureType = rand.nextInt(6);
            switch (figureType) {
                case 0 -> figures[i] = createRandomCircle();
                case 1 -> figures[i] = createRandomEllipse();
                case 2 -> figures[i] = createRandomRectangle();
                case 3 -> figures[i] = createRandomRhomb();
                case 4 -> figures[i] = createRandomQuadrangle();
                case 5 -> figures[i] = createRandomTrapezoid();
            }
        }

        return figures;
    }
    public TCircle createRandomCircle(){
        Point point = new Point(
                rand.nextInt(main.FRAME_WIDTH),
                rand.nextInt(main.FRAME_HIGH)
        );
        int radius = rand.nextInt(100) + 40;
        int colorIndex = rand.nextInt(colors.length);

        return new TCircle(point, radius, colors[colorIndex]);
    }
    public Ellipse createRandomEllipse(){
        Point points = new Point(
                rand.nextInt(main.FRAME_WIDTH),
                rand.nextInt(main.FRAME_HIGH)
        );
        int smallSemiAxis = rand.nextInt(100);
        int largeSemiAxis = rand.nextInt(100);
        int colorIndex = rand.nextInt(colors.length);

        return new Ellipse(points, smallSemiAxis, largeSemiAxis, colors[colorIndex]);
    }
    public Rectangle createRandomRectangle(){
        Point center = new Point(
                rand.nextInt(main.FRAME_WIDTH),
                rand.nextInt(main.FRAME_HIGH)
        );
        int width = rand.nextInt(100) + 40;
        int height = rand.nextInt(100) + 40;
        int colorIndex = rand.nextInt(colors.length);
        return new Rectangle(center, width, height, colors[colorIndex]);
    }
    public Rhomb createRandomRhomb() {
        Point center = new Point(
                rand.nextInt(main.FRAME_WIDTH),
                rand.nextInt(main.FRAME_HIGH)
        );
        int diagonal1 = rand.nextInt(100) + 40;
        int diagonal2 = rand.nextInt(100) + 40;
        int colorIndex = rand.nextInt(colors.length);
        return new Rhomb(center, diagonal1, diagonal2, colors[colorIndex]);
    }

    public TQuadrangle createRandomQuadrangle(){
        Point[] vertices = new Point[4];
        for (int i = 0; i < 4; i++) {
            vertices[i] = new Point(
                    rand.nextInt(main.FRAME_WIDTH),
                    rand.nextInt(main.FRAME_HIGH)
            );
        }

        int colorIndex = rand.nextInt(colors.length);

        return new TQuadrangle(vertices, colors[colorIndex]);
    }
    public Trapezoid createRandomTrapezoid() {
        Point center = new Point(
                rand.nextInt(main.FRAME_WIDTH),
                rand.nextInt(main.FRAME_HIGH)
        );
        int topWidth = rand.nextInt(100) + 40;
        int bottomWidth = topWidth + rand.nextInt(100) + 40;
        int height = rand.nextInt(100) + 40;
        int colorIndex = rand.nextInt(colors.length);
        return new Trapezoid(center, topWidth, bottomWidth, height, colors[colorIndex]);
    }

}