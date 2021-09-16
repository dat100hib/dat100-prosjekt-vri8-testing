package no.hib.dat100.prosjekt.kontroll.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import no.hib.dat100.prosjekt.kontroll.ISpiller;
import no.hib.dat100.prosjekt.kontroll.Regler;
import no.hib.dat100.prosjekt.kontroll.Spill;
import no.hib.dat100.prosjekt.kontroll.Spillere;
import no.hib.dat100.prosjekt.modell.Bunke;
import no.hib.dat100.prosjekt.modell.Kort;
import no.hib.dat100.prosjekt.modell.KortSamling;
import no.hib.dat100.prosjekt.modell.Kortfarge;

public class TestSpill {

	@Test
	public void Teststart() {
		Spill spill = new Spill();

		spill.start();

		ISpiller syd = spill.getSyd();
		ISpiller nord = spill.getNord();

		Bunke bunkeTil = spill.getBunkeTil();
		Bunke bunkeFra = spill.getBunkeFra();

		assertEquals(Spillere.SYD, syd.hvem());
		assertEquals(Spillere.NORD, nord.hvem());

		assertEquals(Regler.antallKortVedStart(), syd.getAntallKort());
		assertEquals(Regler.antallKortVedStart(), nord.getAntallKort());

		assertEquals(1, bunkeTil.getAntalKort());
		assertEquals(KortSamling.MAKS_KORT_FARGE * 4 - (Regler.antallKortVedStart() * 2) - 1, bunkeFra.getAntalKort());

	}

	@Test
	public void TestsnuBunken() {
		Spill spill = new Spill();

		spill.start();

		Bunke bunkeTil = spill.getBunkeTil();
		Bunke bunkeFra = spill.getBunkeFra();

		int bunkefraantall = bunkeFra.getAntalKort();

		while (!bunkeFra.erTom()) {
			bunkeTil.leggTil(bunkeFra.trekk());
		}

		Kort overst = bunkeTil.topp();

		spill.snuTilBunken();

		bunkeTil = spill.getBunkeTil();
		bunkeFra = spill.getBunkeFra();

		assertEquals(1, bunkeTil.getAntalKort());
		assertEquals(overst, bunkeTil.topp());
		assertEquals(bunkefraantall, bunkeFra.getAntalKort());

	}

	@Test
	public void TestHenteMetoder() {
		Spill spill = new Spill();

		spill.start();
		
		assertFalse(spill.bunketilTom());
		assertFalse(spill.bunkefraTom());
		assertEquals(Regler.antallKortVedStart(), spill.antallNord());
		assertEquals(KortSamling.MAKS_KORT_FARGE * 4 - (Regler.antallKortVedStart() * 2) - 1, spill.antallBunkeFra());
		assertEquals(1, spill.antallBunkeTil());
	}
	
	@Test
	public void TesttrekkFraBunke() {
		Spill spill = new Spill();

		spill.start();
		
		ISpiller spiller = spill.getSyd();
		Bunke bunkefra = spill.getBunkeFra();
		
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
		
		Bunke bunketil = spill.getBunkeTil();
		int antallbunketil = bunketil.getAntalKort();
		
		spiller.leggTilKort(kort);
		int antallkortsspiller = spiller.getAntallKort();
		spill.leggnedKort(spiller,kort);
		
		assertEquals(antallbunketil+1, bunketil.getAntalKort());
		assertEquals(antallkortsspiller-1, spiller.getAntallKort());
		assertEquals(kort, bunketil.topp());
	}
	
	@Test
	public void TestforbiSpiller() {
		
		Spill spill = new Spill();

		spill.start();
		
		ISpiller spiller = spill.getSyd();
		
		spill.trekkFraBunke(spiller);
		spill.forbiSpiller(spiller);
		
		assertEquals(0, spiller.getAntallTrekk());
	}
}
