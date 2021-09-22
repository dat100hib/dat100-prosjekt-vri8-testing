package no.hvl.dat100.prosjekt.modell.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import no.hvl.dat100.prosjekt.modell.*;

public class TestKortSamling {

	@Rule
	public TestRule globalTimeout = Timeout.seconds(30); 

	private Kort kort1,kort2,kort3;
	private KortSamling samling;
	
	@BeforeEach
	void setUp() throws Exception {
		
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
		
		assertEquals(0, samling.getAntalKort());
		
		Kort[] samlingen = samling.getSamling();
		assertNotNull(samlingen);
		assertTrue(samling.erTom());
	}

	@Test
	public void TestleggTil() {

		assertEquals(3, samling.getAntalKort());
		
		assertTrue(samling.har(kort1));
		assertTrue(samling.har(kort2));
		assertTrue(samling.har(kort3));
		
		assertFalse(samling.har(null));
	}

	@Test
	public void TestseSiste() {

		assertEquals(kort2, samling.seSiste());
		
		assertEquals(3, samling.getAntalKort());
	}

	@Test
	public void TesttaSiste() {

		assertEquals(kort2, samling.taSiste());
		
		assertEquals(2, samling.getAntalKort());
	}

	@Test
	public void Testfjern() {

		samling.fjern(kort2);

		assertTrue(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertTrue(samling.har(kort3));
		
		assertFalse(samling.har(null));
	}

	@Test
	public void TestfjernAlle() {

		samling.fjernAlle();

		assertFalse(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertFalse(samling.har(kort3));
		
		assertTrue(samling.erTom());
	}
}
