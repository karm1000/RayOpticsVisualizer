package MainLens.FrameToolkit;

import javax.swing.*;
import java.awt.*;

public class DetailPanel extends JPanel {
    public static final String NO_TEXTFIELD = "NoTextField";
    public DetailLabel label;
    public DetailTextField textField;
    public static final Dimension size = new Dimension(InformationContainer.size.width/3 - 10,
            InformationContainer.size.height/3 -10);
    public DetailPanel(){
        this.setLayout(null);
        this.setSize(size);
        this.setBackground(Color.white);
        label = new DetailLabel();
        textField = new DetailTextField();
        label.setBounds(5,5,size.width-DetailTextField.size.width,size.height - 10);
        textField.setLocation(size.width-DetailTextField.size.width-5,5);
        this.add(label);
        this.add(textField);
    }
    public DetailPanel(String labelText){
        this();
        label.setText(labelText);
    }
    public DetailPanel(String labelText,String textF){
        this();
        if(textF==NO_TEXTFIELD){
            textField.setVisible(false);
            label.setText(labelText);
        }else {
            label.setText(labelText);
            textField.setText(textF);
        }
    }
    public void setLabelText(String s){
        label.setText(s);
    }
    public void setTextFieldText(String s){
        textField.setText(s);
    }
}
