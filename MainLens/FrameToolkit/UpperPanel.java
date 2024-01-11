package MainLens.FrameToolkit;


import javax.swing.*;
import java.awt.*;

public class UpperPanel extends JPanel {
    public static final Dimension size = new Dimension(Frame.d.width, Frame.d.height/4);
    public UpperPanel(){
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0xBEB5B5));
    }
}
