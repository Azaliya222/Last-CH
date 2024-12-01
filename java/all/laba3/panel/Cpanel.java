package all.laba3.panel;

import javax.swing.*;
import java.util.Objects;

public class Cpanel extends JPanel {
    JButton rotateEllipse;
    public Cpanel(Fpanel fpanel) {

        JComboBox<String> groupOrSingle = new JComboBox<>(new String[]{"Один", "Несколько"});
        JComboBox<String> figureType = new JComboBox<>(new String[]{"Круг", "Элипс", "Четырехугольник", "Прямоугольник","Ромб","Трапеция"});
        figureType.addActionListener(e -> {
            if(figureType.getSelectedItem().equals("Элипс")) {
                rotateEllipse.setVisible(true);
            }else{
                rotateEllipse.setVisible(false);
            }
        });

        JButton moveButton = buildMoveButton(fpanel, groupOrSingle, figureType);
        JButton createFigureButton = buildCreateButton(fpanel, groupOrSingle, figureType);
        JButton changeFigure = buildChangeFigureButton(fpanel, groupOrSingle, figureType);
        JButton deleteFigure = new JButton("Удалить");
        deleteFigure.addActionListener(e -> fpanel.clearFrame());


        rotateEllipse = new JButton("Вращать элипс");
        rotateEllipse.addActionListener(e -> {
            switch (groupOrSingle.getSelectedItem().toString()){
                case "Один" -> fpanel.rotateEllipse();
                case "Несколько" -> fpanel.rotateEllipseArray();
            }
        });
        rotateEllipse.setVisible(false);


        add(figureType);
        add(groupOrSingle);
        add(moveButton);
        add(createFigureButton);
        add(changeFigure);
        add(deleteFigure);
        add(rotateEllipse);
    }
    private JButton buildCreateButton(Fpanel figuresPanel, JComboBox<String> groupOrSingle, JComboBox<String> figureType) {
        JButton createFigureButton = new JButton("Создать");
        createFigureButton.addActionListener(e -> {
            switch (Objects.requireNonNull(groupOrSingle.getSelectedItem()).toString()) {
                case "Один" -> figuresPanel.addOneFigure(figureType.getSelectedItem().toString());
                case "Несколько" -> figuresPanel.addFiguresArray(figureType.getSelectedItem().toString());
            }


        });
        return createFigureButton;
    }

    private JButton buildMoveButton(Fpanel figuresPanel, JComboBox<String> groupOrSingle, JComboBox<String> figureType){
        JButton moveFigureButton = new JButton("Двигать");
        moveFigureButton.addActionListener(e -> {
            switch (Objects.requireNonNull(groupOrSingle.getSelectedItem()).toString()) {
                case "Один" -> figuresPanel.moveOneFigure(figureType.getSelectedItem().toString());
                case "Несколько" -> figuresPanel.moveFiguresArray(figureType.getSelectedItem().toString());
            }


        });
        return moveFigureButton;
    }

    private JButton buildChangeFigureButton(Fpanel figuresPanel, JComboBox<String> groupOrSingle, JComboBox<String> figureType){
        JButton changeFigureButton = new JButton("Поменять");
        changeFigureButton.addActionListener(e -> {
            switch (Objects.requireNonNull(groupOrSingle.getSelectedItem()).toString()) {
                case "Один" -> figuresPanel.changeOneFigure(figureType.getSelectedItem().toString());
                case "Несколько" -> figuresPanel.changeFiguresArray(figureType.getSelectedItem().toString());
            }
        });
        return changeFigureButton;
    }
}
