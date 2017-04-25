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
public class AjoutJoueur extends JFrame implements ActionListener{
	
	/* Attribut de la classe*/
	JButton fermer, afficher;
	JTextField champPseudo;
	JLabel labelPseudo, labelPhrase, labelBienvenue;
	Joueur j;
	InterfaceJeu jeu;
	
	public AjoutJoueur()
	{
		super("Space Invadors !");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// pour que si on ferme cette fenêtre on ne quitte pas tout le jeu
		
		/* Creation du container avec 2 lignes : une pour le champ et le label et 
		 * l'autre pour les boutons */
		Container c = getContentPane();
		c.setLayout(new GridLayout(4,1));
		
		/* Creation de la ligne qui contiendra les champs du pseudo (un bouton et un jlabel*/
		JPanel panelPseudo= new JPanel();
		panelPseudo.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelPseudo = new JLabel("Pseudo du joueur :");
		panelPseudo.add(labelPseudo);
		champPseudo = new JTextField(20);
		panelPseudo.add(champPseudo);
		
		/* Cretation des deux lignes qui contiendront un petit message de bienvenue et une phrase.*/
		JPanel panelBienvenue = new JPanel();
		panelBienvenue.setLayout(new FlowLayout(FlowLayout.CENTER));
		labelBienvenue = new JLabel("Bienvenue dans le jeu Space Invadors !");
		panelBienvenue.add(labelBienvenue);
		
		JPanel panelPhrase = new JPanel();
		panelPhrase.setLayout(new FlowLayout(FlowLayout.CENTER));
		labelPhrase = new JLabel("Pour jouer, veuillez rentrer votre pseudo si dessous.");
		panelPhrase.add(labelPhrase);
		
		/* Création de la ligne qui contiendra les boutons de la fenetre (un pour fermer la fenêtre et l'autre
		 * pour ajouter un joueur
		 */
		JPanel panelBoutons = new JPanel();
		panelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER));
		fermer = new JButton("Fermer");
		fermer.addActionListener(this);
		panelBoutons.add(fermer);
		afficher = new JButton("Ajouter");
		afficher.addActionListener(this);
		panelBoutons.add(afficher);
		
		c.add(panelBienvenue);
		c.add(panelPhrase);
		c.add(panelPseudo);
		c.add(panelBoutons);
		
		jeu = new InterfaceJeu();
		j = new Joueur();
		
		pack();
		setVisible(true);
	}
	
	/* Pour gere les action sur les deux boutons */
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
			jeu.pseudo.setText(j.pseudo);
			jeu.score.setText("0");
			this.dispose();
			
		}
	}
}
