package all.laba1.panel;

import javax.swing.*;
import java.util.Objects;

public class Cpanel extends JPanel {
    public Cpanel (Fpanel fpanel) {

        JComboBox<String> groupOrSingle = new JComboBox<>(new String[]{"Один", "Несколько"});
        JComboBox<String> figureType = new JComboBox<>(new String[]{"Окружность", "Прямоугольник", "Отрезок"});
        JButton moveButton = buildMoveButton(fpanel, groupOrSingle, figureType);
        JButton createFigureButton = buildCreateButton(fpanel, groupOrSingle, figureType);

        JButton changeFigure = buildChangeFigureButton(fpanel, groupOrSingle, figureType);

        JButton deleteFigure = new JButton("Удалить");
        deleteFigure.addActionListener(e -> fpanel.clearFrame());

        add(figureType);
        add(groupOrSingle);
        add(moveButton);
        add(createFigureButton);
        add(changeFigure);
        add(deleteFigure);
    }
    private JButton buildCreateButton(Fpanel fpanel, JComboBox<String> groupOrSingle, JComboBox<String> figureType) {
            JButton createFigureButton = new JButton("Создать");
            createFigureButton.addActionListener(e -> {
                switch (Objects.requireNonNull(groupOrSingle.getSelectedItem()).toString()) {
                    case "Один" -> {
                        switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()){
                            case "Окружность" -> fpanel.addOneEllipse();
                            case "Прямоугольник" -> fpanel.addOneRectangular();
                            case "Отрезок" -> fpanel.addOneLine();
                        }
                    }
                    case "Несколько" -> {
                        switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()){
                            case "Окружность" -> fpanel.addEllipseList();
                            case "Прямоугольник" -> fpanel.addRectangularList();
                            case "Отрезок" -> fpanel.addLineList();
                        }
                    }
                }


            });
            return createFigureButton;
        }

private JButton buildMoveButton(Fpanel fpanel, JComboBox<String> groupOrSingle, JComboBox<String> figureType){
    JButton moveFigureButton = new JButton("Двигать");
    moveFigureButton.addActionListener(e -> {
        switch (Objects.requireNonNull(groupOrSingle.getSelectedItem()).toString()) {
            case "Один" -> {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()){
                    case "Окружность" -> fpanel.moveEllipse();
                    case "Прямоугольник" -> fpanel.moveRectangular();
                    case "Отрезок" -> fpanel.moveLine();
                }
            }
            case "Несколько" -> {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()){
                    case "Окружность" -> fpanel.moveEllipseList();
                    case "Прямоугольник" -> fpanel.moveRectangularList();
                    case "Отрезок" -> fpanel.moveLineList();
                }
            }
        }


    });
    return moveFigureButton;
}

private JButton buildChangeFigureButton(Fpanel fpanel, JComboBox<String> groupOrSingle, JComboBox<String> figureType) {
    JButton changeFigureButton = new JButton("Поменять");
    changeFigureButton.addActionListener(e -> {
        switch (Objects.requireNonNull(groupOrSingle.getSelectedItem()).toString()) {
            case "Один" -> {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()) {
                    case "Окружность" -> fpanel.changeEllipse();
                    case "Прямоугольник" -> fpanel.changeRectangular();
                    case "Отрезок" -> fpanel.changeLine();
                }
            }
            case "Несколько" -> {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()) {
                    case "Окружность" -> fpanel.changeEllipseList();
                    case "Прямоугольник" -> fpanel.changeRectangularList();
                    case "Отрезок" -> fpanel.changeLineList();
                }
            }
        }
    });
    return changeFigureButton;
}
}

