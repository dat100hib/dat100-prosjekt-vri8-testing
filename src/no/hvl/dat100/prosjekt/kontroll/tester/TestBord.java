package no.hvl.dat100.prosjekt.kontroll.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat100.prosjekt.kontroll.Bord;
import no.hvl.dat100.prosjekt.kontroll.ISpiller;
import no.hvl.dat100.prosjekt.kontroll.Spill;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.Kortfarge;

class TestBord {

	@Test
	public void testConstructor () {
	
			Bord bord = new Bord();
			
			assertNotNull(bord.getBunkeFra());
			assertNotNull(bord.getBunkeTil());
			
			assertEquals(4 * Regler.MAKS_KORT_FARGE,bord.getBunkeFra().getAntalKort());
			assertEquals(0,bord.getBunkeTil().getAntalKort());
			
			for (Kortfarge f : Kortfarge.values()) {
				for (int i = 1; i <= Regler.MAKS_KORT_FARGE; i++) {
					assertTrue(bord.getBunkeFra().har(new Kort(f,i)));
				}
			}
			
	}
	
	@Test
	public void TestHenteMetoder() {
		
		Bord bord = new Bord();
		
		assertNotNull(bord.getBunkeFra());
		assertNotNull(bord.getBunkeTil());
		
		assertEquals(Regler.MAKS_KORT_FARGE * 4, bord.antallBunkeFra());
		assertEquals(0, bord.antallBunkeTil());
	}
	
	@Test
	public void TesterTom() {
		
		Bord bord = new Bord();
		
		assertFalse(bord.bunkefraTom());
		assertTrue(bord.bunketilTom());
	}
	
	@Test
	public void testvendOversteFraBunke() {
		
			Bord bord = new Bord();
			Kort kort;
			int antallfra, antalltil;
			
			// vend første kort
			kort = bord.getBunkeFra().seSiste();
			antallfra = bord.antallBunkeFra();
			antalltil = bord.antallBunkeTil();
			
			bord.vendOversteFraBunke();
			
			assertEquals(antallfra - 1, bord.antallBunkeFra());
			assertEquals(antalltil + 1, bord.antallBunkeTil());
			
			assertFalse(bord.getBunkeFra().har(kort));
			assertTrue(bord.getBunkeTil().har(kort));
			
			assertEquals(kort,bord.getBunkeTil().seSiste());
			
			// vend andre kort
			kort = bord.getBunkeFra().seSiste();
			antallfra = bord.antallBunkeFra();
			antalltil = bord.antallBunkeTil();
			
			bord.vendOversteFraBunke();
			
			assertEquals(antallfra - 1, bord.antallBunkeFra());
			assertEquals(antalltil + 1, bord.antallBunkeTil());
			
			assertFalse(bord.getBunkeFra().har(kort));
			assertTrue(bord.getBunkeTil().har(kort));
			
			assertEquals(kort,bord.getBunkeTil().seSiste());
			
	}
	
	@Test
	public void TesttaOversteFraBunke() {
		
		Bord bord = new Bord();
		
		KortSamling bunkefra = bord.getBunkeFra();
		
		int antallbunke = bord.antallBunkeFra();
		
		Kort k1 = bord.getBunkeFra().seSiste();
		Kort k2 = bord.taOversteFraBunke();
		
		assertEquals(k1,k2);
		assertEquals(antallbunke-1, bord.antallBunkeFra());
	}
	
	@Test
	public void TestseOversteTilBunke() {
		
		Bord bord = new Bord();
		
		bord.vendOversteFraBunke();
		
		int antallbunke = bord.antallBunkeTil();
		Kort k1 = bord.getBunkeTil().seSiste();
		Kort k2 = bord.seOversteBunkeTil();
		
		assertEquals(k1,k2);
		assertEquals(antallbunke, bord.antallBunkeTil());
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
	public void TestleggnedBunkeTil() {
		
		Bord bord = new Bord();
		
		Kort kort = new Kort(Kortfarge.Hjerter,1);
		
		int antalltil = bord.antallBunkeTil();
		
		bord.leggNedBunkeTil(kort);
		
		assertEquals(antalltil+1, bord.antallBunkeTil());
		assertEquals(kort, bord.seOversteBunkeTil());
	}
}
