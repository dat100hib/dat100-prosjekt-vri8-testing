package no.hvl.dat100.prosjekt.modell.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.modell.*;

public class TestKortSamling {

	@Rule
	public TestRule globalTimeout = Timeout.seconds(30); 

	private Kort kort1,kort2,kort3;
	private KortSamling samling;
	
	private void setUp() {
		
		samling = new KortSamling();
		
		kort1 = new Kort(Kortfarge.Hjerter,1);
		kort2 = new Kort(Kortfarge.Hjerter,2);
		kort3 = new Kort(Kortfarge.Hjerter,3);
		
		samling.leggTil(kort1);
		samling.leggTil(kort3);
		samling.leggTil(kort2);
	}

	@Test
	public void TestConstructor() {

		KortSamling samling = new KortSamling();
				
		Kort[] samlingen = samling.getSamling();
				
		assertNotNull(samlingen);
		
		assertEquals(4 * Regler.MAKS_KORT_FARGE, samlingen.length);
		
		assertEquals(0, samling.getAntalKort());

	}
	
	@Test
	public void TestleggTilHar() {

		setUp();
		assertEquals(3, samling.getAntalKort());
		
		assertTrue(samling.har(kort1));
		assertTrue(samling.har(kort2));
		assertTrue(samling.har(kort3));
		
		Kort kort = new Kort(Kortfarge.Spar,1);
		
		assertFalse(samling.har(null));
		assertFalse(samling.har(kort));
	}

	@Test
	public void erTom() {

		KortSamling samling = new KortSamling();

		assertTrue(samling.erTom());
		
		Kort kort = new Kort(Kortfarge.Hjerter,1);
		
		samling.leggTil(kort);
		
		assertFalse(samling.erTom());
		
	}
	
	@Test
	public void testleggtilAlle() {
	
		KortSamling samling = new KortSamling();
		
		samling.leggTilAlle();
		
		assertEquals(4 * Regler.MAKS_KORT_FARGE,samling.getAntalKort());
		
		for (Kortfarge f : Kortfarge.values()) {
			for (int i = 1; i <= Regler.MAKS_KORT_FARGE; i++) {
				assertTrue(samling.har(new Kort(f, i)));
			}
		}
	}
		
	@Test
	public void TestfjernAlle() {

		setUp();	
		samling.fjernAlle();

		assertFalse(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertFalse(samling.har(kort3));
		
		assertEquals(0,samling.getAntalKort());
		assertTrue(samling.erTom());
	}
	
	@Test
	public void TestseSiste() {

		KortSamling tomsamling = new KortSamling();
		
		assertNull(tomsamling.seSiste());
		
		setUp();
		
		assertEquals(kort2, samling.seSiste());
		
		assertEquals(3, samling.getAntalKort());
		
	}

	@Test
	public void TesttaSiste() {
			
		setUp();
		
		assertEquals(kort2, samling.taSiste());
		assertEquals(2, samling.getAntalKort());
		
		assertEquals(kort3, samling.taSiste());
		assertEquals(1, samling.getAntalKort());
		
		assertEquals(kort1, samling.taSiste());
		assertEquals(0, samling.getAntalKort());
		
		assertNull(samling.taSiste());
		
	}

	@Test
	public void Testfjern() {

		setUp();
		
		assertTrue(samling.fjern(kort2));
		
		assertEquals(2, samling.getAntalKort());
		assertTrue(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
		
		// fjern kort som ikke finnes
		Kort kort = new Kort(Kortfarge.Spar,1);
		assertFalse(samling.fjern(kort));
		
		assertEquals(2, samling.getAntalKort());
		assertTrue(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
		
		// fjerne null kort
		assertFalse(samling.fjern(null));
		assertEquals(2, samling.getAntalKort());
		assertTrue(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
				
		assertTrue(samling.fjern(kort1));
		
		assertEquals(1, samling.getAntalKort());
		assertFalse(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
		
		
		assertTrue(samling.fjern(kort3));
		
		assertEquals(0, samling.getAntalKort());
		assertFalse(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertFalse(samling.har(kort3));
		assertFalse(samling.har(null));
		
		// fjern fra tom samling
		assertFalse(samling.fjern(kort));
		assertEquals(0, samling.getAntalKort());
		assertFalse(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertFalse(samling.har(kort3));
		assertFalse(samling.har(null));
		
	}
	
	@Test
	public void TestgetAlleKort() {

		KortSamling tomsamling = new KortSamling();
		
		Kort[] allekort = tomsamling.getAllekort();
		
		assertNotNull(allekort);
		assertEquals(0,allekort.length);
		
		setUp();
		
		allekort = samling.getAllekort();
		assertEquals(3,allekort.length);
		
		assertEquals(kort1,allekort[0]);
		assertEquals(kort3,allekort[1]);
		assertEquals(kort2,allekort[2]);
		
	}
}
