import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Semafor extends JFrame implements ActionListener {
	private int pocet;
	private Timer t;
	private Graphics g;
	private int x;
	private int y;
	private int p;
	private Timer tA;

	public Semafor() {
		// TODO Auto-generated constructor stub
		setSize(800, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		BufferedImage im = new BufferedImage(700, 400,
				BufferedImage.TYPE_INT_RGB);
		g = im.getGraphics();
		JLabel l = new JLabel(new ImageIcon(im));
		add(l);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 700, 400);
		g.setColor(Color.BLACK);
		g.fillRect(600, 50, 50, 150);
		g.setColor(Color.BLUE);
		g.fillRect(0, 250, 50, 30);
		t = new Timer(1500, this);
		t.start();
		tA = new Timer(300, this);
		tA.start();
		actionPerformed(new ActionEvent(t, ActionEvent.ACTION_PERFORMED, ""));
		pocet = 0;
		repaint();
		x = 0;
		y = 250;
		p = 10;
		g.setColor(Color.GREEN);
		g.drawLine(350, 0, 350, 700);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Semafor().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == tA) {
			g.setColor(Color.WHITE);
			kresliAuto(x, y, 50, 30);
			x += p;
			g.setColor(Color.BLUE);
			kresliAuto(x, y, 50, 30);
		}
		if (e.getSource() == t) {
			pocet++;
			if (pocet % 4 == 0) {
				t.setDelay(1500);
				g.setColor(Color.RED);
				g.fillOval(600, 50, 50, 50);
				g.setColor(Color.BLACK);
				g.fillOval(600, 100, 50, 50);
				g.setColor(Color.BLACK);
				g.fillOval(600, 150, 50, 50);
				if (x + 50 >= 350 && x+50<=600) {
					tA.stop();
				}
			}
			if (pocet % 4 == 1) {
				t.setDelay(1500);
				g.setColor(Color.RED);
				g.fillOval(600, 50, 50, 50);
				g.setColor(Color.ORANGE);
				g.fillOval(600, 100, 50, 50);
				g.setColor(Color.BLACK);
				g.fillOval(600, 150, 50, 50);
				if (x + 50 >= 350 && x+50<=600) {
					tA.stop();
				}
			}
			if (pocet % 4 == 2) {
				t.setDelay(2000);
				g.setColor(Color.BLACK);
				g.fillOval(600, 50, 50, 50);
				g.setColor(Color.BLACK);
				g.fillOval(600, 100, 50, 50);
				g.setColor(Color.GREEN);
				g.fillOval(600, 150, 50, 50);
				if (x + 50 >= 350 && x+50<=600) {
					tA.start();
				}
			}
			if (pocet % 4 == 3) {
				t.setDelay(1500);
				g.setColor(Color.BLACK);
				g.fillOval(600, 50, 50, 50);
				g.setColor(Color.ORANGE);
				g.fillOval(600, 100, 50, 50);
				g.setColor(Color.BLACK);
				g.fillOval(600, 150, 50, 50);
				if (x + 50 >= 350 && x+50<=600) {
					tA.stop();
				}
			}
			g.setColor(Color.GREEN);
			g.drawLine(350, 0, 350, 700);
			repaint();
		}
	}

	private void kresliAuto(int x2, int y2, int i, int j) {
		// TODO Auto-generated method stub
		g.fillRect(x, y, 50, 30);
		repaint();
	}

}
