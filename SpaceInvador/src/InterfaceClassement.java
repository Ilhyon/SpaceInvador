import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class InterfaceClassement extends JFrame implements ActionListener
{

	JTabbedPane tableClassement;
	
	public InterfaceClassement() {
		super("Classement");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		tableClassement = new JTabbedPane();
		c.add(new JScrollPane(tableClassement));
		
		pack();
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
