package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class RadioButtons extends JRadioButton {
    public RadioButtons(){
        this.setFont(new Font("Sarif",Font.BOLD,20));
        this.setOpaque(false);
        this.setFocusable(false);
//        this.setLocation(0,0);
    }

    public RadioButtons(String text){
        this();
        this.setText(text);

    }
}
