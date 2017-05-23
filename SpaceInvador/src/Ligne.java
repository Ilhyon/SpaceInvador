import java.awt.Graphics2D;
import java.util.*;

// Cette classe permet de creer chaque ligne du jeu
public class Ligne {
	
	int nbAlien; // nombre d'alien
	ArrayList<Alien> listeAlien; // liste d'alien
	
	// Constructeur
	public Ligne()
	{
		nbAlien = 0;
		listeAlien = new ArrayList<Alien>();
		
	}
	
	// Pour creer un alien
	public void creerAlien(int longueur, int level)
	{	
		// Si la liste n'est pas vide alors
		if(listeAlien.size() > 0)
		{
			Random rAlien = new Random(); // nombre aleatoire
			int x = rAlien.nextInt(10); // Entier aleatoire entre 0 et 10 
			x = x*50; // pour positionner aleatoirement l'alien
			Alien a = new Alien(x, level); // creation du nouveal alien avec sa position et son niveau
			
			// Tant que des aliens se chevauchent
			while(intersect(a))
			{
				x = rAlien.nextInt(10); // change l'entier aleatoire entre 0 et 10
				x = x*50;
				a = new Alien(x, level); // On cree un nouvel alien
			}
			listeAlien.add(a); // On ajoute l'alien cree a la liste
		}
		
		// Si la liste est vide
		else
		{
			Random rAlien = new Random(); // nombre aleatoire
			int x = rAlien.nextInt(10); // Entier aleatoire entre 0 et 10
			x = x*50; 
			Alien a = new Alien(x, level); // Creer un alien
			listeAlien.add(a); // ajoute cet alien a la liste
		}
		
	}
	
	// Pour regarder l'intersection entre deux aliens
	public boolean intersect(Alien a)
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator(); // Creation iterateur de la liste d'alien
		// tant que l'iteration possede des elements
		while(iterAlien.hasNext())
			// Si l'element suivant chevauche l'alien
			if(iterAlien.next().intersectAA(a))
				return true; // renvoie true
		return false; // sinon renvoie false
	}
	
	// Pour supprimer des aliens
	public void supprimerAlien(Alien a)
	{
		listeAlien.remove(a);
	}
	
	// Pour faire descendre des aliens
	public void descendreAliens()
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator(); // Creation iterateur de la liste d'alien
		// Tant que l'iterateur possede des elements
		while(iterAlien.hasNext())
			iterAlien.next().descendre(); // Les aliens descendent
	}

	// Pour tester le bas du panneau de jeu
	public boolean testerPlancher(int hauteur)
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator(); // Creation iterateur de la liste d'alien
		//  Tant que l'iterateur possede des elements
		while(iterAlien.hasNext())
			// Si l'alien touche le bas du panneau
			if(iterAlien.next().getY()+Alien.COTE > hauteur)
				return true; // renoie true
		return false; // Sinon renvoie false
	}
	
	// Graphisme de la liste d'alien
	public void paint(Graphics2D g2)
	{
		ListIterator<Alien> iterAlien = listeAlien.listIterator(); // Creation iterateur de la liste d'alien
		// tant que l'iterateur possede des elements
		while(iterAlien.hasNext())
			iterAlien.next().paint(g2); // Les aliens ont le graphisme d'un Alien
	}
}
