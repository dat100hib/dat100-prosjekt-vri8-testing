package no.hvl.dat100.prosjekt.kontroll.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import no.hvl.dat100.prosjekt.kontroll.Bord;
import no.hvl.dat100.prosjekt.kontroll.ISpiller;
import no.hvl.dat100.prosjekt.kontroll.Spill;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.Kortfarge;

public class TestSpill {

	@Test
	public void testConstructor() {
		
		Spill spill = new Spill();
		
		assertNotNull(spill.getBord());
		assertNotNull(spill.getSyd());
		assertNotNull(spill.getNord());
		
		assertEquals(Spillere.SYD, spill.getSyd().hvem());
		assertEquals(Spillere.NORD, spill.getNord().hvem());
	}
	
	@Test
	public void teststart() {
		Spill spill = new Spill();

		Bord bord = spill.getBord();
		
		spill.start();

		ISpiller syd = spill.getSyd();
		ISpiller nord = spill.getNord();

		int antalltil = bord.antallBunkeTil();
		int antallfra = bord.antallBunkeFra();

		// check utdeling
		assertEquals(Spill.ANTALL_KORT_START, syd.getAntallKort());
		assertEquals(Spill.ANTALL_KORT_START, nord.getAntallKort());

		assertEquals(1, antalltil);
		assertEquals(Regler.MAKS_KORT_FARGE * 4 - (Spill.ANTALL_KORT_START * 2) - 1, antallfra);

	}
	
	@Test
	public void TesttrekkFraBunke() {
		Spill spill = new Spill();

		spill.start();
		
		ISpiller spiller = spill.getSyd();
		KortSamling bunkefra = spill.getBord().getBunkeFra();
		
		int antallspiller = spiller.getAntallKort();
		int antallbunke = bunkefra.getAntalKort();
		
		spill.trekkFraBunke(spiller);
		
		assertEquals(antallspiller+1, spiller.getAntallKort());
		assertEquals(1, spiller.getAntallTrekk());
		assertEquals(antallbunke-1, bunkefra.getAntalKort());
	}
	
	@Test
	public void TestleggnedKort() {
		
		Spill spill = new Spill();

		spill.start();
		
		ISpiller spiller = spill.getSyd();
		Kort kort = new Kort(Kortfarge.Hjerter,1);
		
		KortSamling bunketil = spill.getBord().getBunkeTil();
		int antallbunketil = bunketil.getAntalKort();
		
		spiller.leggTilKort(kort);
		int antallkortsspiller = spiller.getAntallKort();
		spill.leggnedKort(spiller,kort);
		
		assertEquals(antallbunketil+1, bunketil.getAntalKort());
		assertEquals(antallkortsspiller-1, spiller.getAntallKort());
		assertEquals(kort, bunketil.seSiste());
	}
	
	@Test
	public void TestforbiSpiller() {
		
		Spill spill = new Spill();

		spill.start();
		
		ISpiller spiller = spill.getSyd();
		
		spill.trekkFraBunke(spiller);
		spill.forbiSpiller(spiller);
		
		// assertEquals(0, spiller.getAntallTrekk());
	}
	
	@Test
	public void testutforhandling () {
		
		Spill spill = new Spill();
		Bord bord = spill.getBord();
		
		spill.start();
		
		ISpiller spiller = spill.getSyd();
		
		Kort[] allekort = spiller.getHand().getAllekort();
		Kort kort = allekort[0];
		
		// teste legg ned handling
		Handling handling = new Handling(HandlingsType.LEGGNED,kort);
		
		spill.utforHandling(spiller, handling);
		
		assertEquals(kort,spill.getBord().seOversteBunkeTil());
		assertFalse(spiller.getHand().har(kort));
		
		// teste forbi handling
		int antalltil = bord.antallBunkeTil();
		int antallfra = bord.antallBunkeFra();
		int antallkort = spiller.getAntallKort();
		
		handling = new Handling(HandlingsType.FORBI,null);
		spill.utforHandling(spiller, handling);
		
		assertEquals(antalltil, bord.antallBunkeTil());
		assertEquals(antallfra, bord.antallBunkeFra());
		assertEquals(antallkort, spiller.getAntallKort());
		
		// test trekk handling
		Kort kortfra = bord.getBunkeFra().seSiste();
		handling = new Handling(HandlingsType.TREKK,null);
		
		antalltil = bord.antallBunkeTil();
		antallfra = bord.antallBunkeFra();
		antallkort = spiller.getAntallKort();
		
		Kort trukket = spill.utforHandling(spiller, handling);
		
		assertNotNull(trukket);
		assertEquals(kortfra,trukket);
		assertTrue(spiller.getHand().har(trukket));
		
		assertEquals(antalltil, bord.antallBunkeTil());
		assertEquals(antallfra-1, bord.antallBunkeFra());
		assertEquals(antallkort+1, spiller.getAntallKort());
	}
}
