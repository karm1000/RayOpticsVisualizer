package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HeaderButtons extends JButton {
    public static final Dimension size = new Dimension(Header.size.width/10,Header.size.height-10);
    public HeaderButtons(String text){
        this.setFocusable(false);
        this.setText(text);
        this.setSize(size);
        this.setFont(new Font("Sarif",Font.BOLD,20));
    }
    public HeaderButtons(String text, ActionListener actionListener){
        this(text);
        this.addActionListener(actionListener);
    }
    public HeaderButtons(String text, ActionListener actionListener,Point p){
        this(text,actionListener);
        this.setLocation(p);
    }

}
