package model;

import java.util.ArrayList;

public enum Categorieen {
	ACES, 
	TWOS, 
	THREES, 
	FOURS, 
	FIVES,
	SIXES,
	THREE_OF_A_KIND,
	FOUR_OF_A_KIND,
	FULL_HOUSE,
	SMALL_STRAIGHT,
	LARGE_STRAIGHT,
	YAHTZEE,
	CHANCE;
	
	public static ArrayList<Categorieen> getAllCategorieen()
	{
		ArrayList<Categorieen> allCategorieen = new ArrayList<Categorieen>();
		for (Categorieen categorie : Categorieen.values())
		{
			allCategorieen.add(categorie);
		}
		return allCategorieen;
	}
}
