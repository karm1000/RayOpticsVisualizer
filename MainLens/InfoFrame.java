package MainLens;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InfoFrame extends JFrame {
    String s="A lens is one of the most familiar optical devices for a human being. We have lenses in " +
             "our eyes and a good number of us supplement them with another set of lenses in our " +
             "spectacles. A lens is made of a transparent material bounded by two spherical surfaces. " +
             "The surfaces may be both convex, both concave or one convex and one concave. When the " +
             "thickness of the lens is small compared to the other dimensions like object distance, " +
             "we call it a thin lens.";

    String s2 ="Where, Focal Length = f = OF2\n"+
               "       Object Distance = u = OB\n"+
               "       Object Height = h0 = AB\n"+
               "       Image Distance = v = OB'\n"+
               "       Image Height = hi = A'B'\n"+
               "       Magnification factor = m \n";
    JTextArea textArea = new JTextArea();
    JPanel infoPanel = new JPanel(null);
    JPanel upperPanel = new JPanel(null);
    JScrollPane pane = new JScrollPane(infoPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    BufferedImage myPicture = ImageIO.read(new File("src/ImageFormation.png"));
    BufferedImage formulaeV = ImageIO.read(new File("src/allFormulae.jpeg"));
    BufferedImage lensMakers = ImageIO.read(new File("src/lensMakersF1.png"));

    public InfoFrame() throws IOException {

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        infoPanel.setLayout(null);
        infoPanel.setBackground(Color.white);
        infoPanel.setPreferredSize(new Dimension(d.width,2000));

        Font font = new Font("Sarif",Font.PLAIN,17);

        textArea.setFont(font);
        textArea.setSize(d.width-100,150);
        textArea.setLocation(75,0);
        textArea.setEditable(false);
        textArea.setText(s);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        infoPanel.add(textArea);









        upperPanel.setPreferredSize(new Dimension(d.width,40));







        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        this.setSize(d);

        this.add(upperPanel,BorderLayout.NORTH);
        this.add(pane,BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new InfoFrame();
    }
}
