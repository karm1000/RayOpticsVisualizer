package MainLens;

import MainLens.FrameToolkit.DetailPanel;
import MainLens.FrameToolkit.OptionContainer;
import MainLens.FrameToolkit.RadiusOfCurSlider;

import javax.swing.*;
import java.awt.*;

public class RefIndexPanel extends JPanel {
    
	public static final Dimension size=new Dimension(OptionContainer.size.width,5* DetailPanel.size.height + 20);
	Visualizer v;
	
	//public JPanel panel = new JPanel()
	public DetailPanel ref_index_lens;
	public DetailPanel ref_index_medium;
	public DetailPanel radius_of_cur;
	public RadiusOfCurSlider cur_slider;
	JButton button;
	
	public RefIndexPanel(Visualizer v) {
		
		this.v=v;
		this.setLayout(new FlowLayout());
		this.setPreferredSize(size);
		this.setBackground(Color.white);
		
		ref_index_lens=new DetailPanel("Refractive index of lens -",String.valueOf(v.p.getLens().getRefractiveIndex()));
		ref_index_lens.label.setFont(new Font("SanSerif",Font.BOLD,15));
		ref_index_medium=new DetailPanel("Refractice index of medium -",String.valueOf(v.p.getLens().getRefractiveIndexOfMedium()));
		ref_index_medium.label.setFont(new Font("SanSerif",Font.BOLD,15));
		radius_of_cur=new DetailPanel("Radius of curvature -",String.valueOf(v.p.getLens().getR()));
		radius_of_cur.label.setFont(new Font("SanSerif",Font.BOLD,15));
		cur_slider=new RadiusOfCurSlider(0,100,(int)(v.p.getLens().getR()));
		
		button=new JButton("Done");
		button.setSize((size.width)/4,DetailPanel.size.height);
		button.addActionListener(v.events);
		
		ref_index_lens.setPreferredSize(DetailPanel.size);
		ref_index_medium.setPreferredSize(DetailPanel.size);
		radius_of_cur.setPreferredSize(DetailPanel.size);
		
		ref_index_lens.textField.addActionListener(v.events);
		ref_index_medium.textField.addActionListener(v.events);
		radius_of_cur.textField.addActionListener(v.events);
		cur_slider.addChangeListener(v.events);
		
		ref_index_lens.textField.setToolTipText("ENTER REFRACTIVE INDEX OF LENS");
		ref_index_medium.textField.setToolTipText("ENTER REFRACTIVE INDEX OF MEDIUM");
		radius_of_cur.textField.setToolTipText("ENTER RADIUS OF CURVATURE OF LENS(IN cm");
		cur_slider.setToolTipText("SET RADIUS OF CURVATURE OF LENS(IN cm)");
		
		this.add(ref_index_lens);
		this.add(ref_index_medium);
		this.add(radius_of_cur);
		this.add(cur_slider);
		this.add(button);
		
		
		//this.setVisible(false);
	}
}


