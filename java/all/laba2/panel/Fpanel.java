package all.laba2.panel;

import all.laba2.etc.FigureFactory;
import all.laba2.nwmod.RecRing;
import all.laba2.primitives.Ellipse;
import all.laba2.primitives.Line;
import all.laba2.primitives.Rectangle;
import all.laba2.nwmod.Ring;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Fpanel extends JPanel {
    private Ellipse ellipse;
    private Rectangle rectangle;
    private Line line;
    private Ring ring;
    private RecRing recring;

    private Ellipse[] ellipseList;
    private Rectangle[] rectangleList;
    private Line[] lineList;
    private Ring[] ringList;
    private RecRing[] recringList;

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
    public void addOneRing(){
        if(ring != null) {
            ring.erase();
            repaint();
            ring = null;
            System.gc();
        }
        ring = figureFactory.createRing();
        repaint();
    }
    public void addOneRecRing(){
        if(recring != null) {
            recring.erase();
            repaint();
            recring = null;
            System.gc();
        }
        recring = figureFactory.createRecRing();
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
    public void addRingList(){
        if(ringList != null) {
            Arrays.stream(ringList).forEach(Ring::erase);
            repaint();
            ringList = null;
            System.gc();
        }
        ringList = figureFactory.createRandomRingList();
        repaint();
    }
    public void addRecRingList(){
        if(recringList != null) {
            Arrays.stream(recringList).forEach(RecRing::erase);
            repaint();
            recringList = null;
            System.gc();
        }
        recringList = figureFactory.createRandomRecRingList();
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
            int diffX = rand.nextInt(101) - 50;
            int diffY = rand.nextInt(101) - 50;
            line.moveTo(diffX,diffY);
        }
        repaint();
    }
    public void moveRing() {
        if (ring != null) {
            int diffX = rand.nextInt(101) - 50;
            int diffY = rand.nextInt(101) - 50;
            ring.moveTo(diffX, diffY);
        }
        repaint();
    }
    public void moveRecRing() {
        if (recring != null) {
            int diffX = rand.nextInt(101) - 50;
            int diffY = rand.nextInt(101) - 50;
            recring.moveTo(diffX, diffY);
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
                int diffX = rand.nextInt(101) - 50;
                int diffY = rand.nextInt(101) - 40;
                e.moveTo(diffX, diffY);
            });
        }
        repaint();

    }
    public void moveRingList() {
        if (ringList != null) {
            Arrays.stream(ringList).forEach(e -> {
                int diffX = rand.nextInt(101) - 50;
                int diffY = rand.nextInt(101) - 50;
                e.moveTo(diffX, diffY);
            });
        }
        repaint();
    }
    public void moveRecRingList() {
        if (recringList != null) {
            Arrays.stream(recringList).forEach(e -> {
                int diffX = rand.nextInt(101) - 50;
                int diffY = rand.nextInt(101) - 50;
                e.moveTo(diffX, diffY);
            });
        }
        repaint();
    }

    public void changeEllipse() {
        if (ellipse != null) {
            int diffSmallSemiAxi = rand.nextInt(101) - 50;
            int diffLargeSemiAxi = rand.nextInt(101) - 50;
            ellipse.changeForm(diffSmallSemiAxi, diffLargeSemiAxi);
        }
        repaint();

    }
    public void changeRectangular() {
        if (rectangle != null) {
            int diffWidth = rand.nextInt(101) - 50;
            int diffHeight = rand.nextInt(101) - 50;
            rectangle.changeForm(diffWidth, diffHeight);
        }
        repaint();

    }
    public void changeLine() {
        if (line != null) {
            int newLength = rand.nextInt(101) - 50; // Генерируем новую длину отрезка
            line.changeForm(newLength);
        }
        repaint();
    }
    public void changeRing(){
        if (ring != null) {
            int newSmallSemiAxi = rand.nextInt(101) - 50;
            int newLargeSemiAxi = rand.nextInt(101) - 50;
            ring.changeForm(newSmallSemiAxi, newLargeSemiAxi);
        }
        repaint();
    }
    public void changeRecRing(){
        if (recring != null) {
            int newWidth = rand.nextInt(101) - 50;
            int newHeight = rand.nextInt(101) - 50;
            recring.changeForm(newWidth, newHeight);
        }
        repaint();
    }
    public void changeEllipseList() {
        if (ellipseList != null) {
            Arrays.stream(ellipseList).forEach(e -> {
                int diffSmallSemiAxi = rand.nextInt(101) - 50;
                int diffLargeSemiAxi = rand.nextInt(101) - 50;
                e.changeForm(diffSmallSemiAxi, diffLargeSemiAxi);
            });
        }
        repaint();

    }
    public void changeRectangularList() {
        if (rectangleList != null) {
            Arrays.stream(rectangleList).forEach(e -> {
                int diffWidth = rand.nextInt(101) - 50;
                int diffHeight = rand.nextInt(101) - 50;
                e.changeForm(diffWidth, diffHeight);
            });
        }
        repaint();
    }
    public void changeLineList() {
        if(lineList != null) {
            Arrays.stream(lineList).forEach(e -> {
                int newLength = rand.nextInt(101) - 50;
                e.changeForm(newLength);
            });
        }
        repaint();
    }
    public void changeRingList() {
        if (ringList != null) {
            Arrays.stream(ringList).forEach(e -> {
                int newSmallSemiAxi = rand.nextInt(101) - 50;
                int newLargeSemiAxi = rand.nextInt(101) - 50;
                e.changeForm(newSmallSemiAxi, newLargeSemiAxi);
            });
        }
        repaint();
    }
    public void changeRecRingList() {
        if (recringList != null) {
            Arrays.stream(recringList).forEach(e -> {
                int newWidth = rand.nextInt(101) - 50;
                int newHeight = rand.nextInt(101) - 50;
                e.changeForm(newWidth, newHeight);
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
        if(ring != null) {
            ring.erase();
            repaint();
            ring = null;
        }
        if(recring != null) {
            recring.erase();
            repaint();
            recring = null;
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
        if(ringList != null) {
            Arrays.stream(ringList).forEach(Ring::erase);
            repaint();
            Arrays.fill(ringList, null);
            ringList = null;
        }
        if(recringList != null) {
            Arrays.stream(recringList).forEach(RecRing::erase);
            repaint();
            Arrays.fill(recringList, null);
            recringList = null;
        }
        System.gc();

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if(ellipse != null) ellipse.show(g);
        if(rectangle != null) rectangle.show(g);
        if(line != null) line.show(g);
        if(ring != null) ring.show(g);
        if(recring != null) recring.show(g);

        if(ellipseList != null) Arrays.stream(ellipseList).forEach(ellipse -> ellipse.show(g));
        if(rectangleList != null) Arrays.stream(rectangleList).forEach(rectangle -> rectangle.show(g));
        if(lineList != null) Arrays.stream(lineList).forEach(line -> line.show(g));
        if(ringList != null) Arrays.stream(ringList).forEach(ring -> ring.show(g));
        if(recringList!= null) Arrays.stream(recringList).forEach(recring->recring.show(g));

    }
}


