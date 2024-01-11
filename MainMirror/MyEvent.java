package MainMirror;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;

//import java.awt.event.MouseEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.JLabel;
import Run.FrontPage;


class MyEvent implements ActionListener, ChangeListener,MouseMotionListener {
	MainFrame mf;
	JLabel l1;
	Info in;
	URL concave_url,convex_url,sign_url,intro_url;
	
	MyEvent(MainFrame mf) {
		this.mf = mf;
		l1=new JLabel();
		this.mf.add(l1);
	}
	
	
	public void stateChanged(ChangeEvent e) {
		try {
			if(e.getSource() == mf.height || e.getSource() == mf.distance) {
				mf.w.modify(mf,1);
				mf.w.actionMethod();
				//System.out.print(mf.w);
				mf.th.run();
			}
			else if (e.getSource() == mf.top.focal) {
				mf.w.modify(mf, 1);
				mf.w.actionMethod();
				//System.out.println(mf.w);
				mf.th.run();
			}
		} catch(NumberFormatException nfe) {
			MyException1 me1 = new MyException1();
			me1.numberOnly();
			//System.out.println("only integers ...");
		  }
		  catch(MyException1 me1) {
			me1.negativeDistance();
			//System.out.println("only negative distance ...");
		  }
	}
	
	public void actionPerformed(ActionEvent e) {
		mf.th1.run();
		try {
			
			if (e.getSource() == mf.top.reset || e.getSource() == mf.top.u_tf || e.getSource() == mf.top.ho_tf) {
				System.out.println("f = " + mf.f);
				
				mf.w.modify(mf, 2);
				if(mf.f!=mf.u)
				mf.w.actionMethod();
				//System.out.println(mf.w);
				//mf.top.helper();
			}
			else if(e.getSource() == mf.top.exit) {
				System.exit(0);
			}
			else if(e.getSource() == mf.top.back) {
				//remaining ..........
				System.out.println("BACK ...");
				mf.dispose();
				new FrontPage();
			}
			else if (e.getSource() == mf.top.swap) {
				if(mf.top.swap.getText() == "CONCAVE MIRROR") {
					mf.top.title.setText("CONCAVE MIRROR");
					mf.top.swap.setText("CONVEX MIRROR");
				}
				else if(mf.top.swap.getText() == "CONVEX MIRROR") {
					mf.top.title.setText("CONVEX MIRROR");
					mf.top.swap.setText("CONCAVE MIRROR");
				}
				mf.w.modify(mf, 3);
				mf.w.actionMethod();
			
			}
			else if(e.getSource()==mf.top.info  )
			{
				in=new Info();
				in.getJob(mf);
			}
			else if(e.getSource()==in.cs.cavein)
			{
				concave_url = MainFrame.class.getResource("/resources1/concave.txt");
				in.cs.dispose();
				in.dispose();
				in=new Info();
				in.filename = "/resources1/concave.txt";
				in.getJob(mf);
				
			}
			else if(e.getSource()==in.cs.vexin)
			{
				convex_url = MainFrame.class.getResource("/resources1/convex.txt");
				in.cs.dispose();
				in.dispose();
				in=new Info();
				in.filename = "/resources1/convex.txt";
				in.getJob(mf);
				
			//	mf.top.in.ta=new JTextPane();
		
			}
			else if(e.getSource()==in.cs.formulas)
			{
				sign_url = MainFrame.class.getResource("/resources1/sign.txt");
				in.cs.dispose();
				in.dispose();
				in=new Info();
				in.filename = "/resources1/sign.txt";
				
			in.getJob(mf);
				
			}
			else if(e.getSource()==in.cs.intro)
			{
				intro_url = MainFrame.class.getResource("/resources1/intro.txt");
				in.cs.dispose();
				in.dispose();
				in=new Info();
				in.filename = "/resources1/intro.txt";
		
			in.getJob(mf);
				
			}
			
		} catch(NumberFormatException nfe) {
			MyException1 me1 = new MyException1();
			me1.numberOnly();
			//System.out.println("only integers ...");
		  }
		  catch(MyException1 me1) {
			if(me1.flag == 1) me1.negativeDistance();
			else if(me1.flag == 2) me1.outOfRange();
			//System.out.println("only negative distance ...");
		  }
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println(e.getX()+"  "+( mf.graphics.x2 + (int) (mf.scaleX * mf.f)+80)+" "+e.getY()+" "+(mf.d1.getHeight()/4+mf.graphics.y));
		// TODO Auto-generated method stub
		if(Math.abs(e.getX()-(mf.graphics.objx+80))<=20 && (e.getY()-(mf.d1.getHeight()/4+mf.graphics.y))<Math.abs(mf.graphics.y-mf.graphics.objy)+5 && Math.abs(e.getY()-(mf.d1.getHeight()/4+mf.graphics.objy))<Math.abs(mf.graphics.y-mf.graphics.objy)+5)
		{
			l1.setVisible(true);
	
			l1.setText("OBJECT");
			l1.setBounds(e.getX()+5,e.getY()+5,200,10);
			//l1.setVisible(false);
		}
			else if(Math.abs(e.getX()-(mf.graphics.imgx+80))<=20&& (e.getY()-(mf.d1.getHeight()/4+mf.graphics.y))<Math.abs(mf.graphics.y-mf.graphics.imgy)+5 && (e.getY()-(mf.d1.getHeight()/4+mf.graphics.imgy))<Math.abs(mf.graphics.y-mf.graphics.objy)+5)
			{
				l1.setVisible(true);
		
				l1.setText("IMAGE");
				l1.setBounds(e.getX()+5,e.getY()+5,200,10);
				//l1.setVisible(false);
			}
			else if(Math.abs(e.getX()-(mf.graphics.x2+80))<=15)
			{
				l1.setVisible(true);
				l1.setText("Mirror");
				l1.setBounds(e.getX()+5,e.getY()+5,200,10);
			

			}
			else if(Math.abs(e.getX()-( mf.graphics.x2 + (int) (mf.scaleX * mf.f)+80))<=15 && Math.abs(e.getY()-(mf.d1.getHeight()/4+mf.graphics.y+27))<=10)
			{
				l1.setVisible(true);
		
				l1.setText("FOCUS");
				l1.setBounds(e.getX()+5,e.getY()+5,200,10);
			

			}
			else if(Math.abs(e.getX()-( mf.graphics.x2 + (int) (mf.scaleX *2f* mf.f)+80))<=15 && Math.abs(e.getY()-(mf.d1.getHeight()/4+mf.graphics.y+27))<=10)
			{
				l1.setVisible(true);
		
				l1.setText("OPTICAL CENTRE");
				l1.setBounds(e.getX()+5,e.getY()+5,200,10);
			

			}
			
			else{
				l1.setVisible(false);
			}
		
	}
}