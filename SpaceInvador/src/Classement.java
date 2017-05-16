import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ListIterator;

import javax.swing.table.AbstractTableModel;

public class Classement extends AbstractTableModel{
	ArrayList<Joueur> listeJoueur;

	public Classement()
	{
		listeJoueur = new ArrayList<Joueur>();
	}
	
	public int getColumnCount() {
		return 2; // une colonnes pour le score et une pour le pseudo ?
	}

	public int getRowCount() {
		return listeJoueur.size();
	}
	
	public String getColumnName(int idC)
	{
		if(idC == 0)
		{
			return new String("Pseudo");
		}
		else
		{
			return new String("Score");
		}
	}
	
	
	public Object getValueAt(int idL, int idC) 
	{
		ListIterator<Joueur> iterJoueur = listeJoueur.listIterator();
		String car = null;
		int score = 0;
		Joueur j = new Joueur();
		for(int i =0; i <= idL; i++)
		{
			j = iterJoueur.next();
			car = j.pseudo;
			score = j.score; 
		}
		
		if(idC == 0)
		{
			return car;
		}
		else
		{
			return score;
		}
	}
	
	public Class getColumnClass(int c) 
	{ 
		return getValueAt(0, c).getClass(); 
	}
	
	
}
