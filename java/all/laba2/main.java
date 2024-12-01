package all.laba2;
import all.laba2.panel.Cpanel;
import all.laba2.panel.Fpanel;

import javax.swing.*;
import java.awt.*;

public class main extends JFrame {
    public final static int FRAME_WIDTH = 600;
    public final static int FRAME_HIGH = 600;

    public main(){
        setTitle("Графические примитивы");
        setSize(FRAME_WIDTH, FRAME_HIGH);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Fpanel fpanel = new Fpanel(FRAME_WIDTH, FRAME_HIGH);
        Cpanel cpanel = new Cpanel(fpanel);

        add(fpanel, BorderLayout.CENTER);
        add(cpanel, BorderLayout.SOUTH);
    }

}
