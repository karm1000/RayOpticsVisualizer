package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public static final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    public Frame(){
        super();
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
