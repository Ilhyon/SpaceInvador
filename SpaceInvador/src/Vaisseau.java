import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Vaisseau extends Rectangle2D.Double{
	
	private static final int LONGUEUR = 50;
	private static final int HAUTEUR = 25;
	
	
	//Constructeur
	public Vaisseau()
	{
		super((PanneauJeu.LARGEUR/2) - LONGUEUR, PanneauJeu.HAUTEUR - LONGUEUR, LONGUEUR, HAUTEUR);
	}
	
	
	public void deplacer(boolean b)
	{
		if(b == true){
			x += LONGUEUR/2; // vers la droite
		}
		else
		{
			x -= LONGUEUR/2;
		} // vers la gauche
		
	}
	
	public void paint(Graphics2D g2)
	{
		//Color darkBlue  = new Color(77,176,230); 
		g2.setStroke(new BasicStroke(2.0f));
		g2.setColor(Color.CYAN);
		g2.draw(this);
	}
	
	/* Pour tester les bords, si on est sur un des deux bords, alors x reste ce bord pour ne pas le depacer*/
	public void testerBords()
	{
		if(x >= PanneauJeu.LARGEUR - LONGUEUR)
		{
			x = PanneauJeu.LARGEUR - LONGUEUR;
		}
		else if(x <= 0)
		{
			x = 0;
		}
	}
	
	public int getHAUTEUR()
	{
		return this.HAUTEUR;
	}
	
	public int getLONGUEUR()
	{
		return this.LONGUEUR;
	}
}
