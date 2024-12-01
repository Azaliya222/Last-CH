package all.laba1;
import all.laba1.panel.Cpanel;
import all.laba1.panel.Fpanel;

import javax.swing.*;
import java.awt.*;

public class main extends JFrame {
    private final static int FRAME_WIDH = 600;
    private final static int FRAME_HIGH = 600;

    public main(){
        setTitle("Графические примитивы");
        setSize(FRAME_WIDH, FRAME_HIGH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Fpanel fpanel = new Fpanel(FRAME_WIDH, FRAME_HIGH);
        Cpanel cpanel = new Cpanel(fpanel);

        add(fpanel, BorderLayout.CENTER);
        add(cpanel, BorderLayout.SOUTH);
    }

}
