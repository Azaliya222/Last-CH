package all.laba6_1_m.panel;

import all.laba6_1_m.etc.FigureFactory;
import all.laba6_1_m.primitives.Point;
import all.laba6_1_m.primitives.TFigure;
import all.laba6_1_m.etc.ArrayList;
import all.laba6_1_m.etc.Process;


import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Fpanel extends JPanel {

    private ArrayList figures = new ArrayList();

    private final FigureFactory figureFactory;

    private final Random rand = new Random();

    public Fpanel() {
        setBackground(Color.WHITE);
        this.figureFactory = new FigureFactory(this);
        this.setPreferredSize(new Dimension(1000, 900));
//        this.setLocation((this.getWidth() - this.getWidth()) / 2, (this.getHeight() - this.getHeight()) / 2);
        this.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder(Color.white));
    }

    public void addRandomFigure() {
        figureFactory.addRandomFigure(figures);
        repaint();
    }

    public void createFiguresList() {
        figures = new ArrayList();
        repaint();
    }

    public void moveFigures(int diffX, int diffY) {
        figures.forEach(new Process() {
            public void process(TFigure figure) {
                figure.moveTo(diffX, diffY);
            }
        });
        repaint();
    }

    public void moveFigures() {
        if (figures != null) {
            figures.forEach(figure ->
                    figure.moveTo(rand.nextInt(100) - 50, rand.nextInt(100) - 50)
            );
        }
        repaint();
    }

    public void moveToObePoint() {
        Point newPoint = new Point(rand.nextInt(this.getWidth()) - 50, rand.nextInt(this.getWidth()) - 50);
        if (figures != null) {
            figures.forEach(f -> f.setCenter(newPoint));
        }
        repaint();
    }

    public void deleteFigures() {
        figures.forEach(figure -> {
            figure.setVisible(false);
            figure = null;
            System.gc();
        });
        figures = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (figures != null) {
            figures.forEach(figure -> figure.show(g));
        }
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }
}

