package all.laba6_2_s.etc;

import all.laba6_2_s.panel.Cpanel;


public class JButton extends javax.swing.JButton {
        public JButton(String text, Cpanel controlPanel) {
            super(text);
            addActionListener(e -> controlPanel.requestFocus());
        }
    }

