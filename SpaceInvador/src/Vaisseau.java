import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Vaisseau extends Rectangle2D.Double{
	
	private static final int TAILLE = 50;
	
	
	//Constructeur
	public Vaisseau(int x)
	{
		super(x, 0, TAILLE, TAILLE);
		Random r = new Random();
	}
	
	public void deplacer()
	{
		super.x += TAILLE;
	}
	

	
}
