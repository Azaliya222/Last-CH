package all.laba4;
import all.laba4.panel.Cpanel;
import all.laba4.panel.Fpanel;

import javax.swing.*;
import java.awt.*;

public class main extends JFrame {
    public final static int FRAME_WIDTH = 800;
    public final static int FRAME_HIGH = 600;

    public main() {
        setTitle("Drawer");
        setSize(FRAME_WIDTH + 20, FRAME_HIGH + 78);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Fpanel figuresPanel = new Fpanel();
        Cpanel controlPanel = new Cpanel(figuresPanel);

        add(figuresPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }
}