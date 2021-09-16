package no.hib.dat100.prosjekt.modell.tester;

import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;

import no.hib.dat100.prosjekt.modell.Bunke;
import no.hib.dat100.prosjekt.modell.Kort;
import no.hib.dat100.prosjekt.modell.Kortfarge;

public class TestBunke {

	@Rule
	public TestRule globalTimeout = Timeout.seconds(30); 
	
	@Test
	public void Testtrekk() {
		Bunke bunke = new Bunke();
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
		Bunke bunke = new Bunke();
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
