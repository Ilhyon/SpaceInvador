import java.awt.BasicStroke;
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
		// Pour empêcher les missiles de se chevaucher 
		while(intersect(m))
		{
			// pour supprimer le dernier élément de la liste
			listeMissilesAffiches.remove(listeMissilesAffiches.size() - 1);
			x = v.getX() + v.getWidth()/2;
			y = v.getY() + 5;
			m = new Missile(x, y);
			
			
		}
		listeMissilesAffiches.add(m);
		
		
	}
	
	public void monterMissile()
	{
		Iterator<Missile> iterMissile = listeMissilesAffiches.iterator();
		while(iterMissile.hasNext())
			iterMissile.next().monter();
	}
	
	public boolean intersectWithAlien(Ligne l)
	{
		ListIterator<Alien> iterAlien = l.listeAlien.listIterator();
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator();

		Alien a = new Alien();
		Missile m = new Missile();
		boolean sup = false; // si on supprime un alien et un missile on arrete les boucles parce que les tailles change et ca plante
		// pour chaque missile on va tester si ils sont dans un alien
		while(iterMissile.hasNext() && sup == false)
		{
			iterAlien = l.listeAlien.listIterator();
			m = iterMissile.next();
			// parcours des differents aliens
			while(iterAlien.hasNext() && sup == false)
			{
				a = iterAlien.next();
				
				//Si il y a intersection, ça incrémente
				if(m.intersectMA(a) && a.r != 0)
				{
					a.r --;
					a.stroke = new BasicStroke(a.r);
					suprimerMissile(m);
					sup = true;
					return true;
				}
					
				
				// si le nombre d'intersection =  à la robustesse de l'alien
				// alors ça supprime l'alien et le missile, et ça remet le compteut à 0
				if(a.r == 0)
				{
					l.supprimerAlien(a); 
					suprimerMissile(m);
					sup = true;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean intersect(Missile m)
	{
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator();
		while(iterMissile.hasNext())
			if(iterMissile.next().intersectMM(m))
				return true;
		return false;
	}
	
	public void testerPlancher(int hauteur)
	{
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator();
		Missile m = new Missile();
		boolean b = false;
		while(iterMissile.hasNext() && b == false)
		{
			m = iterMissile.next();
			if(m.getY()+Alien.COTE < hauteur)
			{
				suprimerMissile(m);
				b = true;
			}
		}
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
