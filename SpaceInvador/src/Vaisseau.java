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
		super(450, 700, LONGUEUR, HAUTEUR);
		x = 450;
		y = 700;
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
		//Color darkBlue  = new Color(77,176,230); 
		g2.setStroke(new BasicStroke(2.0f));
		g2.setColor(Color.CYAN);
		g2.draw(this);
	}
	
}
