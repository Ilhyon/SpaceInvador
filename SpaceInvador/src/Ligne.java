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
	
	public void creerAlien(int longueur)
	{
		
		Random rAlien = new Random();
		int x = Alien.DIAMETRE/2 + rAlien.nextInt(longueur-Alien.DIAMETRE);
		Alien a = new Alien(x, Alien.DIAMETRE/2);
	}
	
	public boolean intersect(Alien a)
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator();
		while(iterAlien.hasNext())
			if(iterAlien.next().interect(a))
				return true;
		return false;
	}
	
	public void supprimerAlien(Alien a)
	{
		listeAlien.remove(a);
		//listeAlien.add(a);
	}
	
	public void descendreAliens()
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator();
		while(iterAlien.hasNext())
			iterAlien.next().descendre();
	}
	
	public boolean testerLettre(Alien a)
	{
		if(listeAlien.contains(a))
		{
			supprimerAlien(a);
			return true;
		}
		return false;
	}

	
	public boolean testerPlancher(int hauteur)
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator();
		while(iterAlien.hasNext())
			if(iterAlien.next().getY()+Alien.DIAMETRE>hauteur)
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
