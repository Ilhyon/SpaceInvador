import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	JLabel labelPseudo, labelPhrase, labelBienvenue, labelIcone;
	Joueur peon;
	InterfaceJeu jeu;
	ImageIcon icone;
	
	// Constructeur
	public AjoutJoueur(InterfaceJeu j)
	{
		super("Space Invaders !"); // Titre de la fenêtre
		setDefaultCloseOperation(EXIT_ON_CLOSE);// Pour que si on ferme cette fenêtre on ne quitte pas tout le jeu
		
		
		/* Creation du container avec 5 lignes :
		 * image, bienvenue, consigne, rentrer le pseudo, boutons */
		Container c = getContentPane();
		c.setLayout(new GridLayout(5,1));
		
		/* Creation de la ligne qui contiendra les champs du pseudo (un bouton et un JLabel)*/
		JPanel panelPseudo= new JPanel(); // creation JPanel
		panelPseudo.setLayout(new FlowLayout(FlowLayout.LEFT)); // Mis à droite
		labelPseudo = new JLabel("Pseudo du joueur :"); // Initialisation JLabel
		panelPseudo.add(labelPseudo); // Ajout du JLabel au JPanel
		champPseudo = new JTextField(20); // Initialisation JTextField
		panelPseudo.add(champPseudo); // Ajout au JPanel
		
		/* Creation de la ligne qui contiendra l'image*/
		JPanel panelIcone = new JPanel(); // Creation JPanel
		panelIcone.setLayout(new FlowLayout(FlowLayout.CENTER)); // centre
		icone = new ImageIcon("/home/segolene/Images/space_invaders1.png"); // Image
		labelIcone = new JLabel(icone); //Initialisation JLabel
		panelIcone.add(labelIcone); // Ajout au JPanel
		
		/* Creation des deux lignes qui contiendront un petit message de bienvenue et une phrase de consigne.*/
		JPanel panelBienvenue = new JPanel(); // Creation JPanel
		panelBienvenue.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centre
		labelBienvenue = new JLabel("Bienvenue dans le jeu Space Invaders !"); // Texte de Bienvenue
		panelBienvenue.add(labelBienvenue); // Ajout au JPanel
		
		JPanel panelPhrase = new JPanel(); // creation JPanel
		panelPhrase.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centre
		labelPhrase = new JLabel("Pour jouer, veuillez rentrer votre pseudo si dessous."); // Consigne
		panelPhrase.add(labelPhrase); // AJout au JPanel
		
		/* Création de la ligne qui contiendra les boutons de la fenetre (un pour fermer la fenêtre et l'autre
		 * pour ajouter un joueur)*/
		JPanel panelBoutons = new JPanel(); // Creation JPanel
		panelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER)); // centre
		fermer = new JButton("Fermer"); // Initialisation bouton fermer
		fermer.addActionListener(this);
		panelBoutons.add(fermer); // Ajout au JPanel
		afficher = new JButton("Ajouter"); // Initialisation bouton ajouter
		afficher.addActionListener(this);
		panelBoutons.add(afficher); // Ajout au JPanel
		
		// Ajout de tout au container
		c.add(panelIcone);
		c.add(panelBienvenue);
		c.add(panelPhrase);
		c.add(panelPseudo);
		c.add(panelBoutons);
		
		jeu = j; // Interface liee a cette fenetre
		peon = new Joueur(); // Nouveau joueur
		
		setLocation(600, 50); // Position sur l'ecran
		pack(); // Taille ideale
		setVisible(true); // visible
	}
	
	/* Pour gere les action sur les deux boutons */
	public void actionPerformed(ActionEvent e) 
	{
		// Si on appuie sur fermer
		if(e.getActionCommand().equals("Fermer"))
		{
			this.dispose(); // ferme cette fenetre
			jeu.dispose(); // ferme la fenetre de jeu
			System.exit(0); // ferme totalement les deux fenêtres
		}
		
		// Si on appuie sur ajouter
		else if(e.getActionCommand().equals("Ajouter"))
		{
			peon.pseudo = champPseudo.getText(); // Le pseudo ecrit devient le pseudo du joueur
			peon.score = 0; // son score est initialiser a 0
			jeu.pseudo.setText(peon.pseudo); // Son pseudo s'affiche en haut de la fenetre de jeu
			jeu.score.setText(" | Score : " + jeu.point); // Son score s'affiche a cote
			jeu.timerSpawnAlien.start(); // Le timer de creation des aliens se lancent
			jeu.timerRefresh.restart(); // Le timer de rafraichissement de la page se lance
			jeu.l.listeJoueur.add(peon); // Le joueur est ajouter à la liste joueur
			this.dispose(); // cette fenetre se ferme
			
		}
	}
}
