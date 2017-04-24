import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

public class PanneauJeu extends JComponent implements ActionListener
{
	public static final int LONGUEUR = 800;
	Ligne listeAlien;
	int x, y;
	
	public PanneauJeu()
	{
		super();
		setPreferredSize(new Dimension(LONGUEUR, 400));
		listeAlien = new Ligne();
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
