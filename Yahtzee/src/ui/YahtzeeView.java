package ui;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YahtzeeView {
	
	private List<Speelveld> velden = new ArrayList<Speelveld>();
	
	public String getSpelerNaam()
	{
		String naam = JOptionPane.showInputDialog("Wat is uw naam?");
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
}
