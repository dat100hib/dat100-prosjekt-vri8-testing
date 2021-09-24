package no.hvl.dat100.prosjekt.modell.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
		
		Kort[] samling = hand.getSamling();
				
		assertEquals(3, hand.getAntalKort());
		
		assertEquals(kort1, samling[0]);
		assertEquals(kort2, samling[1]);
		assertEquals(kort3, samling[2]);
		
		assertFalse(hand.har(null));
		
		// sorter tom samling
		KortSamling nysamling = new KortSamling();
		
		KortUtils.sorter(nysamling);
		assertEquals(0, nysamling.getAntalKort());
		
		// sorter med et kort
		Kort kort = new Kort(Kortfarge.Spar,1);
		
		nysamling.leggTil(kort);
		KortUtils.sorter(nysamling);
		assertEquals(1, nysamling.getAntalKort());
		assertTrue(nysamling.har(kort));
		
	}

	@Test
	public void Teststokk() {

		KortUtils.stokk(hand);
		
		assertEquals(3, hand.getAntalKort());
		
		assertTrue(hand.har(kort1));
		assertTrue(hand.har(kort2));
		assertTrue(hand.har(kort3));
		
		assertFalse(hand.har(null));
		
		// stokke tom samling
		KortSamling samling = new KortSamling();
		
		KortUtils.stokk(samling);
		assertEquals(0, samling.getAntalKort());
		
		// stokk med et kort
		Kort kort = new Kort(Kortfarge.Spar,1);
		
		samling.leggTil(kort);
		KortUtils.stokk(samling);
		assertEquals(1, samling.getAntalKort());
		assertTrue(samling.har(kort));
		
	}
		
}
