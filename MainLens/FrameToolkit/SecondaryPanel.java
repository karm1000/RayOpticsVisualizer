package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class SecondaryPanel extends JPanel {
    public final static Dimension size = new Dimension(UpperPanel.size.width,UpperPanel.size.height*5/6);

    public SecondaryPanel(){
        this.setPreferredSize(size);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0x7303FB));

    }
}
