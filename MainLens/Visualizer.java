package MainLens;

import MainLens.FrameToolkit.*;
import MainLens.FrameToolkit.Frame;
import MainLens.GeometricalOptics.Lens.Lens;
import MainLens.GeometricalOptics.Platform;
import MainLens.GeometricalOptics.Specimen.ObjectSpecimen;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class  Visualizer extends Frame /*implements ChangeListener, ActionListener,KeyListener*/ {

	public Platform p = new Platform(new ObjectSpecimen(-50,50),new Lens(30));
	int scaleX=100,scaleY=100;
	int limitOfScale = 10000;
	int w,h;
	boolean isConcaveRunning=false;
	Events events = new Events(this);
	JPanel dis_panel;
	JSlider dis_slider;
	int dis_slider_width;
	JPanel height_panel;
	JSlider height_slider;
	int height_slider_height;
	public GraphicPanel g_panel;
	UpperPanel upperPanel = new UpperPanel();
	Header header = new Header();
	SecondaryPanel secondaryPanel = new SecondaryPanel();
	OptionContainer optionContainer = new OptionContainer();

	InformationContainer informationContainer = new InformationContainer();
	AllOptionContainer allOptionContainer = new AllOptionContainer();
	OptionButton concaveButton = new OptionButton("Concave");
	OptionButton convexButton = new OptionButton("Convex");
	OptionContainer velocityContainer = new OptionContainer();
//	VelocityThread velocityThread;
//	VelocityRun velocityRun;
	VelocityTask velocityTask;
	OptionButton goBackVC = new OptionButton();
	OptionButton setB = new OptionButton("Set");
	OptionButton stopB = new OptionButton("Stop");
	DetailPanel velObj = new DetailPanel("Object Velocity (cm/s)",""+p.getObject().getVelocity());
	DetailPanel velImg = new DetailPanel("Image Velocity (cm/s)",""+p.getImage().getVelocity());
	CalculationPanel calculationPanel = new CalculationPanel(this);

	OptionButton setScaleButton = new OptionButton("SetScale");
	OptionButton resetButton = new OptionButton("Reset");
	OptionButton infoButton = new OptionButton("Info");
	OptionButton velocityButton = new OptionButton("Velocity");
	RefractiveIndexFrame frame = new RefractiveIndexFrame(this);
	HeaderButtons backButton = new HeaderButtons("",events);
	HeaderButtons exitButton = new HeaderButtons("",events);
	TitlePanel titlePanel = new TitlePanel("Lens",events);

	public Visualizer(){

		w=d.width;
		h=d.height;

		dis_slider_width=w-100;
		dis_slider=new JSlider(-100,100,-50);
		dis_slider.setBounds(100,0,dis_slider_width,100);
		dis_slider.setBackground(new Color(0x84C6F8));
		dis_slider.setPaintTrack(true);
		dis_slider.setMajorTickSpacing(10);
		dis_slider.setPaintLabels(true);
		dis_slider.setToolTipText("SET OBJECT DISTANCE(IN cm)");
		dis_slider.addChangeListener(events);

		height_slider_height=h-h/4-150;
		height_slider=new JSlider(-100,100,50);
		height_slider.setOrientation(SwingConstants.VERTICAL);
		height_slider.setBounds(0,0,100,height_slider_height);
		height_slider.setBackground(new Color(0xFFFE7979, true));
		height_slider.setPaintTrack(true);
		height_slider.setMajorTickSpacing(10);
		height_slider.setPaintLabels(true);
		height_slider.setToolTipText("SET OBJECT HEIGHT(IN cm)");
		height_slider.addChangeListener(events);

		dis_panel=new JPanel();
		dis_panel.setBackground(Color.white);
		dis_panel.setBounds(0,h-150,w,150);
		dis_panel.setLayout(null);

		height_panel=new JPanel();
		height_panel.setBackground(Color.white);
		height_panel.setBounds(0,h/4,100,height_slider_height);
		height_panel.setLayout(null);

		g_panel=new GraphicPanel(this
				,dis_slider_width
				,height_slider_height
				,dis_slider.getValue()
				,height_slider.getValue()
				,(int) p.getLens().getF()
				,(int) p.getObject().getDistance()
				,(int) p.getObject().getHeight());

		dis_panel.add(dis_slider);
		height_panel.add(height_slider);

		this.add(dis_panel);
		this.add(height_panel);
		this.add(g_panel);

		g_panel.addMouseMotionListener(events);

		convexButton.addActionListener(events);
		concaveButton.addActionListener(events);

		convexButton.setVisible(false);
		convexButton.setLocation((OptionContainer.size.width-OptionButton.size.width)/2,5);
		concaveButton.setLocation((OptionContainer.size.width-OptionButton.size.width)/2,5);
		optionContainer.add(convexButton);
		optionContainer.add(concaveButton);

		setScaleButton.setLocation(OptionContainer.size.width- setScaleButton.getWidth()-5,OptionContainer.size.height- setScaleButton.getHeight()-5);
		setScaleButton.addActionListener(events);

		resetButton.setLocation(5,OptionContainer.size.height- setScaleButton.getHeight()-5);
		resetButton.addActionListener(events);

		infoButton.setLocation(concaveButton.getX(),OptionContainer.size.height-2*resetButton.getHeight()-10);
		infoButton.addActionListener(events);

		goBackVC.setUI(new CustomButtonUI());
		goBackVC.setSize(25,25);
		try {
			Image img = ImageIO.read(getClass().getResource("/MainLens/backbutton2.png"));
			goBackVC.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
//		Icon icon = new ImageIcon("closewindow.png");
//		goBackVC.setIcon(icon);
//		setB.setUI(new CustomButtonUI());
//		stopB.setUI(new CustomButtonUI());

		velocityButton.setLocation(concaveButton.getX(),OptionContainer.size.height-3*resetButton.getHeight()-20);
		velImg.setLocation(5,velocityContainer.size.height-velImg.size.height-5);
		velObj.setLocation(5,velImg.getY()-velObj.size.height-5);
		velImg.textField.setEditable(false);
		Dimension d = new Dimension(setB.size.width/2,setB.size.height);
		stopB.setSize(d);
		setB.setSize(d);
		stopB.setLocation(velocityContainer.size.width-d.width-5,velObj.getY()-d.height-5);
		setB.setLocation(velocityContainer.size.width-d.width-5,velObj.getY()-d.height-5);
		goBackVC.setLocation(5,5);
		velocityContainer.add(goBackVC);
		velocityContainer.add(stopB);
		stopB.setVisible(false);
		velocityContainer.add(setB);
		velocityContainer.add(velObj);
		velocityContainer.add(velImg);

		stopB.addActionListener(events);
		setB.addActionListener(events);

		velocityButton.addActionListener(events);
		goBackVC.addActionListener(events);

		optionContainer.add(setScaleButton);
		optionContainer.add(resetButton);
		optionContainer.add(infoButton);
		optionContainer.add(velocityButton);

		allOptionContainer.add(optionContainer,"option");
		allOptionContainer.add(velocityContainer,"velocity");

		upperPanel.setSize(w,h/4);

		backButton.setLocation(5,5);
		backButton.setSize(25,25);
		backButton.setUI(new CustomButtonUI());
		try {
			Image img = ImageIO.read(getClass().getResource("/MainLens/backbutton2.png"));
			backButton.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		exitButton.setSize(25,25);
		exitButton.setLocation(backButton.getSize().width+10,5);
		exitButton.setUI(new CustomButtonUI());
		try {
			Image img = ImageIO.read(getClass().getResource("/MainLens/closewindow.png"));
			exitButton.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		titlePanel.setLocation((Header.size.width-TitlePanel.size.width)/2,2);

		header.add(backButton);
		header.add(exitButton);
		header.add(titlePanel);

		secondaryPanel.add(calculationPanel,BorderLayout.CENTER);
		secondaryPanel.add(allOptionContainer,BorderLayout.EAST);

		upperPanel.add(header,BorderLayout.NORTH);
		upperPanel.add(secondaryPanel,BorderLayout.CENTER);

		this.add(upperPanel);

		this.setTitle("Visualizer");
		this.setVisible(true);
	}

	void setSlider(){
//		if(p.getObject().getDistance()<this.scaleX)
			this.dis_slider.setValue((int) p.getObject().getDistance());
//		if(p.getObject().getHeight()<this.scaleY)
			this.height_slider.setValue((int) p.getObject().getHeight());
		if(Math.abs(p.getLens().getF())<=50) {
			this.calculationPanel.focalLengthSlider.setValue((int) p.getLens().getF());
			this.calculationPanel.focalLengthSlider.setEnabled(true);
		}else if (Math.abs(p.getLens().getF())>=50) {
			this.calculationPanel.focalLengthSlider.setEnabled(false);
		}
	}

	void setSliderLabel(){
		Dictionary dict = new Hashtable();

		dis_slider.removeChangeListener(events);
		height_slider.removeChangeListener(events);

		dis_slider.setMinimum(-scaleX);
		dis_slider.setMaximum(scaleX);

		height_slider.setMinimum(-scaleY);
		height_slider.setMaximum(scaleY);

		int temp1 = scaleX/10;
		for (int i = -scaleX; i <= scaleX; i += temp1) {
			dict.put(i, new JLabel("" + i));
		}

		dis_slider.setLabelTable(dict);
		dis_slider.setMajorTickSpacing(temp1);
		dis_slider.setMinorTickSpacing(temp1/10);

		dict = new Hashtable();

		temp1= scaleY/10;
		for (int i = -scaleY; i <= scaleY; i += temp1) {
			dict.put(i, new JLabel("" + i));
		}

		height_slider.setLabelTable(dict);
		height_slider.setMajorTickSpacing(temp1);
		height_slider.setMinorTickSpacing(temp1/10);

		dis_slider.addChangeListener(events);
		height_slider.addChangeListener(events);
	}

	void resetScale(){
		this.scaleX = 100;
		this.scaleY = 100;
	}

	public boolean isOutOfRange(){
		boolean notneededDis = false;
		boolean notneededHei = false;
		if(Math.abs(p.getImage().getDistance())>limitOfScale && !Double.isInfinite(p.getImage().getDistance())){
			notneededDis = true;
		}if (Math.abs(p.getImage().getHeight())>limitOfScale && !Double.isInfinite(p.getImage().getHeight())) {
			notneededHei = true;
		}
		return notneededHei || notneededDis;
	}
	void isScaleNeeded(){
		boolean isNeed=false;
		if(Double.isInfinite(p.getImage().getDistance())){
			isNeed = false;
		} else if(Math.abs(p.getObject().getDistance())>scaleX){
			isNeed=true;
		}else if (Math.abs(p.getObject().getHeight())>scaleY) {
			isNeed=true;
		}else if (Math.abs(p.getImage().getDistance())>scaleX) {
			isNeed=true;
		}else if (Math.abs(p.getImage().getHeight())>scaleY) {
			isNeed=true;
		}
	}


	public static void main(String[] args) {
		new Visualizer();
	}
}

class CustomButtonUI extends BasicButtonUI {

	// Override the installDefaults() method to customize the button appearance
	Icon icon = new ImageIcon("closewindow.png");
	@Override
	protected void installDefaults(AbstractButton b) {
		super.installDefaults(b);
		b.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		b.setBackground(Color.WHITE);
		b.setForeground(Color.BLACK);
		b.setFont(new Font("Arial", Font.BOLD, 14));
	}

	// Override the paint() method to customize the button painting
	@Override
	public void paint(Graphics g, JComponent c) {
		AbstractButton button = (AbstractButton) c;
		ButtonModel model = button.getModel();
		if (model.isPressed()) {
			g.setColor(Color.RED);
		} else {
			g.setColor(button.getBackground());
		}
		g.fillRect(0, 0, c.getWidth(), c.getHeight());
		super.paint(g, c);
	}
}
