import java.awt.Graphics2D;
import java.util.*;

public class ListeMissile {
	ArrayList<Missile> listeMissilesAffiches;
	int point;
	Missile m;
	
	public ListeMissile()
	{
		listeMissilesAffiches = new ArrayList<Missile>();
		point = 0;
	}
	
	public void creerMissile(double longueur, Vaisseau v)
	{
		double x = v.getX() + v.getWidth()/2;
		double y = v.getY();
		m = new Missile(x, y);
		// Pou(r empêcher les missiles de se chevaucher 
		while(intersect(m))
		{	
			x = v.getX() + v.getWidth()/2;
			y = v.getY() + 5;
			m = new Missile(x, y);
			// pour supprimer le dernier élément de la liste
			listeMissilesAffiches.remove(listeMissilesAffiches.size() - 1);
			
			
		}
		listeMissilesAffiches.add(m);
		
		
	}
	
	public void monterMissile()
	{
		Iterator<Missile> enumBulle = listeMissilesAffiches.iterator();
		while(enumBulle.hasNext())
			enumBulle.next().monter();
	}
	
	public boolean intersectWithAlien(Ligne l)
	{
		ListIterator<Alien> iterAlien = l.listeAlien.listIterator();
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator();

		Alien a = new Alien();
		Missile m = new Missile();
		boolean sup = false; // si on suprime un alien et un missile on arrete les boucles parce que les tailles change et ca plante
		// pour chaque missile on va tester si ils sont dans un alien
		while(iterMissile.hasNext() && sup == false)
		{
			m = iterMissile.next();
			// parcours des differents aliens
			while(iterAlien.hasNext() && sup == false)
			{
				a = iterAlien.next();
				//System.out.println(a.getBounds2D());
				if(m.intersectMA(a))
				{
					l.supprimerAlien(a);
					supprimerMissile(m);
					point ++;
					sup = true;
					return true;
				}
			}
		}
		return false;
	}
	
	public int getScore()
	{
		return point;
	}
	
	public boolean intersect(Missile m)
	{
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator();
		while(iterMissile.hasNext())
			if(iterMissile.next().intersectMM(m))
				return true;
		return false;
	}
	
	public void supprimerMissile(Missile m)
	{
		listeMissilesAffiches.remove(m);
	}
	
	public boolean testerPlafond(int hauteur)
	{
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator();
		while(iterMissile.hasNext())
			if(iterMissile.next().getY()+Missile.DIAMETRE == hauteur)
				return true;
		return false;
	}
	
	public void paint(Graphics2D g2)
	{
		Iterator<Missile> enumBulle = listeMissilesAffiches.iterator();
		while(enumBulle.hasNext())
			enumBulle.next().paint(g2);
	}
}
