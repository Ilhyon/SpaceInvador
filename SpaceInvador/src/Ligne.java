import java.awt.Graphics2D;
import java.util.*;

public class Ligne {
	
	int nbAlien;
	ArrayList<Alien> listeAlien;
	
	public Ligne()
	{
		nbAlien = 0;
		listeAlien = new ArrayList<Alien>();
		
	}
	
	public void creerAlien(int longueur, int cptRobustesse)
	{
		if(listeAlien.size()>0)
		{
			Random rAlien = new Random();
			int x = 0 + rAlien.nextInt(10 - 0);
			x = x*50;
			Alien a = new Alien(x, cptRobustesse);
			while(intersect(a))
			{
				x = 0 + rAlien.nextInt(10 - 0);
				x = x*50;
				a = new Alien(x, cptRobustesse);
			}
			listeAlien.add(a);
		}
		else
		{
			Random rAlien = new Random();
			int x = 0 + rAlien.nextInt(10 - 0);
			x = x*50;
			Alien a = new Alien(x, cptRobustesse);
			listeAlien.add(a);
		}
		
	}
	
	public boolean intersect(Alien a)
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator();
		while(iterAlien.hasNext())
			if(iterAlien.next().intersectAA(a))
				return true;
		return false;
	}
	
	public void supprimerAlien(Alien a)
	{
		listeAlien.remove(a);
	}
	
	public void descendreAliens()
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator();
		while(iterAlien.hasNext())
			iterAlien.next().descendre();
	}

	
	public boolean testerPlancher(int hauteur)
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator();
		while(iterAlien.hasNext())
			if(iterAlien.next().getY()+Alien.COTE > hauteur)
				return true;
		return false;
	}
	
	public void paint(Graphics2D g2)
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator();
		while(iterAlien.hasNext())
			iterAlien.next().paint(g2);
	}
}
