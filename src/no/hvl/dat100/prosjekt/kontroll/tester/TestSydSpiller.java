package no.hvl.dat100.prosjekt.kontroll.tester;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat100.prosjekt.kontroll.SydSpiller;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.kontroll.Spiller;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.Kortfarge;

public class TestSydSpiller {

	@Test
	public void TestTomKonstruktor() {
		
		Spiller spiller = new TSpiller();
		
		assertEquals(0, spiller.getAntallKort());
		assertEquals(0, spiller.getHand().getAntalKort());
		assertEquals(0, spiller.getAntallTrekk());
		assertEquals(Spillere.INGEN, spiller.hvem());
	}
	
	@Test
	public void TestKonstruktor() {
		
		SydSpiller spiller = new SydSpiller(Spillere.SYD);
		
		assertEquals(0, spiller.getAntallKort());
		assertEquals(0, spiller.getHand().getAntalKort());
		assertEquals(0, spiller.getAntallTrekk());
		assertEquals(Spillere.SYD, spiller.hvem());
	}

	@Test
	public void TestnesteHandlingTom() {
		
		SydSpiller spiller = new SydSpiller(Spillere.SYD);
		
		assertTrue(spiller.getHand().erTom());
		
		Handling handling = spiller.nesteHandling(new Kort (Kortfarge.Hjerter,9));
		assertTrue(handling.getType() == HandlingsType.TREKK);
	}
	
	
	@Test
	public void TestnesteHandlingKort() {
		
		SydSpiller spiller = new SydSpiller(Spillere.SYD);
		
		Kort kort1 = new Kort (Kortfarge.Hjerter,9);
		Kort kort2 = new Kort (Kortfarge.Spar,10);
		Kort kort3 = new Kort (Kortfarge.Spar,11);
		
		spiller.leggTilKort(kort1);
		spiller.leggTilKort(kort2);
		spiller.leggTilKort(kort3);
		
		Handling handling = spiller.nesteHandling(new Kort (Kortfarge.Spar,7));
		
		assertEquals(HandlingsType.LEGGNED, handling.getType());
		assertEquals(kort2, handling.getKort());
		assertEquals(0, spiller.getAntallTrekk());
	}
	
	@Test
	public void TestnesteHandlingTrekk() {
		
		SydSpiller spiller = new SydSpiller(Spillere.SYD);
		
		Kort kort1 = new Kort (Kortfarge.Hjerter,9);
		Kort kort2 = new Kort (Kortfarge.Spar,10);
		Kort kort3 = new Kort (Kortfarge.Spar,11);
		
		spiller.leggTilKort(kort1);
		spiller.leggTilKort(kort2);
		spiller.leggTilKort(kort3);
		
		Handling handling = spiller.nesteHandling(new Kort (Kortfarge.Ruter,7));
		
		assertEquals(HandlingsType.TREKK, handling.getType());
	}
	
	@Test
	public void TestnesteHandlingForbi() {
		
		SydSpiller spiller = new SydSpiller(Spillere.SYD);
		
		Kort kort1 = new Kort (Kortfarge.Hjerter,9);
		Kort kort2 = new Kort (Kortfarge.Spar,10);
		Kort kort3 = new Kort (Kortfarge.Spar,11);
		
		spiller.leggTilKort(kort1);
		spiller.leggTilKort(kort2);
		spiller.trekker(kort3);
		
		Handling handling = spiller.nesteHandling(new Kort (Kortfarge.Ruter,7));
		
		assertEquals(HandlingsType.FORBI, handling.getType());
	}
}
