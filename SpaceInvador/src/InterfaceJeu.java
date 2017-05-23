import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ListIterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class InterfaceJeu extends JFrame implements KeyListener
{
	/* Elements initiaux dont on va avoir besoin*/
	JLabel pseudo, niveau, score; // Affichage de ces elements en haut de la page
	PanneauJeu panneau; // Panneau du jeu
	Timer timerRefresh, timerSpawnAlien;
	int okButton, cptLevel, level, point;
	ListeJoueur l;
	AjoutJoueur ajoutJ;
	
	/* Constructeur*/
	public InterfaceJeu()
	{
		super("Super Space Invaders");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cptLevel = 0; // pour voir quand on change de niveau oup as
		level = 1; // niveau
		point = 0; // nombre de point de la partie
		okButton = 1; // pour le bouton du game over
		
		ajoutJ = new AjoutJoueur(InterfaceJeu.this); // popup qui va permettre l'ajout d'un jour
		
		/* Creation du container */
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		/* Initialisation des JLabels*/
		pseudo = new JLabel("Pseudo : ? ");
		niveau = new JLabel("Niveau : " + level);
		score = new JLabel(" | Score : " + point);
		
		/* 
		 * Initialisation de tout les jLabel : niveau, score et pseudo */
		JPanel panelAffichage = new JPanel();
		panelAffichage.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelAffichage.add(pseudo);
		panelAffichage.add(niveau);
		panelAffichage.add(score);
		c.add(panelAffichage,BorderLayout.NORTH);// on ajoute ce panel en haut
		
		// creation du panneau de jeu
		panneau = new PanneauJeu();
		c.add(panneau); // ajout du panneau de jeu
		
		l = new ListeJoueur();
		
		// timer qui va prendre en comtpe presque toutes les "actions" : monter/descentes des elements, si ils touchent les limites,
		// si ils se rencontrent, si c'est la fin ect..
		timerRefresh = new Timer(30, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				panneau.listeMissile.monterMissile();
				panneau.listeAlien.descendreAliens();
				
				panneau.listeMissile.testerPlafond(0); // test si les missiles sorte du panneau
				
				
				// Si l'alien touche le vaisseau fin de la game
				if(panneau.listeAlien.testerPlancher(panneau.getHauteur()- panneau.normandy.getHAUTEUR()))
				{
					// on arrete les timer dans un premier temps sinon ils vont continuer a tourner
					timerRefresh.stop();
					timerSpawnAlien.stop();
					
					// popup du message game over
					okButton = JOptionPane.showOptionDialog(InterfaceJeu.this, "Game Over !", "Fin du game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				}
				if(okButton == 0) // si on appuis sur ok on afiche le classement
				{
					InterfaceClassement interC = new InterfaceClassement(InterfaceJeu.this);
				    interC.classement.fireTableDataChanged(); // maj du classement
				    okButton = 1; // sinon le bouton vaut tout le temps 0 et ca spam d'interface
				}
				
				if(panneau.listeMissile.intersectWithAlien(panneau.listeAlien)) // si collision supression alien et mise a jour du score
				{
					point += 1; // augmentation des points
					score.setText(" | Score : " + point); // maj affichage en haut du panneau
					majScore(); //maj du score
					majLevel(); // maj du niveau
				}
				
				repaint();
			}
		});
		
		timerSpawnAlien = new Timer(1000, new ActionListener() // timer qui va s'occuper de la creation des alien	
		{ 			
			public void actionPerformed(ActionEvent e) 
			{ 				
				creationAlien(level);
				repaint();
				
				/*
				 * ici on va voir quand passer au niveau superieur. 
				 * Chaque dix ligne qui apparait un niveau de plus est acquis.
				 */
				
				if(cptLevel < 10) // si dix lignes ne sont pas passee on incremente le compteur de 1
				{
					cptLevel ++;
				}
				else // sinon il est a 10 du coup +1 lvl et le compteur retombe a 0
				{ 
					level ++;
					cptLevel = 0;
					niveau.setText("Niveau : " + level); // maj du jLabel pour l'affichage en haut du panneau
				}
			} 		
		});
		
		timerRefresh.start();
		addKeyListener(this);
		
		pack();
		setVisible(true);
	}
	
	// mise a jour du score
	public void majScore()
	{
		selectJoueur().score = point;
	}
	
	public void majLevel()
	{
		selectJoueur().level = level;
	}
	
	public Joueur selectJoueur()
	{
		
		int max = 0; // pour choisir le dernier numero de joueur donc le joueur actuel
		ListIterator<Joueur> iterJoueur = l.listeJoueur.listIterator();
		
		//Pour trouver le nb max
		for(int i = 0; i < l.listeJoueur.size(); i ++)
		{
			Joueur j;
			j = iterJoueur.next();
			if(max < j.nbJoueur) // si on trouve un nb superieur au max alors maj du max
			{
				max = j.nbJoueur;
			}
		}
		
		iterJoueur = l.listeJoueur.listIterator();// re ini de la liste
		//tant que le numero ne correspond pas a celui du joueur on continu de chercher
		while(iterJoueur.hasNext())
		{
			Joueur j;
			j = iterJoueur.next();
			
			if(max == j.nbJoueur)
			{
				return j;
			}
		}
		return null;
	}
	
	/* Cette fonction permet de re initialiser le jeu entre deux parties, 
	 * c'est a dire entre un joueur qui recommence ou l'arrivee d'un nouveau
	 * joueur
	 */
	public void reset(int i)
	{
		timerRefresh.stop();
		timerSpawnAlien.stop();
		
		score.setText(" | Score : 0");
		
		point = 0;
		niveau.setText("Niveau : 0 ");
		level = 1;
		cptLevel = 0;
		
		panneau.listeAlien.listeAlien.clear();
		panneau.listeMissile.listeMissilesAffiches.clear();
		
		panneau.normandy.recentrer();
		
		repaint();
	}
	
	// pour relancer les timers 
	public void startTimer()
	{
		timerRefresh.start();
		timerSpawnAlien.start();
	}
	
	/* fonction qui va creer les alien, prends en compte le niveau pour
	 * rajouter de la difficultees avec de plus en d'alien !
	 * chaque deux niveaux il y a un nouvel ennemi a combattre..
	 */
	public void creationAlien(int level)
	{
		int nb = level/2;

		if(nb > 9) // pour ne pas depacer dix alien
		{
			nb = 9;
		}
		
		for(int i = 0; i <= nb; i++)// creation de tout nos alien !!
		{
			panneau.listeAlien.creerAlien(panneau.LARGEUR, level);
		}
	}
	
	public void keyPressed(KeyEvent e) 
	{
		boolean direction;
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) // droite
		{
			direction = true;
			panneau.normandy.deplacer(direction);
			panneau.normandy.testerBords();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) // gauche
		{
			direction = false;
			panneau.normandy.deplacer(direction);
			panneau.normandy.testerBords();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) // espace
		{
			panneau.listeMissile.creerMissile(panneau.normandy.x, panneau.normandy);
		}
		
		repaint();
	}

	public void keyReleased(KeyEvent e) 
	{
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public static void main(String[] args) 
	{
		new InterfaceJeu();
	}

	
}
