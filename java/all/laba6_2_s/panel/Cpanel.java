package all.laba6_2_s.panel;

import all.laba6_2_s.etc.JButton;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Cpanel extends JPanel {
    private final Fpanel figuresPanel;
    private final JComboBox<Object> figuresTypes = new JComboBox(new String[]{"Круг", "Эллипс", "Ромб", "Квадрат", "Прямоугольник", "Все"});

    public Cpanel(final Fpanel figuresPanel) {
        this.figuresPanel = figuresPanel;
        this.figuresTypes.addActionListener((e) -> this.requestFocus());
        JButton createFigureButton = this.buildCreateButton();
        JButton visibleChangeButton = this.buildVisibleChangeButton();
        JButton moveButton = this.buildMoveButton();
        JButton resizeButton = this.buildResizeButton();
        JButton rotateEllipseButton = this.buildRotateEllipse();
        JButton deleteButton = this.buildDeleteButton();
        javax.swing.JButton moveToOnePoint = new javax.swing.JButton("В одну точку");
        moveToOnePoint.addActionListener((e) -> figuresPanel.moveToObePoint(this.getFiguresTypesSelectedItem()));
        this.add(createFigureButton);
        this.add(this.figuresTypes);
        this.add(visibleChangeButton);
        this.add(moveButton);
        this.add(resizeButton);
        this.add(rotateEllipseButton);
        this.add(deleteButton);
        this.add(moveToOnePoint);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int diffX = 0;
                int diffY = 0;
                switch (e.getKeyCode()) {
                    case 37 -> diffX = -10;
                    case 38 -> diffY = -10;
                    case 39 -> diffX = 10;
                    case 40 -> diffY = 10;
                }

                figuresPanel.moveFigures(Cpanel.this.getFiguresTypesSelectedItem(), diffX, diffY);
            }
        });
    }

    private JButton buildMoveButton() {
        JButton moveButton = new JButton("Перемещать", this);
        moveButton.addActionListener((e) -> this.figuresPanel.moveFigures(this.figuresTypes.getSelectedItem().toString()));
        return moveButton;
    }

    private JButton buildVisibleChangeButton() {
        JButton visibleChangeButton = new JButton("Видимость", this);
        visibleChangeButton.addActionListener((e) -> this.figuresPanel.changeFiguresVisible(this.figuresTypes.getSelectedItem().toString()));
        return visibleChangeButton;
    }

    private JButton buildCreateButton() {
        JButton createFigureButton = new JButton("Создать", this);
        createFigureButton.addActionListener((e) -> this.figuresPanel.createFiguresList());
        return createFigureButton;
    }

    private JButton buildResizeButton() {
        JButton resizeButton = new JButton("Поменять", this);
        resizeButton.addActionListener((e) -> this.figuresPanel.resizeFigures(this.figuresTypes.getSelectedItem().toString()));
        return resizeButton;
    }

    private JButton buildRotateEllipse() {
        JButton rotateEllipse = new JButton("Вращать эллипс", this);
        rotateEllipse.addActionListener((e) -> this.figuresPanel.rotateEllipse());
        return rotateEllipse;
    }

    private JButton buildDeleteButton() {
        JButton deleteButton = new JButton("Удалить", this);
        deleteButton.addActionListener((e) -> this.figuresPanel.deleteFigures(this.figuresTypes.getSelectedItem().toString()));
        return deleteButton;
    }

    public String getFiguresTypesSelectedItem() {
        return this.figuresTypes.getSelectedItem().toString();
    }
}
