import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Alien extends Rectangle2D.Double
{
	
	private static final int PAS = 2;
	public static final int COTE = 40;
	int solidite;
	
	// constructeur
	public Alien(int centreX)
	{
		super(centreX, 0, COTE, COTE);
//		Random r = new Random();
//		solidite = 1+r.nextInt(5);
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
		g2.setStroke(new BasicStroke(2.0f));
		g2.setColor(Color.GREEN);
		g2.draw(this);
	}
	
}