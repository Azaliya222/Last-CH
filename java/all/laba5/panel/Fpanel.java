package all.laba5.panel;

import all.laba5.etc.FigureFactory;
import all.laba5.main;
import all.laba5.primitives.TFigure;
import all.laba5.primitives.second.TCircle;
import all.laba5.primitives.second.TQuadrangle;
import all.laba5.primitives.third.Ellipse;
import all.laba5.primitives.third.Rectangle;
import all.laba5.primitives.third.Rhomb;
import all.laba5.primitives.third.Trapezoid;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


public class Fpanel extends JPanel {

    private final FigureFactory figureFactory;
    private final Random rand = new Random();

    private TFigure[] figures;

    public Fpanel() {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.green));

        this.figureFactory = new FigureFactory(this);
    }

    public void createFiguresList(){
        figures = figureFactory.getNewRandomFigures();
        repaint();
    }
    public void changeFiguresVisible(String c){
        Arrays.stream(figures).filter(Objects::nonNull).filter(e -> checking(c, e)).forEach(figure -> figure.setVisible(!figure.isVisible()));
        repaint();
    }
    public void moveFigures(String c){
        Arrays.stream(figures).filter(Objects::nonNull).filter(e -> checking(c, e)).forEach(figure ->
                figure.moveTo(rand.nextInt(100) - 50, rand.nextInt(100) - 50)
        );
        repaint();
    }
    public void moveToObePoint(String c){
        Point newPoint = new Point(rand.nextInt(main.FRAME_WIDTH) - 50, rand.nextInt(100) - 50);
        Arrays.stream(figures).filter(Objects::nonNull).filter(e -> checking(c, e)).forEach(f -> f.setCenter(new Point[]{newPoint}));
        repaint();
    }
    public void resizeFigures(String c){
        Arrays.stream(figures).filter(Objects::nonNull).filter(e -> checking(c, e)).forEach(e -> {
            switch (c){
                case "Круг" -> ((TCircle) e).changeRadius(rand.nextInt(100) + 20);
                case "Элипс" -> ((Ellipse) e).change(rand.nextInt(100) + 20, rand.nextInt(100) + 20);
                case "Четырехугольник" -> ((TQuadrangle) e).changeSize(rand.nextInt(100) + 20, rand.nextInt(100) + 20);
                case "Прямоугольник" -> ((Rectangle) e).change(rand.nextInt(100) + 20,rand.nextInt(100) + 20);
                case "Ромб" -> ((Rhomb) e).change(rand.nextInt(100) + 20, rand.nextInt(100) + 20);
                case "Трапеция" -> ((Trapezoid) e).change(rand.nextInt(100)+20, rand.nextInt(100)+20);
                case "All" -> {
                    if(e instanceof Ellipse){
                        ((Ellipse) e).change(rand.nextInt(100) + 20, rand.nextInt(100) + 20);
                    }else if(e instanceof TCircle){
                        ((TCircle) e).changeRadius(rand.nextInt(100) + 20);
                    }else if(e instanceof Rectangle){
                        ((Rectangle) e).change(rand.nextInt(100) + 20, rand.nextInt(100) + 20);
                    }else if(e instanceof TQuadrangle){
                        ((TQuadrangle) e).changeSize(rand.nextInt(100) + 20, rand.nextInt(100) + 20);
                    }else if(e instanceof Rhomb){
                        ((Rhomb) e).change(rand.nextInt(100) + 20, rand.nextInt(100) + 20);
                    }else if(e instanceof Trapezoid){
                        ((Trapezoid) e).change(rand.nextInt(100)+20, rand.nextInt(100)+20);
                    }
                }
            }
        });
        repaint();
    }
    public void rotateEllipse(){
        Arrays.stream(figures).filter(Objects::nonNull).filter(e -> e instanceof Ellipse).forEach(figure -> ((Ellipse) figure).rotate());
        repaint();
    }
    public void deleteFigures(String c){
        int i = 0;
        while(i < figures.length){
            if(checking(c, figures[i])){
                figures[i].erase();
                figures[i] = null;
            }
            i++;
        }
        repaint();
    }
    public void moveFigures(String c, int diffX, int diffY){
        Arrays.stream(figures).filter(e -> checking(c,e)).forEach(figure -> {
            if(figure != null){
                figure.moveTo(diffX, diffY);
            }
        });
        repaint();
    }
    private boolean checking(String c, TFigure e){
        switch (c){
            case "Четырехугольник" -> {
                return e instanceof TQuadrangle;
            }
            case "Прямоугольник" -> {
                return e instanceof Rectangle;
            }
            case "Ромб" -> {
                return e instanceof Rhomb;
            }
            case "Трапеция" -> {
                return e instanceof Trapezoid;
            }
            case "Круг" -> {
                return e instanceof TCircle;
            }
            case "Элипс" -> {
                return e instanceof Ellipse;
            }
            case "All" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(figures != null) {
            Arrays.stream(figures).filter(Objects::nonNull).forEach(figure -> figure.show(g));
        }
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


