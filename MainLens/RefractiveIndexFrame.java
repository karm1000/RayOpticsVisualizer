package MainLens;

import javax.swing.*;
import java.awt.*;
import MainLens.FrameToolkit.DetailPanel;
import MainLens.FrameToolkit.OptionContainer;
import MainLens.FrameToolkit.Frame;

public class RefractiveIndexFrame extends JFrame{
	
	Visualizer v;
	RefIndexPanel panel;
	
	RefractiveIndexFrame(Visualizer v) {
		this.v=v;
		this.setLayout(new BorderLayout());
		panel=new RefIndexPanel(v);
		panel.setLocation(10,10);
		
		this.setBounds(Frame.d.width/2,Frame.d.height/4+50, OptionContainer.size.width,6*DetailPanel.size.height+24);
		this.add(panel,BorderLayout.CENTER);
		this.setResizable(false);
//		this.setVisible(false);
	}

}
