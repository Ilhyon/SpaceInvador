import java.awt.Graphics2D;
import java.util.*;

public class ListeMissile {
	ArrayList<Missile> listeMissilesAffiches;
	
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
		Iterator<Missile> enumBulle = listeMissilesAffiches.iterator();
		while(enumBulle.hasNext())
			enumBulle.next().monter();
	}
	
	public void intersectWithAlien(Ligne l)
	{
		ListIterator<Alien> iterAlien = l.listeAlien.listIterator();
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator();
		Alien a = new Alien();
		Missile m = new Missile();
		while(iterMissile.hasNext())
			m = iterMissile.next();
			while(iterAlien.hasNext())
				a = iterAlien.next();
				if(m.intersect(a))
				{
					l.supprimerAlien(a);
					suprimerMissile(m);
					System.out.println("rencontre du troisième genre");
				}
	}
	
	public void suprimerMissile(Missile m)
	{
		listeMissilesAffiches.remove(m);
		System.out.println("remove missile");
	}
	
	public void paint(Graphics2D g2)
	{
		Iterator<Missile> enumBulle = listeMissilesAffiches.iterator();
		while(enumBulle.hasNext())
			enumBulle.next().paint(g2);
	}
}
