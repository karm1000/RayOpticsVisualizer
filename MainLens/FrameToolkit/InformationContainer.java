package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class InformationContainer extends JPanel {

    public static final Dimension size = new Dimension(SecondaryPanel.size.width*3/4, SecondaryPanel.size.height);
    public static Point location;
    public int row=0,column=0;
    public InformationContainer(){
        this.setPreferredSize(size);
        this.setLayout(null);
        this.setBackground(Color.lightGray);
    }

    public void addDetailPanel(Component component){
        int x = (column)*component.getWidth() + (column+1)*8;
        int y = (row)*component.getHeight() + (row+1)*8;
        location = new Point(x,y);
        if(row>=2){
            row = 0;
            column++;
        }else {
            row++;
        }
        component.setLocation(location);
        this.add(component);
    }
}
