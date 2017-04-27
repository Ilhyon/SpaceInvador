import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Missile extends Ellipse2D.Double
{
	
	private static final int PAS = 5;
	public static final int DIAMETRE = 25;
	
	// constructeur
	public Missile(int centreX, int centreY)
	{
		super(centreX-DIAMETRE/2, centreY-DIAMETRE/2, DIAMETRE, DIAMETRE);
		Random r = new Random();
	}
	
	// Pour avoir le rectangle autour du rond
	public boolean intersect(Missile m)
	{
		return intersects(m.getBounds2D());
	}

	// Pour descendre
	public void monte()
	{
		super.y -= PAS;
	}
	
}