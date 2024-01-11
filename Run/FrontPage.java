package Run;

import MainMirror.MyEvent2;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;


public class FrontPage extends JFrame {
	public JButton lens;
	public JButton mirror;
	public JButton exit;
	public JButton info;
	JLabel title, background;
	Dimension d1, d2;
	public MyEvent2 me;
	
	public FrontPage() {
		d1 = new Dimension();
		d2 = new Dimension();
		exit = new JButton();
		info = new JButton();
		lens = new JButton();
		title = new JLabel();
		me = new MyEvent2(this);
		
		d1 = Toolkit.getDefaultToolkit().getScreenSize();
		
		mirror = new JButton();
		URL url = FrontPage.class.getResource("/resources1/ray_optics.jpg");
		ImageIcon img = new ImageIcon(url);
		Image img2 = img.getImage();
		img = new ImageIcon(img2.getScaledInstance(d1.width, d1.height, java.awt.Image.SCALE_SMOOTH));
		
		background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(0, 0, d1.width, d1.height);
		
		mirror.setText("MIRROR");
		mirror.setFont(new Font("SansSerif", Font.BOLD, 22));
		d2 = mirror.getPreferredSize();
		mirror.setBounds((d1.width - d2.width) / 2, (d1.height - d2.height) / 2, d2.width+50, d2.height);
		mirror.setFocusable(false);
		mirror.addActionListener(me);
		
		lens.setText("LENS");
		lens.setFont(new Font("SansSerif", Font.BOLD, 22));
		//d2 = lens.getPreferredSize();
		lens.setBounds((d1.width - d2.width) / 2, (d1.height - d2.height) / 2 + 50, d2.width+50, d2.height);
		lens.setFocusable(false);
		lens.addActionListener(me);
		
		exit.setText("EXIT");
		exit.setFont(new Font("SansSerif", Font.BOLD, 22));
		d2 = exit.getPreferredSize();
		exit.setBounds((d1.width - d2.width) - 60, 10, d2.width+50, d2.height);
		exit.setFocusable(false);
		exit.addActionListener(me);
		
		info.setText("INFORMATION");
		info.setFont(new Font("SansSerif", Font.BOLD, 22));
		d2 = info.getPreferredSize();
		info.setBounds(10, 10, d2.width+50, d2.height);
		info.setFocusable(false);
		info.addActionListener(me);
		
		title.setText("RAY OPTICS VISUALIZER");
		title.setFont(new Font("SansSerif", Font.BOLD, 60));
		d2 = title.getPreferredSize();
		title.setBounds((d1.width - d2.width) /2, mirror.getY() - 100, d2.width+50, d2.height);
		
		this.add(background);
		background.add(lens);
		background.add(mirror);
		background.add(exit);
		background.add(info);
		background.add(title);
		
		this.setTitle("RAY OPTICS VISUALIZER");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
		FrontPage fp = new FrontPage();
	}
}