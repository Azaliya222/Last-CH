package all.laba6_2_s.panel;

import all.laba6_2_s.etc.FigureFactory;
import all.laba6_2_s.primitives.Point;
import all.laba6_2_s.primitives.TFigure;
import all.laba6_2_s.primitives.second.TCircle;
import all.laba6_2_s.primitives.second.TSquare;
import all.laba6_2_s.primitives.third.Ellipse;
import all.laba6_2_s.primitives.third.Rectangle;
import all.laba6_2_s.primitives.third.Rhomb;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Fpanel extends JPanel {

    private final FigureFactory figureFactory;
    private final Random rand = new Random();
    private TFigure[] figures;

    public Fpanel() {
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.green));
        this.figureFactory = new FigureFactory(this);
    }

    public void createFiguresList() {
        this.figures = this.figureFactory.getNewRandomFigures();
        this.repaint();
    }

    public void changeFiguresVisible(String c) {
        for(TFigure figure : this.figures) {
            if (this.checking(c, figure) && figure != null) {
                figure.setVisible(!figure.isVisible());
            }
        }

        this.repaint();
    }

    public void moveFigures(String c) {
        for(TFigure figure : this.figures) {
            if (this.checking(c, figure) && figure != null) {
                figure.moveTo(this.rand.nextInt(100) - 50, this.rand.nextInt(100) - 50);
            }
        }

        this.repaint();
    }

    public void moveToObePoint(String c) {
        Point newPoint = new Point(this.rand.nextInt(800) - 50, this.rand.nextInt(100) - 50);

        for(TFigure figure : this.figures) {
            if (this.checking(c, figure) && figure != null) {
                figure.setCenter(newPoint);
            }
        }

        this.repaint();
    }

    public void resizeFigures(String c) {
        for(TFigure e : this.figures) {
            if (this.checking(c, e)) {
                switch (c) {
                    case "Круг":
                        ((TCircle)e).changeRadius(this.rand.nextInt(100) + 20);
                        break;
                    case "Эллипс":
                        ((Ellipse)e).changeEllipse(this.rand.nextInt(100) + 20, this.rand.nextInt(100) + 20);
                        break;
                    case "Прямоугольник":
                        ((Rectangle)e).changeRectangle(this.rand.nextInt(100) + 20, this.rand.nextInt(100) + 20);
                        break;
                    case "Квадрат":
                        ((TSquare)e).changeSquare(this.rand.nextInt(100) + 20);
                        break;
                    case "Ромб":
                        ((Rhomb)e).changeRhomb(this.rand.nextInt(100) + 20, this.rand.nextInt(100) + 20);
                        break;
                    case "Все":
                        if (e instanceof Ellipse) {
                            ((Ellipse)e).changeEllipse(this.rand.nextInt(100) + 20, this.rand.nextInt(100) + 20);
                        } else if (e instanceof TCircle) {
                            ((TCircle)e).changeRadius(this.rand.nextInt(100) + 20);
                        } else if (e instanceof Rectangle) {
                            ((Rectangle)e).changeRectangle(this.rand.nextInt(100) + 20, this.rand.nextInt(100) + 20);
                        } else if (e instanceof Rhomb) {
                            ((Rhomb)e).changeRhomb(this.rand.nextInt(100) + 20, this.rand.nextInt(100) + 20);
                        } else if (e instanceof TSquare) {
                            ((TSquare)e).changeSquare(this.rand.nextInt(100) + 20);
                        }
                }
            }
        }

        this.repaint();
    }

    public void rotateEllipse() {
        for(TFigure e : this.figures) {
            if (e instanceof Ellipse) {
                ((Ellipse)e).rotate();
            }
        }

        this.repaint();
    }

    public void deleteFigures(String c) {
        for(int i = 0; i < this.figures.length; ++i) {
            if (this.checking(c, this.figures[i])) {
                this.figures[i].erase();
                this.figures[i] = null;
            }
        }

        this.repaint();
    }

    public void moveFigures(String c, int diffX, int diffY) {
        for(TFigure e : this.figures) {
            if (this.checking(c, e) && e != null) {
                e.moveTo(diffX, diffY);
            }
        }

        this.repaint();
    }

    private boolean checking(String c, TFigure e) {
        switch (c) {
            case "Квадрат" -> {
                return e instanceof TSquare;
            }
            case "Прямоугольник" -> {
                return e instanceof Rectangle;
            }

            case "Круг" -> {
                return e instanceof TCircle;
            }
            case "Эллипс" -> {
                return e instanceof Ellipse;
            }
            case "Ромб" -> {
                return e instanceof Rhomb;
            }
            case "Все" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.figures != null) {
            for(TFigure figure : this.figures) {
                if (figure != null) {
                    figure.show(g);
                }
            }
        }

    }

    public int getWidth() {
        return super.getWidth();
    }

    public int getHeight() {
        return super.getHeight();
    }
}


