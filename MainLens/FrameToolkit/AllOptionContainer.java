package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class AllOptionContainer extends JPanel {
    public static final Dimension size = new Dimension(SecondaryPanel.size.width/4, SecondaryPanel.size.height);
    public CardLayout cl = new CardLayout();
    public AllOptionContainer(){
        this.setPreferredSize(size);
        this.setLayout(cl);
        this.setBackground(new Color(0x969696));
    }
}
