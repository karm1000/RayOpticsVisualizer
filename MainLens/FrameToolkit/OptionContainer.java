package MainLens.FrameToolkit;


import javax.swing.*;
import java.awt.*;

public class OptionContainer extends JPanel {
    public static final Dimension size = new Dimension(SecondaryPanel.size.width/4, SecondaryPanel.size.height);
   public OptionContainer(){
        this.setPreferredSize(size);
        this.setLayout(null);
        this.setBackground(new Color(0x969696));
    }
}
