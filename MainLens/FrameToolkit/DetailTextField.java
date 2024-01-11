package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class DetailTextField extends JTextField {
    public static final Dimension size  = new Dimension(100,DetailPanel.size.height-10);
    DetailTextField(){
        this.setFont(new Font("Sarif",Font.PLAIN,20));
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setSize(size);

    }
    DetailTextField(String s){
        this();
        this.setText(s);
    }
}
