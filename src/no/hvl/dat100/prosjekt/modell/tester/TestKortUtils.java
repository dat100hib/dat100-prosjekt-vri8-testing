package no.hvl.dat100.prosjekt.modell.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.modell.Kortfarge;

class TestKortUtils {

	@Rule
	public TestRule globalTimeout = Timeout.seconds(30); 

	
	@BeforeEach
	void setUp() throws Exception {
	}

	public void testleggTilSorter() {
		
		KortSamling hand = new KortSamling();
		
		Kort kort1 = new Kort(Kortfarge.Hjerter,1);
		Kort kort2 = new Kort(Kortfarge.Hjerter,2);
		Kort kort3 = new Kort(Kortfarge.Hjerter,3);
		
		hand.leggTil(kort1);
		hand.leggTil(kort3);
		hand.leggTil(kort2);
		
		KortUtils.sorter(hand);
		ArrayList<Kort> kortliste = KortUtils.toArrayList(hand);
		
		assertEquals(kort1, kortliste.get(0));
		assertEquals(kort2, kortliste.get(1));
		assertEquals(kort3, kortliste.get(2));
		
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

		ArrayList<Kort> kortarray = KortUtils.toArrayList(samling);

		assertEquals(3, kortarray.size());
		assertEquals(kort1, kortarray.get(0));
		assertEquals(kort2, kortarray.get(1));
		assertEquals(kort3, kortarray.get(2));

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

		KortUtils.stokk(samling);
		
		assertEquals(3, samling.getAntalKort());
		assertTrue(samling.har(kort1));
		assertTrue(samling.har(kort2));
		assertTrue(samling.har(kort3));
		assertFalse(samling.har(null));
	}
}
