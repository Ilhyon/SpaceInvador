import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class InterfaceJeu extends JFrame implements ActionListener
{
	/* Elements initiaux dont on va avoir besoin*/
	JButton ajoutJoueur; // Bouton pour ajouter un nouveau joueur qui ne devra pas etre tout le temps dispo
	JLabel pseudo, niveau, score; // Affichage de ces elements en haut de la page
	Vector<Joueur> data; // Pour faire notre liste de joueurs
	PanneauJeu panneau; // Panneau du jeu
	Classement classement;
	
	/* Constructeur*/
	public InterfaceJeu()
	{
		super("Super Space Invador");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* Creation du container qui sera decouper en 3 lignes (explique plus bas)*/
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.setLayout(new GridLayout(3,1));
		
		data = new Vector<Joueur>();
		
		/* Initialisation des JLabels*/
		pseudo = new JLabel("Pseudo ");
		niveau = new JLabel("Niveau : 0");
		score = new JLabel("Score : 0");
		
		/* Ini du bouton pour un nouveau joueur */
		ajoutJoueur = new JButton("Ajouter un nouveau joueur");
		ajoutJoueur.addActionListener(this);
		
		/* Ini des lignes pour la mise en forme de la page, il y aura 3 lignes : une avec les 
		 * JLabels, une avec le pnneau de jeu et la dernière avec le classement */
		JPanel panelAffichage = new JPanel();
		panelAffichage.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelAffichage.add(pseudo);
		panelAffichage.add(niveau);
		panelAffichage.add(score);
		JPanel panelPanneau = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panneau = new PanneauJeu();
		panelPanneau.add(panneau);
		JPanel panelClassement = new JPanel(new FlowLayout(FlowLayout.CENTER));
		classement = new Classement();
		//panelClassement.add(classement);
		c.add(panelAffichage);
		c.add(panelPanneau);
		c.add(panelClassement);
		
		
		pack();
		setVisible(true);
	}
	
//	public void actionPerformed(ActionEvent e) {
//		/* si on clique sur le bouton ajout joueur, lance une fenetre pour créer un joueur et
//		 * mettre son pseudo dans le jlabel pseudo*/
//		if(e.getActionCommand().equals("Ajouter un nouveau joueur"))
//		{
//			Joueur j = new Joueur();
//			new AjoutJoueur(this,j);
//			data.add(j);
//			pseudo.setText(j.pseudo);
//		}
//	}
	
	public static void main(String[] args) 
	{
		new AjoutJoueur();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
