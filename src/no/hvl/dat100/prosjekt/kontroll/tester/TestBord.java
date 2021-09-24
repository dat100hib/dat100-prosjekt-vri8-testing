package no.hvl.dat100.prosjekt.kontroll.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat100.prosjekt.kontroll.Bord;
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
	public void testvendOversteFraBunke() {
		
			Bord bord = new Bord();
			Kort kort;
			int antallfra, antalltil;
			
			// vend første kort
			kort = bord.getBunkeFra().seSiste();
			antallfra = bord.getBunkeFra().getAntalKort();
			antalltil = bord.getBunkeTil().getAntalKort();
			
			bord.vendOversteFraBunke();
			
			assertEquals(antallfra - 1, bord.getBunkeFra().getAntalKort());
			assertEquals(antalltil + 1, bord.getBunkeTil().getAntalKort());
			
			assertFalse(bord.getBunkeFra().har(kort));
			assertTrue(bord.getBunkeTil().har(kort));
			
			assertEquals(kort,bord.getBunkeTil().seSiste());
			
			// vend andre kort
			kort = bord.getBunkeFra().seSiste();
			antallfra = bord.getBunkeFra().getAntalKort();
			antalltil = bord.getBunkeTil().getAntalKort();
			
			bord.vendOversteFraBunke();
			
			assertEquals(antallfra - 1, bord.getBunkeFra().getAntalKort());
			assertEquals(antalltil + 1, bord.getBunkeTil().getAntalKort());
			
			assertFalse(bord.getBunkeFra().har(kort));
			assertTrue(bord.getBunkeTil().har(kort));
			
			assertEquals(kort,bord.getBunkeTil().seSiste());
			
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
}
