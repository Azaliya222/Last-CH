package all.laba5.panel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import all.laba5.etc.JButton;


public class Cpanel extends JPanel {
    private final Fpanel figuresPanel;

    private final JComboBox<Object> figuresTypes = new JComboBox<>(new String[]{"Круг", "Элипс", "Четырехугольник", "Прямоугольник", "Ромб", "Трапеция", "All"});
    public Cpanel(Fpanel figuresPanel) {
        this.figuresPanel = figuresPanel;

        figuresTypes.addActionListener(e -> this.requestFocus());

        JButton createFigureButton = buildCreateButton();
        JButton visibleChangeButton = buildVisibleChangeButton();
        JButton moveButton = buildMoveButton();
        JButton resizeButton = buildResizeButton();
        JButton rotateEllipseButton = buildRotateEllipse();
        JButton deleteButton = buildDeleteButton();


        javax.swing.JButton moveToOnePoint = new javax.swing.JButton("Перемещение в баз.точку");
        moveToOnePoint.addActionListener(e -> {
            figuresPanel.moveToObePoint(getFiguresTypesSelectedItem());
        });

        add(createFigureButton);
        add(figuresTypes);
        add(visibleChangeButton);
        add(moveButton);
        add(resizeButton);
        add(rotateEllipseButton);
        add(deleteButton);
        add(moveToOnePoint);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int diffX = 0, diffY = 0;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> diffY = -10;
                    case KeyEvent.VK_DOWN -> diffY = 10;
                    case KeyEvent.VK_LEFT -> diffX = -10;
                    case KeyEvent.VK_RIGHT -> diffX = 10;
                }
                figuresPanel.moveFigures(getFiguresTypesSelectedItem(), diffX, diffY);
            }
        });

    }
    private JButton buildMoveButton() {
        JButton moveButton = new JButton("Перемещать", this);
        moveButton.addActionListener(e -> {
            figuresPanel.moveFigures(figuresTypes.getSelectedItem().toString());
        });
        return moveButton;
    }
    private JButton buildVisibleChangeButton(){
        JButton visibleChangeButton = new JButton("Видимость", this);
        visibleChangeButton.addActionListener(e -> {
            figuresPanel.changeFiguresVisible(figuresTypes.getSelectedItem().toString());
        });
        return visibleChangeButton;
    }
    private JButton buildCreateButton() {
        JButton createFigureButton = new JButton("Создать", this);
        createFigureButton.addActionListener(e -> {
            figuresPanel.createFiguresList();
        });
        return createFigureButton;
    }
    private JButton buildResizeButton() {
        JButton resizeButton = new JButton("Поменять", this);

        resizeButton.addActionListener(e -> figuresPanel.resizeFigures(figuresTypes.getSelectedItem().toString()));

        return resizeButton;
    }

    private JButton buildRotateEllipse() {
        JButton rotateEllipse = new JButton("Вращать элипс", this);

        rotateEllipse.addActionListener(e -> figuresPanel.rotateEllipse());

        return rotateEllipse;
    }
    private JButton buildDeleteButton() {
        JButton deleteButton = new JButton("Удалить", this);
        deleteButton.addActionListener(e -> {
            figuresPanel.deleteFigures(figuresTypes.getSelectedItem().toString());
        });
        return deleteButton;
    }

    public String getFiguresTypesSelectedItem() {
        return figuresTypes.getSelectedItem().toString();
    }
}
