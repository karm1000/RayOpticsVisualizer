package MainMirror;

import javax.swing.JOptionPane;

public class MyException1 extends Exception {
	int flag;
	
	public MyException1() {
		this.flag = -1;
	}
	MyException1(int flag) {
		this.flag = flag;
	}

	void negativeDistance() {
		JOptionPane.showMessageDialog(null, 
									 "Image can be obtained only if the object is in front of the mirror.\nSo, enter only negative distance ...",
									 "Warning",
									 JOptionPane.WARNING_MESSAGE);
	}
	public void numberOnly() {
		JOptionPane.showMessageDialog(null, 
									 "You can enter only numbers as the values ...",
									 "Warning",
									 JOptionPane.WARNING_MESSAGE);
	}
	int tooLarge() {
		return JOptionPane.showOptionDialog(null,
											"Too large values ...\nThe image mightnot be clearly visible.\nDo you want to continue ?",
											"Warning",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.WARNING_MESSAGE,
											null,
											null,
											0
											);
	}
	void outOfRange() {
		JOptionPane.showMessageDialog(null, 
									 "Either object distance or object height Out of Range.\nThe maximum permissible value is 10000.",
									 "Warning",
									 JOptionPane.WARNING_MESSAGE);
	}
}