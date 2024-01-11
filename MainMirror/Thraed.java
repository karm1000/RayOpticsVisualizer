package MainMirror;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Thraed implements Runnable {
	Clip c;

	public Thraed() {
		URL url = MainFrame.class.getResource("/resources1/crank2.wav");
		File f = new File(url.getFile());
		try {
			AudioInputStream ad = AudioSystem.getAudioInputStream(url);

			c = AudioSystem.getClip();
			c.open(ad);
			Thread th = new Thread(this);
			
			th.start();
			
		} catch (Exception e) {
			System.out.println("nirasha" + e.getMessage());
		}
	}

	public void run() {
		c.start();
		try {
			c.setMicrosecondPosition(80000);

			Thread.sleep(10);
			c.stop();
			c.setMicrosecondPosition(80000);

			//System.out.println("position" + c.getLongFramePosition() + "len :" + c.getFrameLength());

		//	c.setMicrosecondPosition(20);

		} catch (Exception e) {
			System.out.println("Error niche");
		}
	}

}
