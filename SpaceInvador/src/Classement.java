import java.util.ListIterator;

import javax.swing.table.AbstractTableModel;
// Cette classe permet de créer le tableau de classement des joueurs
public class Classement extends AbstractTableModel{
	ListeJoueur l; // Creation d'un objet listeJoueur
	// Constructeur
	public Classement(ListeJoueur l)
	{
		this.l = l;
	}
	// Nombre de colonnes
	public int getColumnCount() 	{
		return 3; // une colonne pour le pseudo et une pour le niveau et la dernière pour le score
	}
	// Nombre de ligne
	public int getRowCount() 	{
		return l.listeJoueur.size(); // correspond à la taille de la liste
	}
	// Noms des colonnes
	public String getColumnName(int idC)
	{
		if(idC == 0)
		{
			return new String("Pseudo");
		}				else if(idC == 1)		{			return new String("Niveau");		}
		else if(idC == 2)
		{
			return new String("Score");
		}		else			return null;
	}
	// Pour avoir les valeurs des cellules
	public Object getValueAt(int idL, int idC) 
	{
		ListIterator<Joueur> iterJoueur = l.listeJoueur.listIterator();
		String pseudo = null;
		int score = 0;		int level = 0;
		Joueur j;
		for(int i =0; i <= idL; i++)
		{
			j = iterJoueur.next(); // Le joueur devient le iteration suivante
			pseudo = j.pseudo; // le pseudo du joueur devient le pseudo case
			level = j.level; // Le niveau du joueur devient le niveau de la case			score = j.score; // le score du joueur devient le score de la case
		}
		// la colonne 1 prendra le pseudo
		if(idC == 0)
		{
			return pseudo;
		}		// La colonne 2 prendra le niveau		else if(idC == 1)		{			return level;		}
		// Et la colonne 3 le score
		else
		{
			return score;
		}
	}
	// Pour retourner les valeurs des cellules des colonnes
	public Class getColumnClass(int c) 
	{
		return getValueAt(0, c).getClass();
	}
	
	
}
