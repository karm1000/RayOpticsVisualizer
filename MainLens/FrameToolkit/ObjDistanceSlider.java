package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class ObjDistanceSlider extends JSlider {
    static int height = 125;
    public static final Dimension size = new Dimension(CenterPanel.size.width-height-10,height);
    
    public ObjDistanceSlider(){
        this.setSize(size);
        this.setPaintTicks(true);
        this.setMinorTickSpacing(5);
        this.setPaintTrack(true);
        this.setMajorTickSpacing(10);
        this.setPaintLabels(true);
        this.setBackground(Color.white);
        this.setOpaque(false);
        this.setFont(new Font("Sarif",Font.BOLD,14));
        this.setLocation(ObjHeightSlider.size.width,ObjHeightSlider.size.height);
    }

    public ObjDistanceSlider(int min,int max,int value){
        this();
        this.setMinimum(min);
        this.setMaximum(max);
        this.setValue(value);
    }
}
