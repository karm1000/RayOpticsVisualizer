package MainLens;

import Run.FrontPage;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Toolkit;
class ChangeSlide extends JFrame
{

    JButton cavein,vexin,formulas,intro;
    ChangeSlide(Events e)
    {
      
        cavein=new JButton("CONVEX LENS");
        vexin=new JButton("CONCAVE LENS");
        formulas=new JButton("SIGN CONVENTIONS AND LENS FORMULA");
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
        cavein.addActionListener(e);
        vexin.addActionListener(e);
        formulas.addActionListener(e);
        intro.addActionListener(e);
        add(cavein);
        add(vexin);
        add(intro);
        add(formulas);
        setVisible(true);

    }
   
}