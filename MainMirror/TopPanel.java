package MainMirror;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
//import javax.swing.event.ChangeListener;
//import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import java.net.URL;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

import java.util.Dictionary;
import java.util.Hashtable;

class TopPanel extends JPanel /*implements ChangeListener, ActionListener*/ {
	MainFrame obj;
	JPanel titleBar;
	JLabel f, u, ho, v, hi, itype, isize, mag, title;
	JTextField f_tf, u_tf, ho_tf, v_tf, hi_tf, mag_tf;
	JButton submit, reset, swap, back, exit,info;
	JSlider focal;
	Dimension d;
	int x, y;
	String s;

	Dictionary dict;

	TopPanel(MainFrame obj) {
		final Font font = new Font("SansSerif", Font.BOLD, 18);

		this.obj = obj;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(obj.d1.width, obj.d1.height / 4));
		
		URL url1 = MainFrame.class.getResource("/resources1/relod.png");
		URL url2 = MainFrame.class.getResource("/resources1/ib.png");
		titleBar = new JPanel();
		focal = new JSlider(-210, -10, (int) obj.f);
		submit = new JButton();
		reset = new JButton(new ImageIcon(url1));
		swap = new JButton("CONCAVE");
		back = new JButton("BACK");
		exit = new JButton("EXIT");
		title = new JLabel();
		info = new JButton(new ImageIcon(url2));
		f = new JLabel();
		u = new JLabel();
		ho = new JLabel();
		v = new JLabel();
		hi = new JLabel();
		itype = new JLabel();
		isize = new JLabel();
		mag = new JLabel();
		f_tf = new JTextField();
		u_tf = new JTextField();
		ho_tf = new JTextField();
		v_tf = new JTextField();
		hi_tf = new JTextField();
		mag_tf = new JTextField();
		
		titleBar.setBounds(0, 0, obj.d1.width, 40);
		//titleBar.setBackground(Color.black);
		titleBar.setVisible(true);
		
		x = obj.d1.width / 4 - 10;
		y = ((obj.d1.height / 4) / 4) - 10;
		
		u.setText("Object Distance");
		u.setFont(font);
		d = u.getPreferredSize();
		u.setSize(d.width, y);
		u.setLocation(10, y + 10);

		s = String.valueOf(obj.u);
		u_tf.setText(s);
		u_tf.setFont(font);
		u_tf.setSize(100, y);
		u_tf.setLocation(u.getX() + d.width + 20, y + 10);
		u_tf.addActionListener(obj.me);

		ho.setText("Object Height");
		ho.setFont(font);
		d = ho.getPreferredSize();
		ho.setSize(d.width, y);
		ho.setLocation(x + 10, y + 10);
		
		s = String.valueOf(obj.ho);
		ho_tf.setText(s);
		ho_tf.setFont(font);
		ho_tf.setSize(100, y);
		ho_tf.setLocation(ho.getX() + d.width + 20, y + 10);
		ho_tf.addActionListener(obj.me);

		mag.setText("Magnification Factor");
		mag.setFont(font);
		d = mag.getPreferredSize();
		mag.setSize(d.width, y);
		mag.setLocation(2 * (x + 10), 3 * (y + 10));
		

		s = String.valueOf(String.format("%.3f", obj.hi / obj.ho));
		mag_tf.setText(s);
		mag_tf.setFont(font);
		mag_tf.setSize(100, y);
		mag_tf.setLocation(mag.getX() + d.width + 20, 3 * (y + 10));
		mag_tf.setEditable(false);
		
		f.setText("Focal Length");
		f.setFont(font);
		d = f.getPreferredSize();
		f.setSize(d.width, y);
		f.setLocation(2 * (x + 10), 2 * (y + 10));

		s = String.valueOf(obj.f);
		f_tf.setText(s);
		f_tf.setFont(font);
		f_tf.setSize(100, y);
		f_tf.setLocation(mag_tf.getX(), 2 * (y + 10));
		f_tf.setEditable(false);

		v.setText("Image Distance");
		v.setFont(font);
		d = u.getPreferredSize();
		v.setSize(d.width, y);
		v.setLocation(10, 2 * (y + 10));

		s = String.valueOf(String.format("%.3f", obj.v));
		v_tf.setText(s);
		v_tf.setFont(font);
		v_tf.setSize(100, y);
		v_tf.setLocation(v.getX() + d.width + 20, 2 * (y + 10));
		v_tf.setEditable(false);

		hi.setText("Image Height");
		hi.setFont(font);
		d = ho.getPreferredSize();
		hi.setSize(d.width, y);
		hi.setLocation(x + 10, 2 * (y + 10));

		s = String.valueOf(String.format("%.3f", obj.hi));
		hi_tf.setText(s);
		hi_tf.setFont(font);
		hi_tf.setSize(100, y);
		hi_tf.setLocation(hi.getX() + d.width + 20, 2 * (y + 10));
		hi_tf.setEditable(false);

		s = obj.obj.ImageSize();
		isize.setText("Image Size : " + s);
		isize.setFont(font);
		d = isize.getPreferredSize();
		isize.setSize(d.width, y);
		isize.setLocation(10, 3 * (y + 10));

		s = obj.obj.ImageType();
		itype.setText("Image Type : " + s);
		itype.setFont(font);
		d = itype.getPreferredSize();
		itype.setSize(d.width, y);
		itype.setLocation(x + 10, 3 * (y + 10));
		
		focal.setSize(mag.getWidth() + 20 + mag_tf.getWidth(), y + 5);
		focal.setLocation(f.getX(), y + 10);
		focal.setPaintTrack(true);
		focal.setMajorTickSpacing(20);
		focal.setMinorTickSpacing(10);
		focal.setPaintTicks(true);
		focal.setPaintLabels(true);
	
