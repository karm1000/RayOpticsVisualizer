package MainMirror;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JLabel;
import javax.swing.JSlider;


import java.awt.Dimension;
import java.awt.Toolkit;
//import java.awt.BorderLayout;
import java.awt.Color;

public class MainFrame extends JFrame /*implements ChangeListener*/ {
	JPanel bottom, left;
	JSlider distance, height;
	TopPanel top;
	GraphicsPanel graphics;
	Calculation obj;
	Dimension d1, d2;
	Slider slider;
	Scale scale;
	float f, u, ho, v, hi, scaleX, scaleY;
	int mX, mY;
	Thraed th;
	Thraed1 th1;
	Logic w;
	MyEvent me;
	

	public MainFrame(float f, float u, float ho) {
		this.f = f;
		this.u = u;
		this.ho = ho;
		
		this.setTitle("MIRROR");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		me = new MyEvent(this);
		obj = new Calculation(this.f, this.u, this.ho);
		this.v = obj.ImageDist();
		this.hi = obj.ImageHeight();
		
		d1 = Toolkit.getDefaultToolkit().getScreenSize();
		d1.height-=50;
		bottom = new JPanel();
		left = new JPanel();
		top = new TopPanel(this);
		top.u_tf.setText(""+this.u);
		top.f_tf.setText(""+this.f);
		top.ho_tf.setText(""+this.ho);
		
		graphics = new GraphicsPanel(this);
		slider = new Slider();
		distance = new JSlider();
		height = new JSlider(JSlider.VERTICAL);
		scale = new Scale(this);
		th=new Thraed();
		th1=new Thraed1();
		
		graphics.setBounds(80, d1.height / 4, d1.width - 80, (3 * d1.height / 4)-80);
		graphics.setBackground(Color.white);
		
		bottom.setBounds(0,d1.height-80,d1.width,80);
		//bottom.setBackground(Color.white);
		bottom.setLayout(null);
		
		left.setBounds(0,d1.height/4,80,(3 * d1.height / 4)-80);
		//left.setBackground(Color.white);
		left.setLayout(null);
		
		//top.setBackground(Color.yellow);
		top.setBounds(0,0,d1.width,d1.height/4);
		
		this.mX=slider.maxValueX(this.u, this.v, this.f);
        this.mY=slider.maxValueY(this.ho, this.hi);
        
		
		if(this.u > this.f) {
			distance.setSize((d1.width - 280) / 2 , 80);
			distance.setMinimum((-1) * this.mX / 2);
		}
		else if(this.u <= this.f) {
			
			distance.setSize(d1.width - 280 , 80);
			distance.setMinimum((-1) * this.mX);
		}
		distance.setMaximum(0);
		distance.setValue((int)this.u);
		distance.setLocation(180, 0);
		distance.setMajorTickSpacing(slider.gapObject(this.u, this.v, this.f));
		distance.setMinorTickSpacing(slider.gapObject(this.u, this.v, this.f) / 2);
		distance.setPaintTicks(true);
		distance.setPaintLabels(true);
		//distance.setBackground(Color.white);
		distance.addChangeListener(me);
		distance.setToolTipText("SET OBJECT DISTANCE");
		bottom.add(distance);
		
		height.setMinimum((-1) * slider.maxValueY(this.ho, this.hi));
		height.setMaximum(slider.maxValueY(this.ho, this.hi));
		height.setValue((int)this.ho);
		height.setBounds(0, 50, 80, this.graphics.getHeight()-100);
		height.setMajorTickSpacing(slider.gapHeight(this.ho, this.hi));
		height.setMinorTickSpacing(slider.gapHeight(this.ho, this.hi) / 2);
		height.setPaintTicks(true);
		height.setPaintLabels(true);
		//height.setBackground(Color.white);
		height.addChangeListener(me);
		height.setToolTipText("SET OBJECT HEIGHT");
		
		left.add(height);
		
		this.add(top);
		this.add(bottom);
		this.add(left);
		this.add(graphics);
		this.setVisible(true);
		this.addMouseMotionListener(me);
		w = new Logic(this, 2);
		try {
			w.actionMethod();
		} catch(NumberFormatException nfe) {
			System.out.println("only integers ...");
		  }
		  catch(MyException1 me1) {
			System.out.println("only negative distance ...");
		  }
		//this.top.concave.setEnabled(false);
	}
	
	/*public void stateChanged(ChangeEvent e) {
		w.modify(this,1);
		System.out.print(w);
		th.run();
	}*/
}

class Main {
	public static void main(String args[]) {
		new MainFrame(-30, -50, 100);
	}
}
