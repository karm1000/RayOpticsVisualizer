package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class TitlePanel extends JPanel{
    public static final Dimension size = new Dimension(Header.size.width/10,Header.size.height-5);
    public JLabel label = new JLabel();

    public TitlePanel(){
        this.setBackground(Color.BLUE);
        this.setSize(size);
        this.setOpaque(false);
        this.add(label);
    }
    public TitlePanel(String text){
        this();
        label.setText(text);
        label.setFont(new Font("Sarif",Font.BOLD,22));
    }

    public TitlePanel(String text,MouseListener mouseListener){
        this(text);
        this.addMouseListener(mouseListener);
    }
}
