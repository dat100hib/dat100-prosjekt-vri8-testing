package no.hib.dat100.prosjekt.kontroll.tester;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hib.dat100.prosjekt.kontroll.Handling;
import no.hib.dat100.prosjekt.kontroll.HandlingsType;
import no.hib.dat100.prosjekt.kontroll.FirstFitSpiller;
import no.hib.dat100.prosjekt.kontroll.Spiller;
import no.hib.dat100.prosjekt.kontroll.Spillere;
import no.hib.dat100.prosjekt.modell.Kort;
import no.hib.dat100.prosjekt.modell.Kortfarge;

public class TestFirstFitSpiller {

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
		
		FirstFitSpiller spiller = new FirstFitSpiller(Spillere.SYD);
		
		assertEquals(0, spiller.getAntallKort());
		assertEquals(0, spiller.getHand().getAntalKort());
		assertEquals(0, spiller.getAntallTrekk());
		assertEquals(Spillere.SYD, spiller.hvem());
	}

	@Test
	public void TestnesteHandlingTom() {
		
		FirstFitSpiller spiller = new FirstFitSpiller(Spillere.SYD);
		
		assertTrue(spiller.getHand().erTom());
		
		Handling handling = spiller.nesteHandling(new Kort (Kortfarge.Hjerter,9));
		assertTrue(handling.getType() == HandlingsType.TREKK);
	}
	
	
	@Test
	public void TestnesteHandlingKort() {
		
		FirstFitSpiller spiller = new FirstFitSpiller(Spillere.SYD);
		
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
		
		FirstFitSpiller spiller = new FirstFitSpiller(Spillere.SYD);
		
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
		
		FirstFitSpiller spiller = new FirstFitSpiller(Spillere.SYD);
		
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
