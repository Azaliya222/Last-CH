package all.laba4.etc;

import all.laba4.main;
import all.laba4.primitives.Point;
import all.laba4.primitives.second.TCircle;
import all.laba4.primitives.second.TQuadrangle;
import all.laba4.primitives.third.Ellipse;
import all.laba4.primitives.third.Rectangle;
import all.laba4.primitives.third.Rhomb;
import all.laba4.primitives.third.Trapezoid;

import java.awt.*;
import java.util.Random;


public class FigureFactory {
    private Random rand = new Random();
    private Color[] colors = new Color[]{Color.MAGENTA, Color.GREEN, Color.yellow};

    private final int COUNT_OF_FIGURES_IN_GROUP = 10;


    public TCircle createRandomCircle(){
        Point [] points = new Point[0];
        int radius = rand.nextInt(100) + 40;
        int colorIndex = rand.nextInt(colors.length);

        return new TCircle(points, radius, colors[colorIndex]);
    }
    public Ellipse createRandomEllipse(){
        Point [] points = new Point[1];
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


    public TCircle[] createCircleArray(){
        TCircle[] circles = new TCircle[COUNT_OF_FIGURES_IN_GROUP];
        for(int i = 0; i < COUNT_OF_FIGURES_IN_GROUP; i++){
            circles[i] = createRandomCircle();
        }
        return circles;
    }

    public Rhomb[] createRhombArray() {
        Rhomb[] rhombs = new Rhomb[COUNT_OF_FIGURES_IN_GROUP];
        for(int i = 0; i < COUNT_OF_FIGURES_IN_GROUP; i++){
            rhombs[i] = createRandomRhomb();
        }
        return rhombs;
    }
    public Ellipse[] createEllipseArray(){
        Ellipse[] ellipses = new Ellipse[COUNT_OF_FIGURES_IN_GROUP];
        for(int i = 0; i < COUNT_OF_FIGURES_IN_GROUP; i++){
            ellipses[i] = createRandomEllipse();
        }
        return ellipses;
    }
    public Rectangle[] createRectangleArray(){
        Rectangle[] rectangles = new Rectangle[COUNT_OF_FIGURES_IN_GROUP];
        for(int i = 0; i < COUNT_OF_FIGURES_IN_GROUP; i++){
            rectangles[i] = createRandomRectangle();
        }
        return rectangles;
    }
    public TQuadrangle[] createQuadrangleArray() {
        TQuadrangle[] quadrangles = new TQuadrangle[COUNT_OF_FIGURES_IN_GROUP];
        for (int i = 0; i < COUNT_OF_FIGURES_IN_GROUP; i++) {
            quadrangles[i] = createRandomQuadrangle();
        }
        return quadrangles;
    }
    public Trapezoid[] createRandomTrapezoidArray() {
        Trapezoid[] trapezoids = new Trapezoid[COUNT_OF_FIGURES_IN_GROUP];
        for (int i = 0; i < trapezoids.length; i++) trapezoids[i] = createRandomTrapezoid();
        return trapezoids;
    }
}