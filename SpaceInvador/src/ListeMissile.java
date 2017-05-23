import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.*;

// Cette classe permet de creer une liste de missile
public class ListeMissile {
	ArrayList<Missile> listeMissilesAffiches;
	
	// Constructeur
	public ListeMissile()
	{
		listeMissilesAffiches = new ArrayList<Missile>();
	}
	
	// Pour creer des Missiles
	public void creerMissile(double longueur, Vaisseau v)
	{
		double x = v.getX() + v.getWidth()/2; // Se creer au centre du vaisseau
		double y = v.getY(); // se cree au dessus du vaisseau
		Missile m = new Missile(x, y); // creation du missile
		
		// Tant que les missiles se chevauchent 
		while(intersect(m))
		{
			x = v.getX() + v.getWidth()/2; // Se creer au centre du vaisseau
			y = v.getY() + 5; // se creer au dessus de l'autre
			m = new Missile(x, y); // creation missile
			listeMissilesAffiches.remove(listeMissilesAffiches.size() - 1); // On supprime le dernier alien de la liste
		}
		listeMissilesAffiches.add(m); // On ajoute l'alien à la liste
		
		
	}
	
	// Pour faire monter le missile
	public void monterMissile()
	{
		Iterator<Missile> iterMissile = listeMissilesAffiches.iterator(); // Creation Iterateur de la liste des missiles
		// Tant qu'il y a des missiles
		while(iterMissile.hasNext())
			iterMissile.next().monter(); // Les missiles montent
	}
	
	// Pour tuer les aliens
	public boolean intersectWithAlien(Ligne l)
	{
		ListIterator<Alien> iterAlien = l.listeAlien.listIterator(); // Creation iterateur de la liste des aliens
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator(); // Creation iterateur de la liste des missiles

		Alien a = new Alien(); // creation alien
		Missile m = new Missile(); // creation missile
		boolean sup = false; // si on supprime un alien et un missile on arrete les boucles parce que les tailles changent et ca plante
		// pour chaque missile on va tester s'ils sont dans un alien
		// tant qu'il y a des missile et que le booleen est false
		while(iterMissile.hasNext() && sup == false)
		{
			iterAlien = l.listeAlien.listIterator();
			m = iterMissile.next(); // le missile devient un element de la l'iterateur
			// Tant qu'il y a des aliens et que le booleen est false
			while(iterAlien.hasNext() && sup == false)
			{
				a = iterAlien.next(); // l'alien devient un element de l'iterateur
				
				// S'il y a intersection entre un missile et un alien et que la robustesse de l'alien est différente de 0
				if(m.intersectMA(a) && a.r != 0)
				{
					a.r --; // Alors la robustesse de l'alien diminue
					a.stroke = new BasicStroke(a.r); // l'epaisseur du contour de l'alien diminue
					suprimerMissile(m);// Le missile se supprime
					// SI la robustesse passe à 0
					if(a.r == 0)
					{
						l.supprimerAlien(a); // on supprime les aliens
					}
					sup = true; // le booleen devient true
					return true; // cela renvoie true
				}
	
			}
		}
		return false; // sinon cela renvoie false
	}
	
	// Pour regarder s'il y a une intersecton avec un missile
	public boolean intersect(Missile m)
	{
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator(); // Creation iterateur de la liste des missiles
		// Tant qu'il y a des missiles
		while(iterMissile.hasNext())
			// Si un missile chevauche un autre missile
			if(iterMissile.next().intersectMM(m))
				return true; // cela renvoie true
		return false; // cela renvoie false
	}
	
	// Pour tester le plafond
	public void testerPlafond(int hauteur)
	{
		ListIterator<Missile> iterMissile = listeMissilesAffiches.listIterator(); //Creation iterateur de la liste des missiles
		Missile m = new Missile(); // creation missile
		boolean b = false; // creation booleen 
		// tant qu'il y a des missiles et que le booleen est false
		while(iterMissile.hasNext() && b == false)
		{
			m = iterMissile.next(); // le missile devient un element de l'iterateur
			// Si le missile touche le plafond
			if(m.getY() + Alien.COTE < hauteur)
			{
				suprimerMissile(m); // alors il est supprimé
				b = true; // le booleen devient true
			}
		}
	}
	
	// Pour supprimer les missile
	public void suprimerMissile(Missile m)
	{
		listeMissilesAffiches.remove(m);
	}
	
	// Graphisme de la liste de missiles
	public void paint(Graphics2D g2)
	{
		Iterator<Missile> iterMissile = listeMissilesAffiches.iterator(); //Creation iterateur de la liste des missiles
		// tant qu'il y a des missiles
		while(iterMissile.hasNext()) 
			iterMissile.next().paint(g2); // ils ont le graphismes d'un Missile
	}
}
