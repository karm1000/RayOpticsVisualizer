package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class FocalLengthPanel extends JPanel {
    public static final Dimension size = new Dimension(DetailPanel.size.width,2* DetailPanel.size.height+8);
    public FocalLengthPanel(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setSize(size);
        this.setBackground(Color.white);
    }
}
