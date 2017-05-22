/** Permet de stocker les information sur un joueur*/
public class Joueur {
	String pseudo;
	int score;
	
	Joueur()
	{
		score = 0;
		pseudo = null;
	}
	
	Joueur(String p)
	{
		pseudo = p;
		score = 0;
	}
	
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(pseudo);
		buf.append(" ");
		buf.append(score);
		return buf.toString();
	}
}
