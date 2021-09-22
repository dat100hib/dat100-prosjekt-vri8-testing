package no.hvl.dat100.prosjekt.modell.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

	private Kort kort1,kort2,kort3;
	private KortSamling hand;
	
	@BeforeEach
	void setUp() throws Exception {
		
		hand = new KortSamling();
		
		kort1 = new Kort(Kortfarge.Hjerter,1);
		kort2 = new Kort(Kortfarge.Hjerter,2);
		kort3 = new Kort(Kortfarge.Hjerter,3);
		
		hand.leggTil(kort1);
		hand.leggTil(kort3);
		hand.leggTil(kort2);
	}

	@Test
	public void testsorter() {
			
		KortUtils.sorter(hand);
		ArrayList<Kort> kortliste = KortUtils.toArrayList(hand);
		
		assertEquals(kort1, kortliste.get(0));
		assertEquals(kort2, kortliste.get(1));
		assertEquals(kort3, kortliste.get(2));
		
	}

	@Test
	public void Teststokk() {

		KortUtils.stokk(hand);
		
		assertEquals(3, hand.getAntalKort());
		
		assertTrue(hand.har(kort1));
		assertTrue(hand.har(kort2));
		assertTrue(hand.har(kort3));
		
		assertFalse(hand.har(null));
	}
	
	@Test
	public void TesttoArrayList() {

		ArrayList<Kort> kortarray = KortUtils.toArrayList(hand);

		assertEquals(3, kortarray.size());
		assertEquals(kort1, kortarray.get(0));
		assertEquals(kort3, kortarray.get(1));
		assertEquals(kort2, kortarray.get(2));

	}
	
}
