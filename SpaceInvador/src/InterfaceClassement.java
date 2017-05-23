import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

//Cette classe permet de creer l'interface graphique qui contiendra le tableau de classement des joueurs 
public class InterfaceClassement extends JFrame implements ActionListener
{
	Classement classement; // Le classement
	JTable tableClassement; // le tableau de classement
	JButton ajoutJ, recommencer; // Bouton pour demander si on veut recommencer ou ajouter un nouveau joueur
	InterfaceJeu jeu; // notre interface de jeu
	
	// Constructeur
	public InterfaceClassement(InterfaceJeu jeu) {
		super("Classement"); // Titre de la fenêtre
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Comment ça se ferme
		
		this.jeu = jeu;
		Container c = getContentPane(); // creation du container
		c.setLayout(new BorderLayout()); // Utilisation de BorderLayout
		
		classement = new Classement(jeu.l); // Initialisation du classement avec le classement de la listeJoueur 
		classement.fireTableDataChanged(); //Notifie les cellules du tableau qui ont changées
		tableClassement = new JTable(classement); // Initialisation du tableau avec le classement
		c.add(tableClassement); // Ajout au container
		
		recommencer = new JButton("Recommencer !"); // Bouton recommencer
		recommencer.addActionListener(this);
		ajoutJ = new JButton("Ajouter un nouveau Joueur"); // Bouton ajout d'un nouveau joueur
		ajoutJ.addActionListener(this);
		JPanel panelAffichage = new JPanel(); // Creation d'un JPanel pour l'affichage
		panelAffichage.setLayout(new FlowLayout(FlowLayout.CENTER)); // On centre le JPanel
		panelAffichage.add(recommencer); // On ajoute les deux boutons
		panelAffichage.add(ajoutJ);
		c.add(panelAffichage,BorderLayout.SOUTH); // On ajoute le JPanel au container
		
		pack(); // Taille idéale de la fenêtre
		setVisible(true); // Visible
	}

	public void actionPerformed(ActionEvent e) {
		// Si on appuie sur recommencer
		if(e.getActionCommand().equals("Recommencer !"))
		{
			jeu.reset(1);
			dispose();
			Joueur licorne = new Joueur(jeu.selectJoueur().pseudo);
			jeu.l.listeJoueur.add(licorne);
			jeu.startTimer();
		}
		
		// Si on appuie sur ajouter un nouveu joueur
		else if (e.getActionCommand().equals("Ajouter un nouveau Joueur"))
		{
			jeu.reset(2); // Le jeu recommence
			dispose(); // Le tableau de classement se ferme
			new AjoutJoueur(jeu); // La fenêtre permettant d'ajouter un nouveau joueur s'ouvre
		}
	}
}
