package all.laba5.etc;
import all.laba5.panel.Cpanel;


public class JButton extends javax.swing.JButton {
        public JButton(String text, Cpanel controlPanel) {
            super(text);
            addActionListener(e -> controlPanel.requestFocus());
        }
    }

