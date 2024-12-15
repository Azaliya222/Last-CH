package all.laba6_1_m.panel;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
        public MyFrame() {
            this.setSize(new Dimension(1000, 900));
            JPanel panel = new MainPanel(this);
            this.setVisible(true);
            this.add(panel);
            this.setDefaultCloseOperation(3);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
            this.setResizable(false);
            this.setVisible(true);
        }
    }

