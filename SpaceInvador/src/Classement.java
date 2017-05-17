import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ListIterator;

import javax.swing.table.AbstractTableModel;

public class Classement extends AbstractTableModel{
	ListeJoueur l;
	Joueur j;

	public Classement(ListeJoueur l)
	{
		this.l = l;
	}
	
	public int getColumnCount() {
		return 2; // une colonnes pour le score et une pour le pseudo ?
	}

	public int getRowCount() {
		return l.listeJoueur.size();
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
		ListIterator<Joueur> iterJoueur = l.listeJoueur.listIterator();
		String pseudo = null;
		j = new Joueur();
		int score = 0;
		for(int i =0; i <= idL; i++)
		{
			j = iterJoueur.next();
			pseudo = j.pseudo;
			score = j.score; 
		}
		
		if(idC == 0)
		{
			return pseudo;
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
