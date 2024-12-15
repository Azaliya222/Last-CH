package all.laba6_1_m.panel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ButtonPanel extends JPanel {
    private final Fpanel figuresPanel;

    public ButtonPanel(Fpanel figuresPanel) {
        this.figuresPanel = figuresPanel;


        JButton createFigureButton = buildCreateButton();
        JButton moveButton = buildMoveButton();
        JButton deleteButton = buildDeleteButton();
        JButton addFigureButton = new JButton("Добавить", this);
        addFigureButton.addActionListener(e -> {
            figuresPanel.addRandomFigure();
        });


        JButton moveToOnePoint = new JButton("К одной точке", this);
        moveToOnePoint.addActionListener(e -> {
            figuresPanel.moveToObePoint();
        });

        add(createFigureButton);
        add(addFigureButton);

        add(moveButton);
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
                figuresPanel.moveFigures(diffX, diffY);
            }
        });

    }

    private JButton buildMoveButton() {
        JButton moveButton = new JButton("Move", this);
        moveButton.addActionListener(e -> {
            figuresPanel.moveFigures();
        });
        return moveButton;
    }

    private JButton buildCreateButton() {
        JButton createFigureButton = new JButton("Создать", this);
        createFigureButton.addActionListener(e -> {
            figuresPanel.createFiguresList();
        });
        return createFigureButton;
    }

    private JButton buildDeleteButton() {
        JButton deleteButton = new JButton("Удалить", this);
        deleteButton.addActionListener(e -> {
            figuresPanel.deleteFigures();
        });
        return deleteButton;
    }

    static class JButton extends javax.swing.JButton {
        public JButton(String text, ButtonPanel controlPanel) {
            super(text);
            addActionListener(e -> controlPanel.requestFocus());
        }

    }
}