import java.awt.Graphics2D;
import java.util.*;

public class ListeMissile {
	ArrayList<Missile> listeMissilesAffiches;
	
	public ListeMissile()
	{
		listeMissilesAffiches = new ArrayList<Missile>();
	}
	
	public void creerMissile(int longueur)
	{
		Vaisseau test = new Vaisseau();
		int x = test.getLongueur()/2;
		Missile m = new Missile(x, Missile.DIAMETRE/2);
//		while(intersect(b))
//		{
//			x = Bulle.DIAMETRE/2 + r.nextInt(longueur-Bulle.DIAMETRE);
//			b = new Bulle(x, Bulle.DIAMETRE/2,l);
//		}
		listeMissilesAffiches.add(m);
	}
	
	public void monterMissile()
	{
		Iterator<Missile> enumBulle = listeMissilesAffiches.iterator();
		while(enumBulle.hasNext())
			enumBulle.next().monter();
	}
	
	public void paint(Graphics2D g2)
	{
		Iterator<Missile> enumBulle = listeMissilesAffiches.iterator();
		while(enumBulle.hasNext())
			enumBulle.next().paint(g2);
	}
}