		focal.addChangeListener(obj.me);

	

		title.setText("CONCAVE MIRROR");
		title.setFont(new Font("SansSerif", Font.BOLD, 25));
	
		d = title.getPreferredSize();
		title.setBounds((obj.d1.width - d.width) / 2, 5, d.width, 30);
		
		swap.setText("CONCAVE MIRROR");
		swap.setFont(font);
		d = swap.getPreferredSize();
		swap.setText("CONVEX MIRROR");
		swap.setSize(d);
		swap.setLocation(3 * (x + 10) + (d.width / 2), y + 10);
		swap.setFocusable(false);
		swap.addActionListener(obj.me);
		

		reset.setBounds(swap.getX(), (3 * (y + 10)) - 20, 30, 30);
		reset.setFont(font);
		reset.setFocusable(false);
		reset.addActionListener(obj.me);
		
		info.setBounds(reset.getX() + 40, (3 * (y + 10)) - 20, 30, 30);
		info.setFocusable(false);
		info.addActionListener(obj.me);

		back.setFont(font);
		d = back.getPreferredSize();
		back.setBounds(10, 5, d.width, 30);
		back.setFocusable(false);
		back.addActionListener(obj.me);
		
		exit.setFont(font);
		//d = exit.getPreferredSize();
		exit.setBounds(obj.d1.width - d.width - 10, 5, d.width, 30);
		exit.setFocusable(false);
		exit.addActionListener(obj.me);
		
		System.out.println("Status : " + obj.me);
		this.add(title);
		this.add(reset);
		this.add(focal);
		this.add(back);
		//this.add(convex);
		this.add(swap);
		this.add(exit);
		this.add(f);
		this.add(f_tf);
		this.add(u);
		this.add(u_tf);
		this.add(ho);
		this.add(ho_tf);
		this.add(v);
		this.add(v_tf);
		this.add(hi);
		this.add(hi_tf);
		this.add(itype);
		this.add(isize);
		this.add(mag);
		this.add(mag_tf);
		this.add(titleBar);
		this.add(info);
		//SETTING TOOLTIPTEXT
		focal.setToolTipText("SET FOCAL LENGTH");
		reset .setToolTipText("RESET SCALE");
		u_tf.setToolTipText("ENTER OBJECT DISTANCE(IN cm)");
		ho_tf.setToolTipText("ENTER OBJECT HEIGHT(IN cm)");
		mag_tf.setToolTipText("MAGNIFICATION FACTOR");
		isize.setToolTipText(isize.getText());
		itype.setToolTipText(itype.getText());
		v_tf.setToolTipText("IMAGE DISTANCE(IN cm)");
		hi_tf.setToolTipText("IMAGE HEIGHT(IN cm)");
		f_tf.setToolTipText("FOCAL LENGTH(IN cm)");
		swap.setToolTipText("CONCAVE<->CONVEX");
	}

	/*public void stateChanged(ChangeEvent e) {
		if (e.getSource() == this.focal) {
			obj.w.modify(this.obj, 1);
			System.out.println(obj.w);
			obj.th.run();
		}
	}*/
	public void faltu() {
		dict = new Hashtable();
		
		obj.distance.removeChangeListener(obj.me);
		obj.height.removeChangeListener(obj.me);
		int temp = (int) obj.slider.gapObjectSlider(obj.mX);
		for (int i = -obj.mX; i <= 0; i += temp) {
			dict.put(i, new JLabel("" + i));
		}
		obj.distance.setLabelTable(dict);
		obj.distance.setMajorTickSpacing(temp);
		obj.distance.setMinorTickSpacing(temp / 2);
		
		dict = new Hashtable();
		temp=(int)obj.slider.gapHeightSlider(obj.mY);
		for (int i = -obj.mY; i <= obj.mY; i += temp) {
			dict.put(i, new JLabel("" + i));
		}
		obj.height.setLabelTable(dict);
		obj.height.setMajorTickSpacing(temp);
		obj.height.setMinorTickSpacing(temp / 2);
		
		obj.distance.addChangeListener(obj.me);
		obj.height.addChangeListener(obj.me);
	}
	
	public void helper() {
		obj.w.modify(obj, 2);
	dict = new Hashtable();
		int temp = (int) obj.slider.gapObject(obj.f, obj.u, obj.v);
		for (int i = -obj.mX; i <= 0; i += temp) {
			dict.put(i, new JLabel("" + i));
		}
		obj.distance.setLabelTable(dict);
		obj.distance.setMajorTickSpacing(temp);
		obj.distance.setMinorTickSpacing(temp / 2);

		
		dict = new Hashtable();
		for (int i = -obj.mY; i <= obj.mY; i += obj.slider.gapHeight(obj.ho, obj.hi)) {
			dict.put(i, new JLabel("" + i));
		}
		obj.height.setLabelTable(dict);
		obj.height.setMajorTickSpacing(obj.slider.gapHeight(obj.ho, obj.hi));
		obj.height.setMinorTickSpacing(obj.slider.gapHeight(obj.ho, obj.hi) / 2);
//		System.out.println(obj.top.u_tf.getText());
		obj.th1.run();
	}

	/*public void actionPerformed(ActionEvent e) {
		obj.th1.run();
		if (e.getSource() == reset || e.getSource() == this.u_tf || e.getSource() == this.ho_tf) {
			helper();
		} else if (e.getSource() == convex) {
			this.convex.setEnabled(false);
			this.concave.setEnabled(true);
			obj.f *= (-1f);
			obj.w.modify(obj, 2);
			helper();
		} else if (e.getSource() == concave) {
			this.concave.setEnabled(false);
			this.convex.setEnabled(true);

			obj.f *= (-1f);
			obj.w.modify(obj, 2);
			helper();
		}
	
	}*/
}