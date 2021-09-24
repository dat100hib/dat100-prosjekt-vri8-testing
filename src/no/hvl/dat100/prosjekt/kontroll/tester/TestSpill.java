package no.hvl.dat100.prosjekt.kontroll.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import no.hvl.dat100.prosjekt.kontroll.ISpiller;
import no.hvl.dat100.prosjekt.kontroll.Spill;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.Kortfarge;

public class TestSpill {

	@Test
	public void Teststart() {
		Spill spill = new Spill();

		spill.start();

		ISpiller syd = spill.getSyd();
		ISpiller nord = spill.getNord();

		KortSamling bunkeTil = spill.getBord().getBunkeTil();
		KortSamling bunkeFra = spill.getBord().getBunkeFra();

		assertEquals(Spillere.SYD, syd.hvem());
		assertEquals(Spillere.NORD, nord.hvem());

		assertEquals(Spill.ANTALL_KORT_START, syd.getAntallKort());
		assertEquals(Spill.ANTALL_KORT_START, nord.getAntallKort());

		assertEquals(1, bunkeTil.getAntalKort());
		assertEquals(Regler.MAKS_KORT_FARGE * 4 - (Spill.ANTALL_KORT_START * 2) - 1, bunkeFra.getAntalKort());

	}

	@Test
	public void TestsnuBunken() {
		Spill spill = new Spill();

		spill.start();

		KortSamling bunkeTil = spill.getBord().getBunkeTil();
		KortSamling bunkeFra = spill.getBord().getBunkeFra();

		int bunkefraantall = bunkeFra.getAntalKort();

		while (!bunkeFra.erTom()) {
			bunkeTil.leggTil(bunkeFra.taSiste());
		}

		Kort overst = bunkeTil.seSiste();

		spill.getBord().snuTilBunken();

		bunkeTil = spill.getBord().getBunkeTil();
		bunkeFra = spill.getBord().getBunkeFra();

		assertEquals(1, bunkeTil.getAntalKort());
		assertEquals(overst, bunkeTil.seSiste());
		assertEquals(bunkefraantall, bunkeFra.getAntalKort());

	}

	@Test
	public void TestHenteMetoder() {
		Spill spill = new Spill();

		spill.start();
		
		assertFalse(spill.getBord().bunketilTom());
		assertFalse(spill.getBord().bunkefraTom());
		assertEquals(Spill.ANTALL_KORT_START, spill.antallNord());
		assertEquals(Regler.MAKS_KORT_FARGE * 4 - (Spill.ANTALL_KORT_START * 2) - 1, spill.getBord().antallBunkeFra());
		assertEquals(1, spill.getBord().antallBunkeTil());
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
}
