import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Casovac extends JFrame implements ActionListener {
	private JLabel cislo;
	private JTextField pole;
	private JButton but;
	private JButton start;
	private int p;
	private Timer tim;

	public Casovac() {
		// TODO Auto-generated constructor stub
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 20, 10, 20);
		gbc.gridy = 0;
		cislo = new JLabel("0");
		cislo.setFont(cislo.getFont().deriveFont(40f));
		add(cislo, gbc);
		pole = new JTextField(10);
		add(pole, gbc);
		but = new JButton("Vloz");
		add(but, gbc);
		gbc.gridy++;
		start = new JButton("Start");
		add(start, gbc);
		but.addActionListener(this);
		start.addActionListener(this);
		p = 0;
		tim = new Timer(1000, this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Casovac().setVisible(true);
		;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == but) {
			cislo.setText(pole.getText());
			p = Integer.parseInt(pole.getText());
		}
		if (arg0.getSource() == start)
			tim.start();
		if (arg0.getSource() == tim) {
			p--;
			cislo.setText(Integer.toString(p));
			if (p == 0) {
				tim.stop();
				//JOptionPane.showMessageDialog(this, "BOOOOOOOOM", "Koniec",
					//	JOptionPane.WARNING_MESSAGE);
				JOptionPane.showMessageDialog(this, "", "Koniec",
						JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass()
								.getResource("bomb.jpg")));

				cislo.setText(pole.getText());
				p = Integer.parseInt(pole.getText());

			}
		}

	}

}
