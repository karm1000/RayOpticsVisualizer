package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class DetailLabel extends JLabel {
    DetailLabel(String s){
        this();
        this.setText(s);
    }
    DetailLabel(){
        this.setFont(new Font("Sarif",Font.BOLD,20));
    }
}
