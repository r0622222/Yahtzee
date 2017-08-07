package model;

import java.util.ArrayList;
import java.util.List;

public class Spel {

	private List<Speler> spelers = new ArrayList<>();
	
	private SpelState state;
	
	public Spel()
	{
		setState(new RegisteredState());	
	}
	
	public void setState(SpelState state)
	{
		this.state = state;
	}
	
	public void voegSpelerToe(String naam)
	{
		if (naam == null) throw new DomainException("Speler is null!");
		if (spelerBestaatAl(naam)) throw new DomainException("Deze naam werd al ingegeven!");
		state.voegSpelerToe(this, new Speler(naam));
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
}
