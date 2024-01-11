package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class ObjHeightSlider extends JSlider {
    static int width = 125;
    public static final Dimension size = new Dimension(width,
                                                    CenterPanel.size.height-ObjDistanceSlider.size.height);
    public ObjHeightSlider(){
        this.setSize(size);
        this.setOrientation(JSlider.VERTICAL);
        this.setPaintTicks(true);
        this.setMinorTickSpacing(5);
        this.setPaintTrack(true);
        this.setMajorTickSpacing(10);
        this.setPaintLabels(true);
        this.setBackground(Color.white);
        this.setOpaque(false);
        this.setFont(new Font("Sarif",Font.BOLD,14));
        this.setLocation(0,0);
    }

    public ObjHeightSlider(int min,int max,int value){
        this();
        this.setMinimum(min);
        this.setMaximum(max);
        this.setValue(value);
    }
}
