package no.hib.dat100.prosjekt.kontroll.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import no.hib.dat100.prosjekt.kontroll.Spiller;
import no.hib.dat100.prosjekt.kontroll.Spillere;
import no.hib.dat100.prosjekt.modell.Kort;
import no.hib.dat100.prosjekt.modell.Kortfarge;

public class TestSpiller {

	@Test
	public void TestTomKonstruktor() {
		
		Spiller spiller = new TSpiller();
		
		assertEquals(0,spiller.getAntallKort());
		assertEquals(0,spiller.getHand().getAntalKort());
		assertEquals(0,spiller.getAntallTrekk());
		assertEquals(Spillere.INGEN,spiller.hvem());
	}
	
	@Test
	public void TestsetAntallTrekk() {
		
		Spiller spiller = new TSpiller();
		
		final int ANTALL = 10;
		
		spiller.setAntallTrekk(ANTALL);
		assertEquals(ANTALL,spiller.getAntallTrekk());
	}
	
	@Test
	public void TestererFerdig() {
		
		Spiller spiller = new TSpiller();
		
		assertTrue(spiller.erFerdig());
	}
	
	@Test
	public void TesterLeggTilKort() {
		
		Spiller spiller = new TSpiller();
		
		spiller.leggTilKort(new Kort(Kortfarge.Hjerter,10));
		assertFalse(spiller.erFerdig());
	}
	
	@Test
	public void TestfjernKort() {
		
		Spiller spiller = new TSpiller();
		Kort kort = new Kort(Kortfarge.Hjerter,10);
		
		spiller.leggTilKort(kort);
		assertTrue(spiller.getHand().har(kort));
		spiller.fjernKort(kort);
		assertFalse(spiller.getHand().har(kort));
	}
	
	@Test
	public void TestfjernAlleKort() {
		
		Spiller spiller = new TSpiller();
		Kort kort1 = new Kort(Kortfarge.Hjerter,10);
		Kort kort2 = new Kort(Kortfarge.Hjerter,11);
		
		spiller.leggTilKort(kort1);
		spiller.leggTilKort(kort2);
		spiller.fjernAlleKort();
		assertTrue(spiller.getHand().erTom());
	}
	
	@Test
	public void Testtrekker() {
		
		Spiller spiller = new TSpiller();
		Kort kort = new Kort(Kortfarge.Hjerter,10);
		
		spiller.trekker(kort);
		assertTrue(spiller.getHand().har(kort));
		assertEquals(1,spiller.getAntallTrekk());
	}
	
}
