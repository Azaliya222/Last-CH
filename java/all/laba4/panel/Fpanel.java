package all.laba4.panel;

import all.laba4.etc.FigureFactory;
import all.laba4.primitives.TFigure;
import all.laba4.primitives.second.TCircle;
import all.laba4.primitives.second.TQuadrangle;
import all.laba4.primitives.third.Ellipse;
import all.laba4.primitives.third.Rectangle;
import all.laba4.primitives.third.Rhomb;
import all.laba4.primitives.third.Trapezoid;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Fpanel extends JPanel {
    private final int COUNT_OF_TYPES = 7;
    private TFigure[] figure = new TFigure[COUNT_OF_TYPES];

    private TFigure[][] figures = new TFigure[COUNT_OF_TYPES][];

    private FigureFactory figureFactory;

    private final Random rand = new Random();

    public Fpanel() {
        this.figureFactory = new FigureFactory();
        setBorder(BorderFactory.createLineBorder(Color.green));
    }
    public void rotateEllipse(){
        if(figure[1] != null){
            Ellipse ellipse = (Ellipse) figure[1];
            ellipse.rotate();

            repaint();
        }
    }
    public void rotateEllipseArray() {
        if (figures[1] != null) {
            for (TFigure figure : figures[1]) {
                Ellipse ellipse = (Ellipse) figure;
                ellipse.rotate();
            }
            repaint();
        }
    }
    public void addOneFigure(String className) {
        switch (className) {
            case "Круг" -> {
                if (figure[0] != null) {
                    figure[0].erase();
                    repaint();
                    figure[0] = null;
                    System.gc();
                }
                figure[0] = figureFactory.createRandomCircle();
            }
            case "Элипс" -> {
                if (figure[1] != null) {
                    figure[1].erase();
                    repaint();
                    figure[1] = null;
                    System.gc();
                }
                figure[1] = figureFactory.createRandomEllipse();
            }
            case "Четырехугольник" -> {
                if (figure[2] != null) {
                    figure[2].erase();
                    repaint();
                    figure[2] = null;
                    System.gc();
                }
                figure[2] = figureFactory.createRandomQuadrangle();
            }
            case "Прямоугольник" -> {
                if (figure[3] != null) {
                    figure[3].erase();
                    repaint();
                    figure[3] = null;
                    System.gc();
                }
                figure[3] = figureFactory.createRandomRectangle();
            }
            case "Ромб" -> {
                if (figure[4] != null) {
                    figure[4].erase();
                    repaint();
                    figure[4] = null;
                    System.gc();
                }
                figure[4] = figureFactory.createRandomRhomb();
            }
            case "Трапеция" -> {
                if (figure[5] != null) {
                    figure[5].erase();
                    repaint();
                    figure[5] = null;
                    System.gc();
                }
                figure[5] = figureFactory.createRandomTrapezoid();
            }

        }
        repaint();
    }
    public void addFiguresArray(String className) {
        switch (className) {
            case "Круг" -> {
                if (figures[0] != null) {
                    Arrays.stream(figures[0]).forEach(figure -> {
                        if (figure == null) {
                            return;
                        }
                        figure.erase();
                        repaint();
                        figure = null;
                        System.gc();
                    });
                }
                figures[0] = figureFactory.createCircleArray();
            }
            case "Элипс" -> {
                if (figures[1] != null) {
                    Arrays.stream(figures[1]).forEach(figure -> {
                        if (figure == null) {
                            return;
                        }
                        figure.erase();
                        repaint();
                        figure = null;
                        System.gc();
                    });
                }
                figures[1] = figureFactory.createEllipseArray();
            }
            case "Четырехугольник" -> {
                if (figures[2] != null) {
                    Arrays.stream(figures[2]).forEach(figure -> {
                        if (figure == null) {
                            return;
                        }
                        figure.erase();
                        repaint();
                        figure = null;
                        System.gc();
                    });
                }
                figures[2] = figureFactory.createQuadrangleArray();
            }
            case "Прямоугольник" -> {
                if (figures[3] != null) {
                    Arrays.stream(figures[3]).forEach(figure -> {
                        if (figure == null) {
                            return;
                        }
                        figure.erase();
                        repaint();
                        figure = null;
                        System.gc();
                    });
                }
                figures[3] = figureFactory.createRectangleArray();
            }
            case "Ромб" -> {
                if (figures[4] != null) {
                    Arrays.stream(figures[4]).forEach(figure -> {
                        if (figure == null) {
                            return;
                        }
                        figure.erase();
                        repaint();
                        figure = null;
                        System.gc();
                    });
                }
                figures[4] = figureFactory.createRhombArray();
            }
            case "Трапеция" -> {
                if (figures[5] != null) {
                    Arrays.stream(figures[5]).forEach(figure -> {
                        if (figure == null) {
                            return;
                        }
                        figure.erase();
                        repaint();
                        figure = null;
                        System.gc();
                    });
                }
                figures[5] = figureFactory.createRandomTrapezoidArray();
            }
        }
        repaint();
    }
    public void moveOneFigure(String className) {
        int figureTypeIndex;
        switch (className) {
            case "Круг" -> figureTypeIndex = 0;
            case "Элипс" -> figureTypeIndex = 1;
            case "Четырехугольник" -> figureTypeIndex = 2;
            case "Прямоугольник" -> figureTypeIndex = 3;
            case "Ромб" -> figureTypeIndex = 4;
            case "Трапеция" -> figureTypeIndex = 5;
            default -> figureTypeIndex = 0;
        }
        if (figure[figureTypeIndex] != null) {
            figure[figureTypeIndex].moveTo(
                    rand.nextInt(100) - 50,
                    rand.nextInt(100) - 50
            );
        }
        repaint();
    }
    public void moveFiguresArray(String className) {
        int figureTypeIndex;
        switch (className) {
            case "Круг" -> figureTypeIndex = 0;
            case "Элипс" -> figureTypeIndex = 1;
            case "Четырехугольник" -> figureTypeIndex = 2;
            case "Прямоугольник" -> figureTypeIndex = 3;
            case "Ромб" -> figureTypeIndex = 4;
            case "Трапеция" -> figureTypeIndex = 5;

            default -> figureTypeIndex = 0;
        }
        if (figures[figureTypeIndex] != null) {
            Arrays.stream(figures[figureTypeIndex]).forEach(figure -> {
                if (figure != null) {
                    figure.moveTo(
                            rand.nextInt(100) - 50,
                            rand.nextInt(100) - 50
                    );
                }
            });
        }
        repaint();
    }
    public void changeOneFigure(String className) {
        switch (className) {
            case "Круг" -> {
                if (figure[0] != null) {
                    TCircle circle = (TCircle) figure[0];
                    circle.changeRadius(rand.nextInt(100));
                }
            }
            case "Элипс" -> {
                if (figure[1] != null) {
                    Ellipse ellipse = (Ellipse) figure[1];
                    ellipse.change(rand.nextInt(100), rand.nextInt(100));
                }
            }
            case "Четырехугольник" -> {
                if (figure[2] != null) {
                    TQuadrangle quadrangle = (TQuadrangle) figure[2];
                    // Предположим, что у вас есть метод changeSize для изменения размера
                    quadrangle.changeSize(
                            rand.nextInt(100) + 40,  // Изменение по X
                            rand.nextInt(100) + 40   // Изменение по Y
                    );
                }
            }
            case "Прямоугольник" -> {
                if (figure[3] != null) {
                    Rectangle rectangle = (Rectangle) figure[3];
                    rectangle.change(
                            rand.nextInt(100) + 40,
                            rand.nextInt(100) + 40
                    );
                }
            }
            case "Ромб" -> {
                if (figure[4] != null) {
                    Rhomb rhomb = (Rhomb) figure[4];
                        rhomb.change(
                            rand.nextInt(100) + 40,
                            rand.nextInt(100) + 40
                    );
                }
            }
            case "Трапеция" -> {
                if (figure[5] != null) {
                    Trapezoid trapezoid = (Trapezoid) figure[5];
                    trapezoid.change(
                            rand.nextInt(100) + 40,
                            rand.nextInt(100) + 40
                    );
                }
            }

        }

            repaint();
        }

    public void changeFiguresArray(String className) {
        switch (className) {
            case "Круг" -> {
                if (figures[0] != null) {
                    Arrays.stream(figures[0]).forEach(figure -> {
                        TCircle circle = (TCircle) figure;
                        if (figure == null) {
                            return;
                        }
                        circle.changeRadius(rand.nextInt(100));
                    });
                }
            }
            case "Элипс" -> {
                if (figures[1] != null) {
                    Arrays.stream(figures[1]).forEach(figure -> {
                        Ellipse ellipse = (Ellipse) figure;
                        if (figure == null) {
                            return;
                        }
                        ellipse.change(rand.nextInt(100), rand.nextInt(100));
                    });
                }
            }
            case "Четырехугольник" -> {
                if (figures[2] != null) {
                    Arrays.stream(figures[2]).forEach(figure -> {
                        TQuadrangle quadrangle = (TQuadrangle) figure;
                        if (figure == null) {
                            return;
                        }
                        quadrangle.changeSize(
                                rand.nextInt(100) + 40,  // Изменение по X
                                rand.nextInt(100) + 40
                        );// Изменение по Y
                    });
                }
            }
            case "Прямоугольник" -> {
                if (figures[3] != null) {
                    Arrays.stream(figures[3]).forEach(figure -> {
                        Rectangle rectangle = (Rectangle) figure;
                        if (figure == null) {
                            return;
                        }
                        rectangle.change(
                                rand.nextInt(100) + 40,
                                rand.nextInt(100) + 40
                        );
                    });
                }
            }
            case "Ромб" -> {
                if (figures[4] != null) {
                    Arrays.stream(figures[4]).forEach(figure -> {
                        Rhomb rhomb= (Rhomb) figure;
                        if (figure == null) {
                            return;
                        }
                        rhomb.change(
                                rand.nextInt(100) + 40,
                                rand.nextInt(100) + 40
                        );
                    });
                }
            }
            case "Трапеция" -> {
                if (figures[5] != null) {
                    Arrays.stream(figures[5]).forEach(figure -> {
                        Trapezoid trapezoid = (Trapezoid) figure;
                        if (figure == null) {
                            return;
                        }
                        trapezoid.change(
                                rand.nextInt(100) + 40,
                                rand.nextInt(100) + 40
                        );
                    });
                }
            }

        }
        repaint();
    }
    public void clearFrame() {
        if(figure != null) {
            for (int i = 0; i < figure.length; i++) {
                if (figure[i] != null) {
                    figure[i].erase();
                    repaint();
                    figure[i] = null;
                    System.gc();
                }
            }
        }
        if(figures != null) {
            for (int i = 0; i < figures.length; i++) {
                if (figures[i] != null) {
                    for (int j = 0; j < figures[i].length; j++) {
                        try {
                            figures[i][j].erase();
                            repaint();
                            figures[i][j] = null;
                            System.gc();
                        }catch (Exception e){}
                    }
                }
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Arrays.stream(figure).forEach(f -> {
            if (f != null) f.show(g);
        });

        Arrays.stream(figures).forEach(f -> {
            if (f != null) {
                Arrays.stream(f).forEach(e -> {
                    if (e != null) e.show(g);
                });
            }
        });
    }

}


