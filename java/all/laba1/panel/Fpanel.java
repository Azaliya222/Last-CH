package all.laba1.panel;

import all.laba1.etc.FigureFactory;
import all.laba1.primitives.Ellipse;
import all.laba1.primitives.Line;
import all.laba1.primitives.Rectangle;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Arrays;
import java.util.Random;

public class Fpanel extends JPanel {
    private Ellipse ellipse;
    private Rectangle rectangle;
    private Line line;

    private Ellipse[] ellipseList;
    private Rectangle[] rectangleList;
    private Line[] lineList;

    private FigureFactory figureFactory;

    private final Random rand = new Random();

    public Fpanel(int frameWidth, int frameHeight) {
        figureFactory = new FigureFactory(frameWidth, frameHeight);
        setBorder(BorderFactory.createLineBorder(Color.green));
    }
    public void addOneEllipse() {
        if(ellipse != null) {
            ellipse.erase();
            repaint();
            ellipse = null;
            System.gc();
        }
        ellipse = figureFactory.createRandomEllipse();
        repaint();

    }
    public void addOneRectangular() {
        if(rectangle != null) {
            rectangle.erase();
            repaint();
            rectangle = null;
            System.gc();
        }
        rectangle = figureFactory.createRandomRectangle();
        repaint();

    }
    public void addOneLine() {
        if(line != null) {
            line.erase();
            repaint();
            line = null;
            System.gc();
        }
        line = figureFactory.createRandomLine();
        repaint();

    }
    public void addEllipseList(){
        if(ellipseList != null) {
            Arrays.stream(ellipseList).forEach(Ellipse::erase);
            repaint();
            ellipseList = null;
            System.gc();
        }
        ellipseList = figureFactory.createRandomEllipseList();
        repaint();

    }
    public void addRectangularList(){
        if(rectangleList != null) {
            Arrays.stream(rectangleList).forEach(Rectangle::erase);
            repaint();
            rectangleList = null;
            System.gc();
        }
        rectangleList = figureFactory.createRandomRectangularList();
        repaint();

    }
    public void addLineList(){
        if(lineList != null) {
            Arrays.stream(lineList).forEach(Line::erase);
            repaint();
            lineList = null;
            System.gc();
        }
        lineList = figureFactory.createRandomLineList();
        repaint();

    }
    public void moveEllipse() {
        if (ellipse != null) {
            int diffX = rand.nextInt(101) - 50;
            int diffY = rand.nextInt(101) - 50;
            ellipse.moveTo(diffX, diffY);
        }

        repaint();

    }
    public void moveRectangular() {
        if (rectangle != null) {
            int diffX = rand.nextInt(101) - 50;
            int diffY = rand.nextInt(101) - 50;
            rectangle.moveTo(diffX, diffY);
        }
        repaint();

    }
    public void moveLine() {
        if (line != null) {
            int diffX1 = rand.nextInt(101) - 50;
            int diffY1 = rand.nextInt(101) - 50;
            int diffX2 = rand.nextInt(101) - 50;
            int diffY2= rand.nextInt(101) - 50;
            line.moveTo(diffX1, diffY1, diffX2,diffY2);
        }
        repaint();
    }
    public void moveEllipseList() {
        if (ellipseList != null) {
            Arrays.stream(ellipseList).forEach(e -> {
                int diffX = rand.nextInt(101) - 50;
                int diffY = rand.nextInt(101) - 50;
                e.moveTo(diffX, diffY);
            });
        }
        repaint();

    }
    public void moveRectangularList() {
        if (rectangleList != null) {
            Arrays.stream(rectangleList).forEach(e -> {
                int diffX = rand.nextInt(101) - 50;
                int diffY = rand.nextInt(101) - 50;
                e.moveTo(diffX, diffY);
            });
        }
        repaint();

    }
    public void moveLineList() {
        if(lineList != null) {
            Arrays.stream(lineList).forEach(e -> {
                int diffX1 = rand.nextInt(101) - 50;
                int diffY1 = rand.nextInt(101) - 50;
                int diffX2 = rand.nextInt(101) - 40;
                int diffY2 = rand.nextInt(101) - 40;
                e.moveTo(diffX1, diffY1, diffX2, diffY2);
            });
        }
        repaint();

    }

    public void changeEllipse() {
        if (ellipse != null) {
            int diffSmallSemiAxi = rand.nextInt(101) + 50;
            int diffLargeSemiAxi = rand.nextInt(101) + 50;
            ellipse.changeForm(diffSmallSemiAxi, diffLargeSemiAxi);
        }
        repaint();

    }
    public void changeRectangular() {
        if (rectangle != null) {
            int diffWidth = rand.nextInt(101) + 50;
            int diffHeight = rand.nextInt(101) + 50;
            rectangle.changeForm(diffWidth, diffHeight);
        }
        repaint();

    }
    public void changeLine() {
        if (line != null) {
            int newLength = rand.nextInt(101) + 50; // Генерируем новую длину отрезка
            line.changeForm(newLength);
        }
        repaint();
    }
    public void changeEllipseList() {
        if (ellipseList != null) {
            Arrays.stream(ellipseList).forEach(e -> {
                int diffSmallSemiAxi = rand.nextInt(101) + 50;
                int diffLargeSemiAxi = rand.nextInt(101) + 50;
                e.changeForm(diffSmallSemiAxi, diffLargeSemiAxi);
            });
        }
        repaint();

    }
    public void changeRectangularList() {
        if (rectangleList != null) {
            Arrays.stream(rectangleList).forEach(e -> {
                int diffWidth = rand.nextInt(101) + 50;
                int diffHeight = rand.nextInt(101) + 50;
                e.changeForm(diffWidth, diffHeight);
            });
        }
        repaint();
    }
    public void changeLineList() {
        if(lineList != null) {
            Arrays.stream(lineList).forEach(e -> {
                int newLength = rand.nextInt(101) + 50;
                e.changeForm(newLength);
            });
        }
        repaint();
    }

    public void clearFrame(){
        if(ellipse != null) {
            ellipse.erase();
            repaint();
            ellipse = null;
        }
        if(rectangle != null) {
            rectangle.erase();
            repaint();
            rectangle = null;
        }
        if(line != null) {
            line.erase();
            repaint();
            line = null;
        }

        if(ellipseList != null) {
            Arrays.stream(ellipseList).forEach(Ellipse::erase);
            repaint();
            Arrays.fill(ellipseList, null);
            ellipseList = null;
        }
        if(rectangleList != null) {
            Arrays.stream(rectangleList).forEach(Rectangle::erase);
            repaint();
            Arrays.fill(rectangleList, null);
            rectangleList = null;
        }
        if(lineList != null) {
            Arrays.stream(lineList).forEach(Line::erase);
            repaint();
            Arrays.fill(lineList, null);
            lineList = null;
        }
        System.gc();

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if(ellipse != null) ellipse.show(g);
        if(rectangle != null) rectangle.show(g);
        if(line != null) line.show(g);


        if(ellipseList != null) Arrays.stream(ellipseList).forEach(ellipse -> ellipse.show(g));
        if(rectangleList != null) Arrays.stream(rectangleList).forEach(rectangle -> rectangle.show(g));
        if(lineList != null) Arrays.stream(lineList).forEach(line -> line.show(g));

    }
}


