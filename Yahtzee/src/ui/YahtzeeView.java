package ui;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Categorieen;

public class YahtzeeView {
	
	private List<Speelveld> velden = new ArrayList<Speelveld>();
	
	public String getSpelerNaam(int i)
	{
		String naam = JOptionPane.showInputDialog("Speler " + i + ", Wat is uw naam?");
		return naam;
	}
	
	public void showError(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void maakSpeelveldAan(String naam)
	{
		Speelveld veld = new Speelveld(naam);
		veld.launch();
		veld.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		veld.setVisible(true);
		velden.add(veld);
	}
	
	public int vraagAantalSpelers()
	{
		int aantalSpelers = 0;
		while (aantalSpelers == 0)
		{
			try {
				String aantalSpelersString = JOptionPane.showInputDialog("Wat is het aantal spelers?");
				aantalSpelers = Integer.parseInt(aantalSpelersString);
			} catch (Exception e) {
				this.showError("Gelieve een aantal groter dan 0 in cijfers te geven");
			}
			if (aantalSpelers <= 0)
			{
				this.showError("Geen negatieve cijfers!");
				aantalSpelers = 0;
			}
		}
		return aantalSpelers;
	}
	
	public void updateDobbelsteen1(String waarde, int veldnr)
	{
		velden.get(veldnr).updateDobbelsteen1(waarde);
	}
	
	public void updateDobbelsteen2(String waarde, int veldnr)
	{
		velden.get(veldnr).updateDobbelsteen2(waarde);
	}
	
	public void updateDobbelsteen3(String waarde, int veldnr)
	{
		velden.get(veldnr).updateDobbelsteen3(waarde);
	}
	
	public void updateDobbelsteen4(String waarde, int veldnr)
	{
		velden.get(veldnr).updateDobbelsteen4(waarde);
	}
	
	public void updateDobbelsteen5(String waarde, int veldnr)
	{
		velden.get(veldnr).updateDobbelsteen5(waarde);
	}
	
	public void addMouseClickListenerToRollButton(MouseListener listener)
	{
		for (Speelveld veld : velden)
		{
			veld.addMouseClickListenerToRollButton(listener);
		}
	}
	
	public void addMouseClickListenerToBeeindigBeurtButton(MouseListener listener)
	{
		for (Speelveld veld : velden)
		{
			veld.addMouseClickListenerToBeeindigBeurtButton(listener);
		}
	}
	
	public Categorieen getGeselecteerdeCategorieActieveSpeler()
	{
		return velden.get(huidigeSpelerAanBeurt()).getGeselecteerdeCategorie();
	}
	
	public void startSpel()
	{
		velden.get(0).enableRollButton();
		velden.get(0).enableBeeindigBeurtButton();
	}
	
	public int huidigeSpelerAanBeurt()
	{
		int r = 0;
		for (int i = 0; i < velden.size(); i++)
		{
			if (velden.get(i).isRollButtonEnabled()) r = i;
		}
		return r;
	}
	
	public void volgendeSpeler()
	{
		int b = huidigeSpelerAanBeurt();
		velden.get(b).disableRollButton();
		velden.get(b).disableBeeindigBeurtButton();
		velden.get((b + 1) % velden.size()).enableRollButton();
		velden.get((b + 1) % velden.size()).enableBeeindigBeurtButton();
		velden.get(b).veranderAchtergrondKleurAlleDobbelstenenDefault();
	}
	
	public void addMouseClickListenerToDobbelsteen1(MouseListener listener)
	{
		for (Speelveld veld : velden)
		{
			veld.addMouseClickListenerToDobbelsteen1(listener);
		}	
	}
	
	public void addMouseClickListenerToDobbelsteen2(MouseListener listener)
	{
		for (Speelveld veld : velden)
		{
			veld.addMouseClickListenerToDobbelsteen2(listener);
		}	
	}
	
	public void addMouseClickListenerToDobbelsteen3(MouseListener listener)
	{
		for (Speelveld veld : velden)
		{
			veld.addMouseClickListenerToDobbelsteen3(listener);
		}	
	}
	
	public void addMouseClickListenerToDobbelsteen4(MouseListener listener)
	{
		for (Speelveld veld : velden)
		{
			veld.addMouseClickListenerToDobbelsteen4(listener);
		}	
	}
	
	public void addMouseClickListenerToDobbelsteen5(MouseListener listener)
	{
		for (Speelveld veld : velden)
		{
			veld.addMouseClickListenerToDobbelsteen5(listener);
		}	
	}
	
	public void veranderAchtergrondKleurDobbelsteen(int dobbelsteennr, int veldnr)
	{
		velden.get(veldnr).veranderAchtergrondKleurDobbelsteen(dobbelsteennr);
	}
	
	public void veranderAchtergrondKleurAlleDobbelstenen(int veldnr)
	{
		
	    for(int i = 0; i < 5; i++)
		{
			veranderAchtergrondKleurDobbelsteen(i, veldnr);
		}
	}
	
} 
