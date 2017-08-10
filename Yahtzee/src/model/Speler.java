package model;

import java.util.ArrayList;
import java.util.List;

import model.spelerState.SpelerAanBeurt;
import model.spelerState.SpelerNietAanBeurt;
import model.spelerState.SpelerState;

public class Speler {

	private String naam;
	private int score;
	private List<Dobbelsteen> dobbelstenen = new ArrayList<>();
	private SpelerState state;
	private int aantalKeerGerold;
	public static final int ROL_KANSEN = 3;
	private Categorieen huidigeCategorie;

	public Speler(String naam)
	{
		this.setNaam(naam);
		this.score = 0;
		this.setState(new SpelerNietAanBeurt(this));
		this.genereerDobbelstenen();
		this.setAantalKeerGerold(0);
		this.setCategorie(Categorieen.ACES);
	}
	
	public SpelerState getState() {
		return state;
	}

	public void setState(SpelerState state) {
		this.state = state;
	}

	public String getNaam() {
		return naam;
	}

	private void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) throw new DomainException("Naam mag niet leeg zijn!");
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	private void setScore(int score) {
		this.score = score;
	}
	
	public List<Dobbelsteen> getDobbelstenen() {
		return dobbelstenen;
	}

	public void setDobbelstenen(List<Dobbelsteen> dobbelstenen) {
		this.dobbelstenen = dobbelstenen;
	}

	public List<Dobbelsteen> dobbelstenenRollen()
	{
		if (this.getAantalKeerGerold() == this.ROL_KANSEN) throw new DomainException("Je hebt al drie keer gerold!");
		state.dobbelstenenRollen();
		this.spelerHeeftEenKeerGerold();
		System.out.println(getAantalKeerGerold());
		return getDobbelstenen();
	}
	
	public void dobbelsteenOpzijLeggen(int dobbelsteen)
	{
		state.dobbelsteenOpzijLeggen(dobbelsteen);	
	}
	
	public void beeindigBeurt()
	{
		state.beeindigBeurt();
	}
	
	public void beginBeurt()
	{
		state.beginBeurt();
	}
	
	private void genereerDobbelstenen()
	{
		for (int i = 0; i < 5; i++)
		{
			dobbelstenen.add(new Dobbelsteen());
		}
	}
	
	public void voegPuntenToe(int punten)
	{
		score += punten;
	}
	
	public int getAantalKeerGerold() {
		return aantalKeerGerold;
	}

	public void setAantalKeerGerold(int aantalKeerGerold) {
		this.aantalKeerGerold = aantalKeerGerold;
	}
	
	public void spelerHeeftEenKeerGerold()
	{
		this.aantalKeerGerold++;
	}
	
	public void setCategorie(Categorieen categorie)
	{
		this.huidigeCategorie = categorie;
	}
	
	public void updateCategorie(Categorieen categorie)
	{
		state.updateCategorie(categorie);
	}
}
