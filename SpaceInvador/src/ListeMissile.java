import java.awt.Graphics2D;
import java.util.*;

public class ListeMissile {
	ArrayList<Missile> listeMissilesAffiches;
	
	public ListeMissile()
	{
		listeMissilesAffiches = new ArrayList<Missile>();
	}
	
	public void creerMissile(double longueur, Vaisseau v)
	{
		double x = v.getX() + v.getWidth()/2;
		double y = v.getY();
		Missile m = new Missile(x, y);
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
		boolean sup = false; // si on suprime un alien et un missile on arrete lse boucles parce que les tailles change et �a plante
		// pour chaque missile on va tester si ils sont dans un alien
		while(iterMissile.hasNext() && sup == false)
		{
			m = iterMissile.next();
			// parcours des differents aliens
			while(iterAlien.hasNext() && sup == false)
			{
				a = iterAlien.next();
				System.out.println(a.getBounds2D());
				if(m.intersect(a))
				{
					l.supprimerAlien(a);
					suprimerMissile(m);
					sup = true;
				}
			}
		}
	}
	
	public boolean intersect(Missile m)
	{
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator();
		while(iterMissile.hasNext())
			if(iterMissile.next().interect(m))
				return true;
		return false;
	}
	
	public void suprimerMissile(Missile m)
	{
		listeMissilesAffiches.remove(m);
	}
	
	public void paint(Graphics2D g2)
	{
		Iterator<Missile> enumBulle = listeMissilesAffiches.iterator();
		while(enumBulle.hasNext())
			enumBulle.next().paint(g2);
	}
}
