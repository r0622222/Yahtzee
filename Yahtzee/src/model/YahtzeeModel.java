package model;

import java.util.ArrayList;
import java.util.List;

public class YahtzeeModel {

	private Spel spel;
	
	public YahtzeeModel()
	{
		spel = new Spel();
	}
	
	public void voegSpelerToe(String naam)
	{
		spel.voegSpelerToe(naam);
	}
	
	public int getAantalSpelers()
	{
		return spel.aantalSpelers();
	}
	
	public List<Speler> getSpelers()
	{
		return spel.getSpelers();
	}
	
	public List<Dobbelsteen> getDobbelstenen(int speler)
	{
		return getSpelers().get(speler).getDobbelstenen();
	}
	
	public ArrayList<Categorieen> getAllCategorieen()
	{
		return Categorieen.getAllCategorieen();
	}
	
	public void startSpel()
	{
		spel.start();
	}
	
	public int huidigeSpelerAanBeurt()
	{
		return spel.huidigeSpelerAanBeurt();
	}
	
	public void zetVolgendeSpelerAanBeurt()
	{
		spel.zetVolgendeSpelerAanBeurt();
	}
	
	public List<Dobbelsteen> dobbelstenenRollen(int spelernr)
	{
		return spel.getSpelers().get(spelernr).dobbelstenenRollen();
	}
	
	public void dobbelsteenOpzijLeggen(int spelernr, int dobbelsteennr)
	{
		spel.getSpelers().get(spelernr).dobbelsteenOpzijLeggen(dobbelsteennr);
	}
}
