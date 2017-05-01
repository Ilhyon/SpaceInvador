import java.awt.Graphics2D;
import java.util.*;

public class ListeMissile {
	ArrayList<Missile> listeMissilesAffiches;
	//Missile m;
	
	public ListeMissile()
	{
		listeMissilesAffiches = new ArrayList<Missile>();
	}
	
	public void creerMissile(int longueur, Vaisseau v)
	{
		double x = v.getX() + v.getWidth()/2;
		double y = v.getY();
		Missile m = new Missile(x, y);
//		while(intersect(b))
//		{
//			x = Bulle.DIAMETRE/2 + r.nextInt(longueur-Bulle.DIAMETRE);
//			b = new Bulle(x, Bulle.DIAMETRE/2,l);
//		}
		listeMissilesAffiches.add(m);
	}
	
	public void monterMissile()
	{
		Iterator<Missile> iterMissile = listeMissilesAffiches.iterator();
		while(iterMissile.hasNext())
		{
			// A MODIFIER : c'est presque ça mais pas tout à fait !
			//Missile m = (Missile) iterMissile.iterator();
			iterMissile.next().monter();
			// Si les missiles sortent de l'écran alors on les supprime
//			if(m.getY() < 0) 
//			{
//				listeMissilesAffiches.remove(m);
//				System.out.println("supp");
//				
//			}
		}
			
			
	}
	
	public void paint(Graphics2D g2)
	{
		Iterator<Missile> enumBulle = listeMissilesAffiches.iterator();
		while(enumBulle.hasNext())
			enumBulle.next().paint(g2);
	}
}
