package all.laba6_1_m.panel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
        public MainPanel(JFrame window) {
            this.setPreferredSize(window.getSize());
            Fpanel panel = new Fpanel();
            JPanel buttonsPanel = new ButtonPanel(panel);
            this.add(panel);
            this.add(buttonsPanel, BorderLayout.SOUTH);
            this.setVisible(true);
            setBackground(Color.WHITE);
        }
    }

