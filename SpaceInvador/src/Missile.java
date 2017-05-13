import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Missile extends Ellipse2D.Double
{
	
	private static final int PAS = 5;
	public static final int DIAMETRE = 10;
	
	// constructeur
	public Missile(double centreX, double centreY)
	{
		super(centreX-DIAMETRE/2, centreY-DIAMETRE/2, DIAMETRE, DIAMETRE);
	}
	
	public Missile()
	{
		super();
	}
	
	// Pour avoir le rectangle autour du rond
	public boolean intersect(Alien a)
	{
		//System.out.println(a.getBounds2D());
		return intersects(a.getBounds2D());
	}
	
	public void paint(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(2.0f));
		g2.setColor(Color.YELLOW);
		g2.draw(this);
	}

	public void monter()
	{
		super.y -= PAS;
	}
	
}