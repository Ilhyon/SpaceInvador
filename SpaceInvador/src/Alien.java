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
	int r; // robustesse
	Stroke stroke;
	
	// Constructeur 
	public Alien(int x, int level)
	{
		// coordonnées x, y, largeur, hauteur
		super(x, 0, COTE, COTE);
		// Pour que les Aliens prennent une robustesse random
		// en fonction du niveau : genre si niveau 5
		// l'alien sera soit de robustesse 1,2,3,4,5 aléatoirement
		r = new Random().nextInt(level) + 1;
		
		// La robustesse est représentée par l'épaisseur du contour
		// Chaque alien possède sa propre robustesse
		stroke = new BasicStroke(r);
	}
	
	// Constructeur par defaut
	public Alien()
	{
		super();
	}
	
	//Intersection entre un alien et un alien
	public boolean intersectAA(Alien a)
	{
		return intersects(a.getBounds2D());
	}
	
	// Pour faire descendre l'alien
	public void descendre()
	{
		super.y += PAS;
	}
	
	//Graphisme de l'alien
	public void paint(Graphics2D g2)
	{
		g2.setStroke(stroke);
		g2.setColor(Color.GREEN);
		g2.draw(this);
	}
	
}