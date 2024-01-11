package MainMirror;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Run.FrontPage;
import MainLens.Visualizer;

import java.net.URL;


public class MyEvent2 implements ActionListener {
    FrontPage fp;
    Info in;
    Thraed1 th1;
    URL concave_url, convex_url, sign_url, intro_url;

    public MyEvent2(FrontPage fp) {
        this.fp = fp;
        th1 = new Thraed1();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fp.mirror) {
            System.out.println("mirror ...");
            String s = "A mirror is defined as a reflecting surface and can be explained by \nthe law of reflection, which states that when a ray of light is made to fall on the reflecting surface, \nthe incident ray, the reflected ray and the normal to the surface of the mirror \nall lie in the same plane and the angle of incidence is equal to the \nangle of reflection.";
            JOptionPane.showMessageDialog(null,
                    s,
                    "What is a Mirror ?",
                    JOptionPane.INFORMATION_MESSAGE
            );
            new MainFrame(-30, -50, 100);
            fp.dispose();
        } else if (e.getSource() == fp.lens) {
            String s = "Lenses are basically magnifying glasses with curved sides.\nA lens is a piece of transparent glass which concentrates or disperses light rays when passes through them by refraction.\nDue to the magnifying property, lenses are used in telescopes and other magnifying devices.\nThey are employed in cameras for gathering the light rays.\nIn cameras, not one, but a group of lenses are used for the gathering of light.\nMagnification of a lens is the relation between the size of the image formed and the size of the object.\nLenses can also be used in groups in order to avoid the blurriness or distortion caused to the image formed by the lens.";
            JOptionPane.showMessageDialog(null,
                    s,
                    "What is a Lens ?",
                    JOptionPane.INFORMATION_MESSAGE
            );
            System.out.println("lens ...");
            Visualizer v = new Visualizer();
            fp.dispose();
        } else if (e.getSource() == fp.exit) {
            System.exit(0);
        } else if (e.getSource() == fp.info) {
            in = new Info();
            in.filename = "/resources1/RAY OPTICS.txt";
            in.getJob2(fp);
        } else {
            in.cs.dispose();
            in.dispose();
            in = new Info();
            in.filename = "/resources1/" + e.getActionCommand() + ".txt";
            in.getJob2(fp);

        }
		/*else if(e.getSource()==fp.info  )
		{
			in=new Info();
			in.setVisible(true);
			in.cs.setVisible(true);
			in.getJob2(fp);
		}
		else if(e.getSource()==in.cs.cavein){
			concave_url = FrontPage.class.getResource("/resources1/concave.txt");
			in.cs.dispose();
			in.dispose();
			in=new Info();
			in.filename= "/resources1/concave.txt";
			in.getJob2(fp);
			
		}
		
		else if(e.getSource()==in.cs.vexin)
		{
			convex_url = FrontPage.class.getResource("/resources1/convex.txt");
			in.cs.dispose();
			in.dispose();
			in=new Info();
			in.filename= "/resources1/convex.txt";
			in.getJob2(fp);
			
		//	fp.top.in.ta=new JTextPane();
	
		}
		else if(e.getSource()==in.cs.formulas)
		{
			sign_url = FrontPage.class.getResource("/resources1/sign.txt");
			in.cs.dispose();
			in.dispose();
			in=new Info();
			in.filename= "/resources1/sign.txt";
			
		in.getJob2(fp);
			
		}
		else if(e.getSource()==in.cs.intro)
		{
			intro_url = FrontPage.class.getResource("/resources1/intro.txt");
			in.cs.dispose();
			in.dispose();
			in=new Info();
			in.filename= "/resources1/intro.txt";
	
			in.getJob2(fp);
			
		}*/
        th1.run();

    }
}