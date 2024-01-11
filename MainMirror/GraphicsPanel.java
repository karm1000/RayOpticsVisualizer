package MainMirror;

import javax.swing.JPanel;

import java.awt.Dimension;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class GraphicsPanel extends JPanel {
	MainFrame obj;
	int x1, x2, y, temp, objx, objy, imgx, imgy, xpts[], ypts[];
	Stroke dotted;

	GraphicsPanel(MainFrame obj) {
		this.obj = obj;

		this.setBackground(Color.white);
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(obj.d1.width - 80, 3 * obj.d1.height / 4 - 80));
		this.setVisible(true);
		dotted = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 10 }, 0);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		this.x1 = 100;
		this.x2 = this.getWidth() - 100;
		this.y = this.getHeight() / 2;

		g2d.setPaint(Color.black);
		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(x1, y, x2, y);

		if (this.obj.f > 0) {
			this.x2 = (this.getWidth()) / 2;

			g2d.setStroke(new BasicStroke(8));
			g2d.setPaint(Color.black);
			g2d.drawArc(x2 - 3, 0, 40, this.getHeight(), 90, 180);
			g2d.fillOval((int) (x2 + (obj.f * obj.scaleX) - 4), y - 4, 8, 8);
			g2d.fillOval((int) (x2 + (2f * obj.f * obj.scaleX) - 6), y - 6, 12, 12);
			g2d.setStroke(new BasicStroke(3));
			g2d.setPaint(Color.black);

		} else if (this.obj.f < 0) {
			if (obj.u <= obj.f)
				this.x2 = this.getWidth() - 100;
			else
				this.x2 = (this.getWidth()) / 2;

			g2d.setStroke(new BasicStroke(15));
			g2d.setPaint(Color.black);
			if (obj.u < obj.f)
				g2d.drawArc(x2 - (2 * 20)+2, 0, 40, this.getHeight(), 270, 180);
			else {
				g2d.setStroke(new BasicStroke(15));

				g2d.drawArc(x2 - (2 * 20)+5 , 0, 40, this.getHeight(), 270, 180);
			}
			temp = x2 + (int) (obj.scaleX * obj.f);
			g2d.fillOval(temp - 8, (this.getHeight() - 16) / 2, 16, 16);

			temp = x2 + (2 * (int) (obj.scaleX * obj.f));
			g2d.fillOval(temp - 8, (this.getHeight() - 16) / 2, 16, 16);

			g2d.setStroke(new BasicStroke(3));
			g2d.setPaint(Color.black);
		}
		objx = x2 + (int) (obj.scaleX * obj.u);
		objy = y - (int) (obj.scaleY * obj.ho);
		g2d.drawLine(objx, objy, objx, y);

		imgx = x2 + (int) (obj.scaleX * obj.v);
		imgy = y - (int) (obj.scaleY * obj.hi);
		g2d.setPaint(Color.black);
		g2d.drawLine(imgx, imgy, imgx, y);

		g2d.setStroke(new BasicStroke(2));

		g2d.drawLine(objx, objy, x2, y);
		g2d.drawLine(objx, objy, x2, objy);
		if (obj.v > 0)
		{	
				g2d.drawLine(x2,objy,0,y+(int)((objy-y)*(x2 + (obj.f * obj.scaleX))/ (obj.f * obj.scaleX)));
				g2d.drawLine(x2,y,0,y+(int)((y-objy)*x2/(x2 -objx)));
				g2d.setStroke(dotted);
		}
		g2d.drawLine(imgx, imgy, x2, y);
		g2d.drawLine(imgx, imgy, x2, objy);

		xpts = new int[3];
		ypts = new int[3];

		g2d.setStroke(new BasicStroke(3));

		xpts[0] = objx;
		xpts[1] = objx - 7;
		xpts[2] = objx + 7;

		if (obj.ho > 0) {
			ypts[0] = objy;
			ypts[1] = objy + 5;
			ypts[2] = objy + 5;
			g2d.drawPolygon(xpts, ypts, 3);
		} else if (obj.ho < 0) {
			ypts[0] = objy;
			ypts[1] = objy - 5;
			ypts[2] = objy - 5;
		}
		g2d.drawPolygon(xpts, ypts, 3);

		xpts[0] = imgx;
		xpts[1] = imgx - 7;
		xpts[2] = imgx + 7;

		if (obj.hi > 0) {
			ypts[0] = imgy;
			ypts[1] = imgy + 5;
			ypts[2] = imgy + 5;
		} else {
			ypts[0] = imgy;
			ypts[1] = imgy - 5;
			ypts[2] = imgy - 5;
		}
		g2d.drawPolygon(xpts, ypts, 3);

	}
}