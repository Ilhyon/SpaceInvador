import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Alien extends Rectangle2D.Double
{
	
	private static final int PAS = 2;
	public static final int COTE = 40;
	int r;
	Stroke stroke;
	
	
	
	// constructeur
	public Alien(int centreX, int level)
	{
		super(centreX, 0, COTE, COTE);
		r = 1; // de base la robustesse de l'alien est de 1
		//Pour que les aliens prennent une épaisseur/robustesse random
		if(level != 0)
		{
			r = new Random().nextInt(level) + 1;
		}
		stroke = new BasicStroke(r);
	}
	
	public Alien()
	{
		super();
	}
	
	// Pour avoir le rectangle autour du rond
	public boolean intersectAA(Alien a)
	{
		return intersects(a.getBounds2D());
	}
	

	// Pour descendre
	public void descendre()
	{
		super.y += PAS;
	}
	
	/* Couleur Alien */
	public void paint(Graphics2D g2)
	{
		g2.setStroke(stroke);
		g2.setColor(Color.GREEN);
		g2.draw(this);
	}
	
}