import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

// Cette classe permet de creer un Vaisseau et ses methodes associees
public class Vaisseau extends Rectangle2D.Double{
	
	private static final int LONGUEUR = 50;
	private static final int HAUTEUR = 25;
	
	
	//Constructeur
	public Vaisseau()
	{
		//coordonnees x, y hauteur, longueur
		super((PanneauJeu.LARGEUR/2) - 50, PanneauJeu.HAUTEUR - 50, LONGUEUR, HAUTEUR);
	}
	
	// Pour recentrer le vaisseau
	public void recentrer()
	{
		x = (PanneauJeu.LARGEUR/2) - 50;
	}
	
	// Pour deplacer le vaisseau
	public void deplacer(boolean b)
	{
		if(b == true){
			x += LONGUEUR/2; // vers la droite
		}
		else
		{
			x -= LONGUEUR/2; // vers la gauche
		} 
		
	}
	
	//Graphisme du vaisseau
	public void paint(Graphics2D g2)
	{ 
		g2.setStroke(new BasicStroke(2.0f));
		g2.setColor(Color.CYAN);
		g2.draw(this);
	}
	
	/* Pour tester les bords, si on est sur un des deux bords, 
	 * alors x devient ce bord et on ne peut plus deplacer le 
	 * vaisseau par la */
	public void testerBords()
	{
		if(x >= PanneauJeu.LARGEUR - 50)
		{
			x = PanneauJeu.LARGEUR - 50;
		}
		else if(x <= 0)
		{
			x = 0;
		}
	}
	
	// Pour avoir la hauteur
	public int getHAUTEUR()
	{
		return this.HAUTEUR;
	}
	
	// Pour avoir la longueur
	public int getLONGUEUR()
	{
		return this.LONGUEUR;
	}
}
