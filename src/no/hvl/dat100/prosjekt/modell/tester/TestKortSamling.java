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

import no.hvl.dat100.prosjekt.modell.*;

public class TestKortSamling {

	@Rule
	public TestRule globalTimeout = Timeout.seconds(30); 

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

		KortSamling samling = new KortSamling();
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

		KortSamling samling = new KortSamling();
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

		KortSamling samling = new KortSamling();
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

		KortSamling samling = new KortSamling();
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

		KortSamling samling = new KortSamling();
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

		KortSamling samling = new KortSamling();
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

		KortSamling samling = new KortSamling();
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
	
	@Test(timeout = 10000)
	public void testleggTilSorter() {
		
		KortSamling hand = new KortSamling();
		
		Kort kort1 = new Kort(Kortfarge.Hjerter,1);
		Kort kort2 = new Kort(Kortfarge.Hjerter,2);
		Kort kort3 = new Kort(Kortfarge.Hjerter,3);
		
		hand.leggTilSorter(kort1);
		hand.leggTilSorter(kort3);
		hand.leggTilSorter(kort2);
		
		ArrayList<Kort> kortliste = hand.toArrayList();
		
		assertEquals(kort1, kortliste.get(0));
		assertEquals(kort2, kortliste.get(1));
		assertEquals(kort3, kortliste.get(2));
		
	}

	@Test
	public void Testtrekk() {
		KortSamling bunke = new KortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter,1);
		Kort kort2 = new Kort(Kortfarge.Hjerter,2);
		Kort kort3 = new Kort(Kortfarge.Hjerter,3);
		
		bunke.leggTil(kort1);
		bunke.leggTil(kort2);
		bunke.leggTil(kort3);
		
		Kort kort = bunke.trekk();
		
		assertEquals(kort3,kort);
		assertEquals(2, bunke.getAntalKort());
	}
	
	@Test
	public void Testtopp() {
		KortSamling bunke = new KortSamling();
		Kort kort1 = new Kort(Kortfarge.Hjerter,1);
		Kort kort2 = new Kort(Kortfarge.Hjerter,2);
		Kort kort3 = new Kort(Kortfarge.Hjerter,3);
		
		bunke.leggTil(kort1);
		bunke.leggTil(kort2);
		bunke.leggTil(kort3);
		
		Kort kort = bunke.topp();
		
		assertEquals(kort3, kort);
		assertEquals(3, bunke.getAntalKort());
	}
}
