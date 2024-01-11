package MainLens;

import java.io.*;
import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import java.net.URL;

import MainMirror.MyEvent2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import Run.FrontPage;

class Info extends JFrame {
    JTextPane ta;
    JScrollPane js;

    FileReader fin;
    Font f;
    BufferedReader br;
    FileInputStream fs;
    FileOutputStream fo;
    SimpleAttributeSet sat;
    String sa = "", filename = "/resources2/INTRODUCTION.txt";

    Document doc;
    char key;

    Info() {

        ta = new JTextPane();
        ta.setEditable(false);
        js = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sat = new SimpleAttributeSet();
        doc = ta.getStyledDocument();


        setVisible(true);
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width - 50, Toolkit.getDefaultToolkit().getScreenSize().height - 100);
        setResizable(false);
        add(js);


        ta.setForeground(Color.BLACK);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                Events.cs.setVisible(false);
                Events.cs.dispose();
            }
        });

    }

    void job() {


        try {
            System.out.println(filename);
//            fin = new FileReader(filename);
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


                        case 's': {
                            doc.insertString(doc.getLength(), "\n", sat);
                            break;
                        }
                        case 'I': {
                        	URL image_url = MyEvent2.class.getResource("/resources2/img" + Character.toString(sa.charAt(1)) + ".png");
                            ta.insertIcon(new ImageIcon(image_url));
                            break;
                        }


                        default:
                            break;
                    }
                }

            }
//            fin.close();
            br.close();
            getContentPane().add(js);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO Auto-generated catch block
            e.printStackTrace();

        }


    }

}