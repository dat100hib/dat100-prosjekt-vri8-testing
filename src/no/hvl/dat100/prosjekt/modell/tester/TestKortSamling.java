package no.hvl.dat100.prosjekt.modell.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.Kortfarge;

public class TestKortSamling {

	@Rule
	public TestRule globalTimeout = Timeout.seconds(30); 

	@Test
	public void TestConstructor() {

		TKortSamling samling = new TKortSamling();
		
		assertEquals(0, samling.getAntalKort());
		
		Kort[] samlingen = samling.getSamling();
		assertNotNull(samlingen);
		assertTrue(samling.erTom());
	}

	@Test
	public void TestleggTil() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		assertEquals(3, samling.getAntalKort());
		assertTrue(samling.har(kort1));
		assertTrue(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
	}

	@Test
	public void TestseSiste() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		assertEquals(kort3, samling.seSiste());
		assertEquals(3, samling.getAntalKort());
	}

	@Test
	public void TesttaSiste() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		assertEquals(kort3, samling.taSiste());
		assertEquals(2, samling.getAntalKort());
	}

	@Test
	public void Testfjern() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		samling.fjern(kort2);

		assertTrue(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
	}

	@Test
	public void TestfjernAlle() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		samling.fjernAlle();

		assertFalse(samling.har(kort1));
		assertFalse(samling.har(kort2));
		assertFalse(samling.har(kort3));
		assertTrue(samling.erTom());
	}

	@Test
	public void Teststokk() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		assertEquals(3, samling.getAntalKort());
		assertTrue(samling.har(kort1));
		assertTrue(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
	}

	@Test
	public void TesttoArrayList() {

		TKortSamling samling = new TKortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter, 1);
		Kort kort2 = new Kort(Kortfarge.Hjerter, 2);
		Kort kort3 = new Kort(Kortfarge.Hjerter, 3);

		samling.leggTil(kort1);
		samling.leggTil(kort2);
		samling.leggTil(kort3);

		ArrayList<Kort> kortarray = samling.toArrayList();

		assertEquals(3, kortarray.size());
		assertEquals(kort1, kortarray.get(0));
		assertEquals(kort2, kortarray.get(1));
		assertEquals(kort3, kortarray.get(2));

	}
}
