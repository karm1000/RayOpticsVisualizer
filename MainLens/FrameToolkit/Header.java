package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    public static Dimension size = new Dimension(UpperPanel.size.width,UpperPanel.size.height/6);

    public Header(){
        this.setPreferredSize(size);
        this.setLayout(null);
        this.setBackground(new Color(0x14C0FF));
    }
    public Header(Dimension d){
        size = d;
        this.setPreferredSize(size);
        this.setLayout(null);
        this.setBackground(new Color(0x14C0FF));
    }
}
