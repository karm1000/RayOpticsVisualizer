package MainLens;

import MainLens.Exceptions.NegativesNotAllowedException;
import MainLens.Exceptions.OutOfRangeException;
import MainLens.GeometricalOptics.Lens.Lens;
import MainMirror.MainFrame;
import MainMirror.MyException1;
import MainMirror.Thraed;
import MainMirror.Thraed1;
import Run.FrontPage;

//import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Events implements ActionListener, ChangeListener, KeyListener, MouseListener,MouseMotionListener {
    Visualizer v;
    Info in;
    MyException1 me = new MyException1();
    static ChangeSlide cs;
//    Timer timer;
//    public static boolean go = true;
//    public boolean flag = true;
    public Events(Visualizer visualizer){
        this.v = visualizer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==v.concaveButton){
            v.isConcaveRunning = true;
            v.concaveButton.setVisible(false);
            v.concaveButton.setEnabled(false);
            v.convexButton.setEnabled(true);
            v.convexButton.setVisible(true);

            v.p.setLens(new Lens(-30));
            v.p.getLens().setR((-1)*(v.p.getLens().getR()));

            v.frame.panel.cur_slider.setMinimum(-100);
            v.frame.panel.cur_slider.setMaximum(0);
            v.frame.panel.cur_slider.setValue(-60);

            v.calculationPanel.focalLengthSlider.setMinimum(-50);
            v.calculationPanel.focalLengthSlider.setMaximum(0);
            v.calculationPanel.focalLengthSlider.setValue(-30);
            v.calculationPanel.setDetails();
        }
        else if(e.getSource()==v.infoButton){
            in=new Info();
            cs=new ChangeSlide(this);
            cs.setLocation(0,in.getHeight());
            in.job();
        }
        else if(e.getSource()==v.convexButton){
            v.isConcaveRunning = false;
            v.convexButton.setVisible(false);
            v.convexButton.setEnabled(false);
            v.concaveButton.setEnabled(true);
            v.concaveButton.setVisible(true);

            v.p.setLens(new Lens(30));
            v.p.getLens().setR((-1)*(v.p.getLens().getR()));

            v.frame.panel.cur_slider.setMinimum(0);
            v.frame.panel.cur_slider.setMaximum(100);
            v.frame.panel.cur_slider.setValue(60);

            v.calculationPanel.focalLengthSlider.setMinimum(0);
            v.calculationPanel.focalLengthSlider.setMaximum(50);
            v.calculationPanel.focalLengthSlider.setValue(30);
            v.calculationPanel.setDetails();
        } else if (e.getSource()==v.velocityButton) {
           v.allOptionContainer.cl.last(v.allOptionContainer);
        } else if (e.getSource()==v.goBackVC) {
           v.allOptionContainer.cl.first(v.allOptionContainer);
        } else if (e.getSource()==v.setB) {
            v.setB.setVisible(false);
            v.stopB.setVisible(true);
            double vo = Double.parseDouble(v.velObj.textField.getText());
            v.p.setObjVelo(vo);
            v.velImg.setTextFieldText(""+v.p.getImage().getVelocity());
//            v.velocityThread = new VelocityThread(v);
            v.velocityTask = new VelocityTask(v);
        } else if (e.getSource()==v.stopB) {
            v.stopB.setVisible(false);
            v.setB.setVisible(true);
//            v.velocityThread.interrupt();
            v.velocityTask.timer.cancel();
        } else if(e.getSource()==v.calculationPanel.objectDistance.textField){
            try {
                double temp = Double.parseDouble(v.calculationPanel.objectDistance.textField.getText());
                if(Math.abs(temp)>v.limitOfScale ){
                    JOptionPane.showMessageDialog(null,"This Application has some limitations.\nSo beyond 10000 limit Image transformation can't be shown\n but calculations would be available","Limitation",JOptionPane.PLAIN_MESSAGE);
                }
                v.p.setObjectDistance(temp);
            }catch (NumberFormatException exc){
                me.numberOnly();
            }catch (Exception exc){
                System.out.println(exc);
            }
            v.calculationPanel.setDetails();
        }
        else if(e.getSource()==v.calculationPanel.objectHeight.textField){
            try {
                double temp = Double.parseDouble(v.calculationPanel.objectHeight.textField.getText());
                if(Math.abs(temp)>v.limitOfScale){
                    JOptionPane.showMessageDialog(null,"This Application has some limitations.\nSo beyond 10000 limit Image transformation can't be shown\n but calculations would be available","Limitation",JOptionPane.PLAIN_MESSAGE);
                }
                v.p.setObjectHeight(temp);
            }catch (NumberFormatException exc){
                me.numberOnly();
            }catch (Exception exc){
                System.out.println(exc);
            }
            v.calculationPanel.setDetails();
        }
        else if(e.getSource()==v.calculationPanel.focalLength.textField){
            try {
                double temp = Double.parseDouble(v.calculationPanel.focalLength.textField.getText());
                if(Math.abs(temp)>v.limitOfScale ){
                    JOptionPane.showMessageDialog(null,"This Application has some limitations.\nSo beyond 10000 limit Image transformation can't be shown\n but calculations would be available","Limitation",JOptionPane.PLAIN_MESSAGE);
                }
                v.p.setLens(new Lens(temp));
            }catch (NumberFormatException exc){
                me.numberOnly();
            }catch (Exception exc){
                System.out.println(exc);
            }
            v.calculationPanel.setDetails();
        } else if(e.getSource()==v.frame.panel.button){
            try {
                v.frame.panel.cur_slider.setValue((int) Double.parseDouble((v.frame.panel.radius_of_cur.textField.getText())));
                double temp[]={Double.parseDouble(v.frame.panel.radius_of_cur.textField.getText()), Double.parseDouble(v.frame.panel.ref_index_lens.textField.getText()), Double.parseDouble(v.frame.panel.ref_index_medium.textField.getText())};
                if(temp[1]<0 || temp[2]<0){
                    throw new NegativesNotAllowedException();
                }
                v.p.setLens(new Lens(temp[0],temp[1],temp[2]));
                v.p.display();
                v.frame.setVisible(false);
            }catch (NegativesNotAllowedException exc){
                JOptionPane.showMessageDialog(null,"Negative Number is not allowed","Warning",JOptionPane.WARNING_MESSAGE);
            }catch (NumberFormatException exc){
                me.numberOnly();
            }catch (Exception exc){
                System.out.println(exc);
            }
            v.calculationPanel.setDetails();
        }else if(e.getSource()==v.setScaleButton){
            v.g_panel.setScale();
            v.setSlider();
            v.g_panel.repaint();
        } else if (e.getSource()==v.resetButton) {
            v.resetScale();
            v.setSliderLabel();
            v.p.setObjectDistance(-50);
            v.p.setObjectHeight(50);
            v.p.setLens(new Lens((v.isConcaveRunning?-30:30)));
            v.calculationPanel.setDetails();
            v.g_panel.repaint();
        } else if(e.getSource() == v.exitButton) {
            System.exit(0);
        } else if (e.getSource()==v.backButton) {
            v.dispose();
            new FrontPage();
        } else if(e.getSource() == v.frame.panel.ref_index_lens.textField) {
            /*try {
                double temp[]={Double.parseDouble(v.frame.panel.radius_of_cur.textField.getText()), Double.parseDouble(v.frame.panel.ref_index_lens.textField.getText()), Double.parseDouble(v.frame.panel.ref_index_medium.textField.getText())};
                if(temp[1]<0 || temp[2]<0){
                    throw new NegativesNotAllowedException();
                }
                v.p.setLens(new Lens(temp[0],temp[1],temp[2]));
            }catch (NegativesNotAllowedException exc){
                JOptionPane.showMessageDialog(null,"Negative Number is not allowed","Warning",JOptionPane.WARNING_MESSAGE);
            } catch (NumberFormatException exc){
                me.numberOnly();
            }catch (Exception exc){
                System.out.println(exc);
            }
            v.calculationPanel.setDetails();*/
        }
        else if(e.getSource() == v.frame.panel.ref_index_medium.textField) {
            /*try {
                double temp[]={Double.parseDouble(v.frame.panel.radius_of_cur.textField.getText()), Double.parseDouble(v.frame.panel.ref_index_lens.textField.getText()), Double.parseDouble(v.frame.panel.ref_index_medium.textField.getText())};
                if(temp[1]<0 || temp[2]<0){
                    throw new NegativesNotAllowedException();
                }
                v.p.setLens(new Lens(temp[0],temp[1],temp[2]));
            }catch (NegativesNotAllowedException exc){
                JOptionPane.showMessageDialog(null,"Negative Number is not allowed","Warning",JOptionPane.WARNING_MESSAGE);
            }catch (NumberFormatException exc){
                me.numberOnly();
            }catch (Exception exc){
                System.out.println(exc);
            }
            v.calculationPanel.setDetails();*/
        }
        else if(e.getSource() == v.frame.panel.radius_of_cur.textField) {
            /*try {
                v.frame.panel.cur_slider.setValue((int) Double.parseDouble((v.frame.panel.radius_of_cur.textField.getText())));
                double temp[]={Double.parseDouble(v.frame.panel.radius_of_cur.textField.getText()), Double.parseDouble(v.frame.panel.ref_index_lens.textField.getText()), Double.parseDouble(v.frame.panel.ref_index_medium.textField.getText())};
                if(temp[1]<0 || temp[2]<0){
                    throw new NegativesNotAllowedException();
                }
                v.p.setLens(new Lens(temp[0],temp[1],temp[2]));
            }catch (NegativesNotAllowedException exc){
                JOptionPane.showMessageDialog(null,"Negative Number is not allowed","Warning",JOptionPane.WARNING_MESSAGE);
            }catch (NumberFormatException exc){
                me.numberOnly();
            }catch (Exception exc){
                System.out.println(exc);
            }
            v.calculationPanel.setDetails();*/
        }else{
            in.setVisible(false);
            in.dispose();
            in=new Info();
            in.filename="/resources2/"+e.getActionCommand()+".txt";
            in.job();
        }
        new Thraed1().run();
    }

    public void stateChanged(ChangeEvent e) {
        if(e.getSource()==v.dis_slider) {
            v.p.setObjectDistance(v.dis_slider.getValue());
            v.g_panel.dis_slider_value=v.dis_slider.getValue();
            v.calculationPanel.setDetails();
//            v.g_panel.repaint();
        }
        else if(e.getSource()==v.height_slider) {
            v.g_panel.height_slider_value=v.height_slider.getValue();
            v.p.setObjectHeight(v.height_slider.getValue());
            v.calculationPanel.setDetails();
//            v.g_panel.repaint();
        }
        else if (e.getSource()==v.calculationPanel.focalLengthSlider){
            v.p.setLens(new Lens(v.calculationPanel.focalLengthSlider.getValue()));
            v.calculationPanel.setDetails();
//            v.g_panel.repaint();
        }else if(e.getSource()==v.frame.panel.cur_slider) {
            v.frame.panel.radius_of_cur.textField.setText(String.valueOf(v.frame.panel.cur_slider.getValue()));
            v.p.setLens(new Lens((double)v.frame.panel.cur_slider.getValue(),Double.parseDouble(v.frame.panel.ref_index_lens.textField.getText()),Double.parseDouble(v.frame.panel.ref_index_medium.textField.getText())));
            v.calculationPanel.setDetails();
        }
        new Thraed().run();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
//        System.out.println(e.getKeyCode());
        if(e.getSource()==v.calculationPanel.objectDistance.textField){
            boolean isChanged = false;
            if(e.getKeyCode()==38){
//                if(v.p.getObject().getDistance()){
                    v.p.setObjectDistance(v.p.getObject().getDistance()+1.0);
                    isChanged = true;
//                }
            }
            else if(e.getKeyCode()==40){
//                if(v.p.getObject().getDistance()){
                    v.p.setObjectDistance(v.p.getObject().getDistance()-1.0);
                    isChanged = true;
//                }
            }
            if(isChanged)
                v.calculationPanel.setDetails();
        }
        else if(e.getSource()==v.calculationPanel.objectHeight.textField){
            boolean isChanged = false;
            if(e.getKeyCode()==38){
//                if(v.p.getObject().getHeight()<v.scaleY){
                    v.p.setObjectHeight(v.p.getObject().getHeight()+1.0);
                    isChanged = true;
//                }
            }
            else if(e.getKeyCode()==40){
//                if(v.p.getObject().getHeight()>-v.scaleY){
                    v.p.setObjectHeight(v.p.getObject().getHeight()-1.0);
                    isChanged = true;
//                }
            }

            if(isChanged)
                v.calculationPanel.setDetails();

        } else if (e.getSource()==v.calculationPanel.focalLength.textField) {
            boolean isChanged = false;
            double f = v.p.getLens().getF();
            if(e.getKeyCode()==38){
                if(v.isConcaveRunning){
                    v.p.setLens(new Lens(f-1));
                    isChanged = true;
                }else {
                    v.p.setLens(new Lens(f+1));
                    isChanged = true;
                }
            }
            else if(e.getKeyCode()==40){
                if(v.isConcaveRunning){
                    if(f+1<=0) {
                        v.p.setLens(new Lens(f + 1));
                        isChanged = true;
                    }
                }else {
                    if(f-1>=0) {
                        v.p.setLens(new Lens(f - 1));
                        isChanged = true;
                    }
                }
            }

            if(isChanged)v.calculationPanel.setDetails();

        }
//        System.out.println("Key Pressed"+e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e){}


    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==v.calculationPanel.focalLength){
            v.calculationPanel.focalLength.label.setForeground(Color.RED);
        }
        if(e.getSource()==v.titlePanel) {
            //            v.titlePanel.setBorder(BorderFactory.createMatteBorder(1,2,1,2,Color.black));
            v.titlePanel.label.setForeground(new Color(0x001BC3));
        }

    }

    public void mouseClicked(MouseEvent e){
        if(e.getSource()==v.calculationPanel.focalLength){
            v.frame.setVisible(true);
        }
        if (e.getSource()==v.titlePanel) {
            v.dispose();
            new MainFrame(-30, -50, 100);
        }
    }
    public void mousePressed(MouseEvent e) {};
    public void mouseReleased(MouseEvent e) {};
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==v.calculationPanel.focalLength){
            v.calculationPanel.focalLength.label.setForeground(Color.BLACK);
        }else if (e.getSource()==v.titlePanel) {
            //            v.titlePanel.setBorder(new EmptyBorder(0,0,0,0));
            v.titlePanel.label.setForeground(new Color(0));
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {


    }
}
