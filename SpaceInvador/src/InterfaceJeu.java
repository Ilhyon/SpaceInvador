import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceJeu extends JFrame implements ActionListener
{
	JButton ajoutJoueur;
	JLabel pseudo, niveau, score;
	
	public InterfaceJeu()
	{
		super("Super Space Invador");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(5,1));
		
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}