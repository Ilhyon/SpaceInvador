import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ListIterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
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
		cptLevel = 0;
		level = 0;
		point = 0;
		
		ajoutJ = new AjoutJoueur(InterfaceJeu.this);
		
		/* Creation du container qui sera decouper en 3 lignes (explique plus bas)*/
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
//		c.setLayout(new GridLayout(3,1));
		
		/* Initialisation des JLabels*/
		pseudo = new JLabel("Pseudo : ? ");
		niveau = new JLabel("Niveau : " + level);
		score = new JLabel(" | Score : " + point);
		
		/* Ini des lignes pour la mise en forme de la page, il y aura 3 lignes : une avec les 
		 * JLabels, une avec le pnneau de jeu et la dernière avec le classement */
		JPanel panelAffichage = new JPanel();
		panelAffichage.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelAffichage.add(pseudo);
		panelAffichage.add(niveau);
		panelAffichage.add(score);
		panneau = new PanneauJeu();
		c.add(panelAffichage,BorderLayout.NORTH);
		
		l = new ListeJoueur();
		okButton = 1;
		
		c.add(panneau);
		
		timerRefresh = new Timer(30, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				panneau.listeMissile.monterMissile();
				panneau.listeAlien.descendreAliens();
				
				panneau.listeMissile.testerPlancher(0);
				
				if(panneau.listeAlien.testerPlancher(panneau.getHauteur()-200))
				panneau.normandy.testerBords();
				
				if(panneau.listeAlien.testerPlancher(panneau.getHauteur()- panneau.normandy.getHAUTEUR()))
				{
					timerRefresh.stop();
					timerSpawnAlien.stop();
					okButton = JOptionPane.showOptionDialog(InterfaceJeu.this, "Game Over !", "Fin du game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				}
				if(okButton == 0)
				{
					InterfaceClassement interC = new InterfaceClassement(InterfaceJeu.this);
				    interC.classement.fireTableDataChanged();
				    okButton = 1;
				}
				if(panneau.listeMissile.intersectWithAlien(panneau.listeAlien))
				{
					point ++;
					score.setText(" | Score : " + point);
					majScore();
				}
				
				panneau.listeMissile.intersectWithAlien(panneau.listeAlien);
				repaint();
				
					
			}
		});
		
		timerSpawnAlien = new Timer(1000, new ActionListener() 		
		{ 			
			public void actionPerformed(ActionEvent e) 
			{ 				
				creationAlien();
				repaint();
				if(cptLevel < 10)
				{
					cptLevel ++;
				}
				else
				{ 
					level ++;
					cptLevel = 0;
					niveau.setText("Niveau : " + level);
				}
			} 		
		});
		
		timerRefresh.start();
		addKeyListener(this);
		
		pack();
		setVisible(true);
	}
	
	public void majScore()
	{
		ListIterator<Joueur> iterJoueur = l.listeJoueur.listIterator();
		while(iterJoueur.hasNext())
		{
			Joueur j = new Joueur();
			j = iterJoueur.next();
			if(j.pseudo == this.pseudo.getText() )
			{
				j.score = point;
			}
		}
	}
	
	public Joueur selectJoueur()
	{
		ListIterator<Joueur> iterJoueur = l.listeJoueur.listIterator();
		while(iterJoueur.hasNext())
		{
			Joueur j = new Joueur();
			j = iterJoueur.next();
			if(j.pseudo == this.pseudo.getText() )
			{
				return j;
			}
			else
			{
				return null;
			}
		}
		return null;
	}
	
	public void reset(int i)
	{
		timerRefresh.stop();
		timerSpawnAlien.stop();
		
		score.setText(" | Score : 0");
		
		if(i == 1)// on recommence donc il faut remettre le score du joueur � 0
		{
			selectJoueur().score = 0;
			
		}
		
		point = 0;
		niveau.setText("Niveau : 0 ");
		level = 0;
		cptLevel = 0;
		
		panneau.listeAlien.listeAlien.clear();
		panneau.listeMissile.listeMissilesAffiches.clear();
		
		panneau.normandy.recentrer();
		
		repaint();
	}
	
	public void startTimer()
	{
		timerRefresh.start();
		timerSpawnAlien.start();
	}
	
	public void creationAlien()
	{
//		int nb = 5;
//		if(data.score>0)
//		{
//			nb = 5;
//		}
//		else if(score > 3)
//		{
//			nb = 7;
//		}
		int nb = 1;
		
		// pour changer la largeur du contour
		// g2.setStroke(new BasicStroke(2.0f));
		
		for(int i = 0; i <= nb; i++)
		{
			panneau.listeAlien.creerAlien(panneau.LARGEUR);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
//		/* si on clique sur le bouton ajout joueur, lance une fenetre pour créer un joueur et
//		 * mettre son pseudo dans le jlabel pseudo*/
//		if(e.getActionCommand().equals("Ajouter un nouveau joueur"))
//		{
//			Joueur j = new Joueur();
//			new AjoutJoueur(this,j);
//			data.add(j);
//			pseudo.setText(j.pseudo);
//		}
			
	}
	
	public void keyPressed(KeyEvent e) 
	{
		boolean direction;
		
		/* je fais différent if pour que si le joueur appuit sur plusieurs touches elles puissent 
		être toutes testées */
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
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) // gauche
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
