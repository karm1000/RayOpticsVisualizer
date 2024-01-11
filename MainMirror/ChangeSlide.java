package MainMirror;

import Run.FrontPage;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Toolkit;
class ChangeSlide extends JFrame
{
    MainFrame obj;
    JButton cavein,vexin,formulas,intro;
    ChangeSlide()
    {
      
        cavein=new JButton("CONCAVE MIRROR");
        vexin=new JButton("CONVEX MIRROR");
        formulas=new JButton("SIGN COVENTIONS AND MIRROR FORMULA");
        intro=new JButton("INTRODUCTION");
        setLayout(null);
        setSize( Toolkit.getDefaultToolkit().getScreenSize().width,60);
        setResizable(false);
        intro.setBounds(0,0,this.getWidth()/4,10);
        vexin.setBounds(this.getWidth()/4,0,this.getWidth()/4,10);
        cavein.setBounds(this.getWidth()/2,0,this.getWidth()/4,10);
        formulas.setBounds(3*this.getWidth()/4,0,this.getWidth()/4,10);
        cavein.setFocusable(false);
        vexin.setFocusable(false);
        formulas.setFocusable(false);
        intro.setFocusable(false);
        add(cavein);
        add(vexin);
        add(intro);
        add(formulas);

    }
    void buttons(MainFrame obj){
        cavein.removeActionListener(obj.me);
        vexin.removeActionListener(obj.me);
        formulas.removeActionListener(obj.me);
        intro.removeActionListener(obj.me);
        
        cavein.addActionListener(obj.me);
        vexin.addActionListener(obj.me);
        formulas.addActionListener(obj.me);
        intro.addActionListener(obj.me);

}
    void buttons2(FrontPage obj){
        cavein.removeActionListener(obj.me);
        vexin.removeActionListener(obj.me);
        formulas.removeActionListener(obj.me);
        intro.removeActionListener(obj.me);

        cavein.setText("REFRACTION");
        vexin.setText("REFLECTION");
        intro.setText("RAY OPTICS");
        formulas.setText("TERMINOLOGY");
        cavein.addActionListener(obj.me);
        vexin.addActionListener(obj.me);
        formulas.addActionListener(obj.me);
        intro.addActionListener(obj.me);

    }
}