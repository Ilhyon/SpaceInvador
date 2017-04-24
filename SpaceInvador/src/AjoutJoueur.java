import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Classe qui permet de faire une fenêtre pour ajouter un joueur. Elle est créée de la même façon que 
 * "ajout personne" du TP 5. */
public class AjoutJoueur extends JDialog implements ActionListener{
	JButton fermer, afficher;
	JTextField champPseudo;
	JLabel labelPseudo;
	Joueur j;
	
	public AjoutJoueur(JFrame f, Joueur j)
	{
		super(f, "Nouveau joueur", true);
		this.j=j;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,1));
				
		JPanel panelPseudo= new JPanel();
		panelPseudo.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelPseudo = new JLabel("Pseudo du joueur :");
		panelPseudo.add(labelPseudo);
		champPseudo = new JTextField(20);
		panelPseudo.add(champPseudo);
		c.add(panelPseudo);
		
		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER));
		fermer = new JButton("Fermer");
		fermer.addActionListener(this);
		panelBoutons.add(fermer);
		afficher = new JButton("Ajouter");
		afficher.addActionListener(this);
		panelBoutons.add(afficher);
		c.add(panelBoutons);
				
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Fermer"))
		{
			this.dispose();
		}
		else if(e.getActionCommand().equals("Ajouter"))
		{
			j.pseudo = champPseudo.getText();
			j.score = 0;
			this.dispose();
			
		}
	}
}
