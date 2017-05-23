import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

// Cette classe permet de créer un Missile et ses méthodes associees
public class Missile extends Ellipse2D.Double
{
	
	private static final int PAS = 5;
	public static final int DIAMETRE = 10; 
	
	// Constructeur 
	public Missile(double centreX, double centreY)
	{
		// coordonnees x, y, largeur, hauteur
		super(centreX-DIAMETRE/2, centreY-DIAMETRE/2, DIAMETRE, DIAMETRE);
	}
	// Constructeur par défaut
	public Missile()
	{
		super();
	}
	
	// Intersection entre un missile et un alien
	public boolean intersectMA(Alien a)
	{
		return intersects(a.getBounds2D());
	}
	
	// Intersection entre un missile et un missile
	public boolean intersectMM(Missile m)
	{
		return intersects(m.getBounds2D());
	}
	
	// Graphisme du missile
	public void paint(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(2.0f));
		g2.setColor(Color.YELLOW);
		g2.draw(this);
	}
	
	// Pour faire monter le missile
	public void monter()
	{
		super.y -= PAS;
	}
	
}