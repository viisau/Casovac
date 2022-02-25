import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class BinarneHodiny extends JFrame implements ActionListener{
private JLabel hod;
private JLabel min;
private JLabel sek;
public BinarneHodiny() {
	setSize(300,400);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new  GridBagLayout());
	GridBagConstraints gbc=new GridBagConstraints();
	hod = new JLabel();
	min = new JLabel();
	sek = new JLabel();
	gbc.gridy=0;
	add(hod,gbc);
	gbc.gridy++;
	add(min,gbc);
	gbc.gridy++;
	add(sek,gbc);
	Timer tim=new Timer(1000, this);
	tim.start();
	actionPerformed(null);
}
	public static void main(String[] args) {
new BinarneHodiny().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int h=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int m=Calendar.getInstance().get(Calendar.MINUTE);
		int s=Calendar.getInstance().get(Calendar.SECOND);
		System.out.println(h+":"+m+":"+s);
		String dh=Integer.toBinaryString(h);
		String dm=Integer.toBinaryString(m);
		String ds=Integer.toBinaryString(s);
		dh=doplnNuly(dh);
		hod.setText(dh);
		dm=doplnNuly(dm);
		min.setText(dm);
		ds=doplnNuly(ds);
		sek.setText(ds);
	}
	private String doplnNuly(String str) {
		while (str.length()<6)str="0"+str;
		return str;
	}

}
