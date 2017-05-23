import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.Timer;

public class PanneauJeu extends JComponent 
{
	public static final int LARGEUR = 500;
	public static final int HAUTEUR = 800;
	
	/*
	 * elements que le joueur verra dans le panneau de jeu :
	 * les alien, les missiles et le vaisseau
	 */
	Ligne listeAlien;
	Vaisseau normandy;
	ListeMissile listeMissile;
	
	
	public PanneauJeu()
	{
		/* Ini du panneau avec les tailles definit plus creation des elements presents  
		 * initiallement dedans (ligne, vasseau, missiles) */
		super();
		setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
		listeAlien = new Ligne();
		normandy  = new Vaisseau();
		listeMissile = new ListeMissile();
		
	}
	
	// Graphisme du panneau
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, LARGEUR, HAUTEUR);
		//listeAlien.paint(g2);
		normandy.paint(g2);
		listeMissile.paint(g2);
		listeAlien.paint(g2);
	}

	// pour obtenir la hauteur du panneau
	public int getHauteur()
	{
		return HAUTEUR;
	}
}
