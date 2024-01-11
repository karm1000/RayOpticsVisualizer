package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class RadiusOfCurSlider extends JSlider{
	
	 public final Dimension size =  new Dimension(DetailPanel.size.width-5, DetailPanel.size.height);

	 public RadiusOfCurSlider(int min,int max,int value){
	        super(min, max, value);
	        this.setPreferredSize(size);
	        this.setPaintTicks(true);
	        this.setMinorTickSpacing(5);
	        this.setPaintTrack(true);
	        this.setMajorTickSpacing(10);
	        this.setPaintLabels(true);
	        this.setBackground(Color.white);
	    }
}
