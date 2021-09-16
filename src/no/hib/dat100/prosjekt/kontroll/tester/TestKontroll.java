package no.hib.dat100.prosjekt.kontroll.tester;

import org.junit.Test;

import no.hib.dat100.prosjekt.kontroll.Kontroll;

public class TestKontroll {

	private static final int TIMEOUT = 10000; // 10 sekunder
	
	// test som i hovedsak cheker om der reises noen exceptions
	@Test(timeout = TIMEOUT)
	public void TestAutoSpill() {
		Kontroll kontroll = new Kontroll();
		
		kontroll.startSpill();
		kontroll.spillAuto();
	}

	private static int ANTALL_SPILL = 10;
	
	@Test
	public void TestAutoSpillRandom() {
		
		for (int i = 1; i<ANTALL_SPILL; i++)
			TestAutoSpill();
	}
}
