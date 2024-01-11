package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class OptionButton extends JButton {
    public static Dimension size = new Dimension(OptionContainer.size.width/2 - 10,30);
    public OptionButton(){
        this.setSize(size);
        this.setFont(new Font("Sarif",Font.BOLD,16));
        this.setFocusable(false);
    }
    public OptionButton(String s){
        this();
        this.setText(s);
    }

}
