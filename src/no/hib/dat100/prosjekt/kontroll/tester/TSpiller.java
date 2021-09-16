package no.hib.dat100.prosjekt.kontroll.tester;

import no.hib.dat100.prosjekt.kontroll.Handling;
import no.hib.dat100.prosjekt.kontroll.HandlingsType;
import no.hib.dat100.prosjekt.kontroll.Spiller;
import no.hib.dat100.prosjekt.modell.Kort;

public class TSpiller extends Spiller {

	//dummy metode for å kunne teste den abstrakte klassen Spiller
	public Handling nesteHandling(Kort topp)
	{
		return new Handling(HandlingsType.TREKK,null);
	}
}
