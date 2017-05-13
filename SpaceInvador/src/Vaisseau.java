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
		super(450, 850, LONGUEUR, HAUTEUR);
		x = 450;
		y = 850;
	}
	
	
	public void deplacer(boolean b)
	{
		if(b == true){
			super.x += LONGUEUR/2; // vers la droite
			x += LONGUEUR/2;
		}
		else
		{
			super.x -= LONGUEUR/2;
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
	
	/* Pour tester les bords, si on est sur un des deux bords, alors x reste ce bord pour ne pas le dépacer*/
	public void testerBords()
	{
		if(x >= 950)
		{
			super.x = 950;
			x = 950;
		}
		else if(x <= 0)
		{
			super.x = 0;
			x = 0;
		}
	}
	
	public int getHAUTEUR()
	{
		return this.HAUTEUR;
	}
}
