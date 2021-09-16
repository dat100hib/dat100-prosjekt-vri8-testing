## Oppgave 2: Implementasjon av Spiller og Spill-klassene

Andre oppgaven er å implementere metodene i klassen Spiller og Spill i kontroll-delen av applikasjonen som finnes pakken no.hib.dat100.prosjekt.kontroll. 

Start med metodene i klassen Spiller som skal brukes til å representere en spiller i spillet, herunder de kort som en spiller har på hånden og hvor mange ganger spilleren har trukket fra bunken. Interfacet (kontakten) ISpiller beskriver de mulige operasjoner på en Spiller.

Test implementasjonen ved bruk av enhets-testene for klassen som finnes i test-klassen TestSpiller i pakken no.hib.dat100.prosjekt.kontroll.tester.

Neste steg er å implementere klassen Spill som inneholder metoder for de handlinger som kan skje i selve spillet, de to spillere (nord og syd), samt til-bunken og fra-bunken. Der finnes allerede implementasjon av Java-klasser (Handling.java og HandlingsType.java) for å representere handlinger (trekk, forbi, leggned) samt en Java-klasse (Regler.java) som implementerer de grunnleggende regler i spillet. Videre finnes en klasse Tur.java som brukes til å holde rede på hvem sin tur det er i spillet.

Test implementasjonen av Spill-klassen ved å bruke enhets-testene for Spill klassen som finnes i test-klassen TestSpill i pakken no.hib.dat100.prosjekt.kontroll.tester.

Hvis implementasjonen av Spiller og Spill er gjort korrekt, skal det nå være mulig å bruke det grafiske brukergrensesnitt som spiller Syd og spille mot spiller Nord (som implementerer en automatisk spiller). Pilen i midten av bordet angir hvem som har tur. Syd legger ned et kort i til-bunken ved å klikke på kortet, trekker fra fra-bunken ved å klikke på fra-bunken og sier forbi ved å trykke på pilen i midten. Man kan få Nord til å gjøre en handling ved å trykke på ikonet for Nord spilleren. Tallene i grensesnittet forteller hvor mange kort Nord har og hvor mange kort der er i fra-bunken og til-bunken. Hvis man trykker på Start startes en ny omgang.
