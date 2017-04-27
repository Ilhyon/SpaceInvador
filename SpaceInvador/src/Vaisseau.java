import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Vaisseau extends Rectangle2D.Double{
	
	private static final int LONGUEUR = 50;
	private static final int HAUTEUR = 25;
	int x,y;
	
	
	//Constructeur
	public Vaisseau()
	{
		super(450, 0, LONGUEUR, HAUTEUR);
		x = 450;
		y = 0;
	}
	
	public void deplacer(boolean b)
	{
		if(b == true){
			super.x += LONGUEUR/2; // vers la droite
		}
		else{super.x -= LONGUEUR/2;} // vers la gauche
		
	}
	
	public void paint(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(2.0f));
		g2.setColor(Color.BLUE);
		g2.draw(this);
	}
	
	public int getLongueur()
	{
		return LONGUEUR;
	}
	
}
