import java.awt.Graphics2D;
import java.util.*;

public class Ligne {
	
	int nbAlien;
	Random rAlien;
	ArrayList<Alien> listeAlien;
	
	public Ligne()
	{
		nbAlien = 0;
		listeAlien = new ArrayList<Alien>();
		
	}
	
	public void creerAlien(int longueur)
	{
		
			rAlien = new Random();
			
			int x = Alien.DIAMETRE/2 + r.nextInt(longueur-Alien.DIAMETRE);
			Alien b = new Alien(x, Alien.DIAMETRE/2);
			
	}
	
//	public boolean intersect(Alien b)
//	{
//		Enumeration<Alien> enumAlien = listeLettresAffichees.elements();
//		while(enumAlien.hasMoreElements())
//			if(enumAlien.nextElement().interect(b))
//				return true;
//		return false;
//	}
//	
//	public void supprimerAlien(String lettre)
//	{
//		listeLettresAffichees.remove(lettre);
//		listeLettres.add(lettre);
//	}
//	
//	public void descendreAliens()
//	{
//		Enumeration<Alien> enumAlien = listeLettresAffichees.elements();
//		while(enumAlien.hasMoreElements())
//			enumAlien.nextElement().descendre();
//	}
//	
//	public boolean testerLettre(String lettre)
//	{
//		lettre = lettre.toUpperCase();
//		if(listeLettresAffichees.containsKey(lettre))
//		{
//			supprimerAlien(lettre);
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean testerPlancher(int hauteur)
//	{
//		Enumeration<Alien> enumAlien = listeLettresAffichees.elements();
//		while(enumAlien.hasMoreElements())
//			if(enumAlien.nextElement().getY()+Alien.DIAMETRE>hauteur)
//				return true;
//		return false;
//	}
	
//	public void paint(Graphics2D g2)
//	{
//		Enumeration<Alien> enumAlien = listeLettresAffichees.elements();
//		while(enumAlien.hasMoreElements())
//			enumAlien.nextElement().paint(g2);
//	}
}
