import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Alien extends Ellipse2D.Double
{
	
	private static final int PAS = 2;
	public static final int DIAMETRE = 50;
	int solidite;
	
	// constructeur
	public Alien(int centreX, int centreY)
	{
		super(centreX-DIAMETRE/2, centreY-DIAMETRE/2, DIAMETRE, DIAMETRE);
		Random r = new Random();
		solidite = 1+r.nextInt(5);
	}
	
	// Pour avoir le rectangle autour du rond
	public boolean interect(Alien a)
	{
		return intersects(a.getBounds2D());
	}

	// Pour descendre
	public void descendre()
	{
		super.y += PAS;
	}
	
	// Score rapporté par la mort de l'alien
	public int getScore()
	{
		return 1;
	}
	
	/* Couleur Alien */
	public void paint(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(2.0f));
		g2.setColor(Color.GREEN);
		g2.draw(this);
	}
	
}