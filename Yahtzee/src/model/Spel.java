package model;

import java.util.ArrayList;
import java.util.List;

import model.spelState.RegisteredState;
import model.spelState.SpelState;
import model.spelerState.SpelerAanBeurt;

public class Spel {

	private List<Speler> spelers = new ArrayList<>();
	
	private SpelState state;
	
	public Spel()
	{
		setState(new RegisteredState(this));	
	}
	
	public void setState(SpelState state)
	{
		this.state = state;
	}
	
	public void voegSpelerToe(String naam)
	{
		if (naam == null) throw new DomainException("Speler is null!");
		if (spelerBestaatAl(naam)) throw new DomainException("Deze naam werd al ingegeven!");
		state.voegSpelerToe(new Speler(naam));
	}
	
	public void start()
	{
		state.start();
		spelers.get(0).beginBeurt();
	}
	
	public List<Speler> getSpelers() {
		return spelers;
	}

	public void setSpelers(List<Speler> spelers) {
		this.spelers = spelers;
	}
	
	public boolean spelerBestaatAl(String naam)
	{
		for(Speler speler : spelers)
		{
			if (speler.getNaam().equals(naam)) return true;
		}
		return false;
	}
	
	public int aantalSpelers()
	{
		return spelers.size();
	}
	
	public int hoeveelsteSpeler(String naam)
	{
		int r = 0;
		for (int i = 0; i < spelers.size(); i++)
		{
			if (spelers.get(i).getNaam().equals(naam)) r = i;
		}
		return r;
	}
	
	public int huidigeSpelerAanBeurt()
	{
		int r = 0;
		for (int i = 0; i < spelers.size(); i++)
		{
			if (spelers.get(i).getState() instanceof SpelerAanBeurt) r = i;
		}
		return r;
	}
	
	public void zetVolgendeSpelerAanBeurt()
	{
		int b = this.huidigeSpelerAanBeurt();
		spelers.get(b).beeindigBeurt();
		spelers.get((b + 1) % this.aantalSpelers()).beginBeurt();
	}
}
