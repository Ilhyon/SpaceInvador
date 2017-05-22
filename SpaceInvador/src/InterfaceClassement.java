import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class InterfaceClassement extends JFrame implements ActionListener
{
	Classement classement;
	JTable tableClassement;
	JButton ajoutJ, recommencer;
	InterfaceJeu jeu;
	
	public InterfaceClassement(InterfaceJeu jeu) {
		super("Classement");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.jeu = jeu;
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		classement = new Classement(jeu.l);
		classement.fireTableDataChanged();
		tableClassement = new JTable(classement);
		c.add(tableClassement);
		
		recommencer = new JButton("Recommencer !");
		recommencer.addActionListener(this);
		ajoutJ = new JButton("Ajouter un nouveau Joueur");
		ajoutJ.addActionListener(this);
		JPanel panelAffichage = new JPanel();
		panelAffichage.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelAffichage.add(recommencer);
		panelAffichage.add(ajoutJ);
		c.add(panelAffichage,BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Recommencer !"))
		{
			jeu.reset(1);
			dispose();
			jeu.startTimer();
		}
		
		else if (e.getActionCommand().equals("Ajouter un nouveau Joueur"))
		{
			jeu.reset(2);
			dispose();
			new AjoutJoueur(jeu);
		}
		
	}

}
