package no.hib.dat100.prosjekt.modell.tester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import no.hib.dat100.prosjekt.modell.Hand;
import no.hib.dat100.prosjekt.modell.Kort;
import no.hib.dat100.prosjekt.modell.Kortfarge;

public class TestHand {

	
	@Test(timeout = 10000)
	public void testleggTil() {
		
		Hand hand = new Hand();
		
		Kort kort1 = new Kort(Kortfarge.Hjerter,1);
		Kort kort2 = new Kort(Kortfarge.Hjerter,2);
		Kort kort3 = new Kort(Kortfarge.Hjerter,3);
		
		hand.leggTil(kort1);
		hand.leggTil(kort3);
		hand.leggTil(kort2);
		
		ArrayList<Kort> kortliste = hand.toArrayList();
		
		assertEquals(kort1, kortliste.get(0));
		assertEquals(kort2, kortliste.get(1));
		assertEquals(kort3, kortliste.get(2));
		
	}

}
