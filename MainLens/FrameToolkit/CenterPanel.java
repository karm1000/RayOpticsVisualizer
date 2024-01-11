package MainLens.FrameToolkit;




import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    public static final Dimension size = new Dimension(Frame.d.width, Frame.d.height*3/4);

    public CenterPanel(){

        this.setBackground(Color.white);
        this.setPreferredSize(size);
        this.setLayout(null);

    }
}
