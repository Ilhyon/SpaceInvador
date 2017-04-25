import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

public class PanneauJeu extends JComponent implements ActionListener
{
	public static final int LARGEUR = 1000;
	public static final int HAUTEUR = 900;
	
	Ligne listeAlien;
	Vaisseau normandy;
	Timer timerAlien, timerCreationAlien, timerMissile;
	
	
	public PanneauJeu()
	{
		/* Ini du panneau avec une taille 400 (test) plus création des éléments présents  
		 * initiallement dedans (ligne, vasseau) */
		super();
		setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
		listeAlien = new Ligne();
		normandy  = new Vaisseau(195);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		//listeAlien.paint(g2);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}
