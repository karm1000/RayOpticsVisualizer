package MainMirror;

import java.io.*;
import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import java.net.URL;

import Run.FrontPage;

class Info extends JFrame {
    JTextPane ta;
    JScrollPane js;
    ChangeSlide cs;
    FileReader fin;
    Font f;
    BufferedReader br;
    FileInputStream fs;
    FileOutputStream fo;
    SimpleAttributeSet sat;
    URL image_url;
    URL file_url = MyEvent2.class.getResource("/resources1/intro.txt");
    String sa = "", filename = "/resources1/intro.txt";
    MainFrame obj;
    Document doc;
    char key;

    Info() {

        ta = new JTextPane();
        ta.setEditable(false);
        js = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sat = new SimpleAttributeSet();
        doc = ta.getStyledDocument();
        cs = new ChangeSlide();

        setVisible(true);
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width - 50, Toolkit.getDefaultToolkit().getScreenSize().height - 100);
        setResizable(false);
        add(js);
        cs.setLocation(0, this.getHeight() + 5);
        cs.setVisible(true);


        ta.setForeground(Color.BLACK);

    }

    void getJob(MainFrame obj) {
        cs.buttons(obj);
        job();
    }

    void getJob2(FrontPage obj) {
        cs.buttons2(obj);
        job();
    }

    void job() {


//ta.setBounds(0,0,(int)obj.d1.getWidth(),(int)obj.d1.getHeight());
        try {
            //System.out.println(filename);
//   fin=new FileReader(file_url.getFile());
            br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename)));
            sa = "";
            doc = ta.getStyledDocument();
            while (sa != null) {
                sa = br.readLine();

                if (sa != null) {
                    key = sa.charAt(0);
                    switch (key) {
                        case 'a': {
                            f = new Font("MV Boli", Font.BOLD, 15);
                            setFont(f);
                            sa = sa.substring(1);
                            doc.insertString(doc.getLength(), sa + "\n", sat);
                            break;
                        }
                        case 'b': {
                            sa = sa.substring(1);
                            doc.insertString(doc.getLength(), sa + "\n", sat);
                            break;
                        }
                        case 'c': {
                            f = new Font("Arial", Font.BOLD, 50);
                            setFont(f);
                            sa = sa.substring(1);
                            doc.insertString(doc.getLength(), sa + "\n", sat);
                            break;
                        }
                        case 's': {
                            doc.insertString(doc.getLength(), "\n", sat);
                            break;
                        }
                        case 'I': {
                            image_url = MyEvent2.class.getResource("/resources1/img" + Character.toString(sa.charAt(1)) + ".png");

                            ta.insertIcon(new ImageIcon(image_url));
                            break;
                        }


                        default:
                            break;
                    }
                }

            }
//fin.close();
            br.close();
            getContentPane().add(js);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO Auto-generated catch block
            e.printStackTrace();

        }


    }
}