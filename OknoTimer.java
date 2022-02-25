import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class OknoTimer extends JFrame implements ActionListener{
private Timer tim;
private JLabel l;
public OknoTimer() {
	// TODO Auto-generated constructor stub
	setSize(500,400);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new GridBagLayout());
	GridBagConstraints gbc=new GridBagConstraints();
	l = new JLabel("Nech zije online vyucovanie");
	l.setForeground(Color.blue);
	l.setFont(l.getFont().deriveFont(20f));
	l.setFont(l.getFont().deriveFont(Font.BOLD));
	//cely font
	//l.setFont(new Font("Arial",Font.ITALIC,35));
	add(l,gbc);
	tim = new Timer(500, this);
	tim.start();

	tim.addActionListener(this);
	
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OknoTimer().setVisible(true);;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		l.setVisible(!l.isVisible());
	}

}
