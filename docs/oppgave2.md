## Oppgave 2: Implementasjon av Bord, Spiller og Spill-klassene

Andre oppgaven er å implementere metodene i klassene `Bord`, `Spiller` og `Spill` i kontroll-delen av applikasjonen som finnes pakken `no.hvl.dat100.prosjekt.kontroll`.

For å representere identiteten på spillere finnes oppramsklassen `Spillere.java`.

### Oppgave 2.1 - Bord-klassen

Klassen `Bord` skal brukes til å representere bordet som spilles på og de to bunker kort, til-bunken og fra-bunken. Metodene i klassen skal brukes i andre deler av spillet.

Hva de ulike metodene skal gjøre er beskrevet i Java Doc for klassen `Bord.java`

Test implementasjonen ved bruk av enhets-testene for klassen som finnes i test-klassen `TestBord` i pakken `no.hvl.dat100.prosjekt.kontroll.tester`.

### Oppgave 2.2 - Spiller-klassen

Metodene i klassen `Spiller` som skal brukes til å representere en spiller i spillet, herunder de kort som en spiller har på hånden og hvor mange ganger spilleren har trukket fra bunken.

Hva de ulike metodene skal gjøre er beskrevet i Java Doc for klassen `Spiller.java` samt Java Doc for interfacet `ISpiller.java`.

Interfacet (kontrakten) `ISpiller.java` beskriver de mulige operasjoner på en `Spiller`. Vi har ennå kommer til interfaces i faget. Men kort fortalt kan et interface kan brukes til å spesifisere hvilke metoder som skal finnes/implementeres av en klasse.

Test implementasjonen ved bruk av enhets-testene for klassen som finnes i test-klassen `TestSpiller` i pakken `no.hvl.dat100.prosjekt.kontroll.tester`.

### Oppgave 2.3 - Spill-klassen

Neste steg er å implementere klassen `Spill` som inneholder metoder for de handlinger som kan skje i selve spillet, de to spillere (nord og syd), samt til-bunken og fra-bunken.

Der finnes allerede implementasjon av Java-klasser (`Handling.java` og `HandlingsType.java`) for å representere handlinger (*trekk*, *forbi*, *leggned*) samt en Java-klasse (`Regler.java`) som implementerer de grunnleggende regler i spillet. Videre finnes en klasse `Tur.java` som brukes til å holde rede på hvem sin tur det er i spillet. Begynn med å se på koden i disse klassene.

Test implementasjonen av `Spill`-klassen ved å bruke enhets-testene for Spill klassen som finnes i test-klassen `TestSpill.java` i pakken `no.hvl.dat100.prosjekt.kontroll.tester`.

### Oppgave 2.4 - Spill via brukergrensesnitt

Hvis implementasjonen av `Bord`, `Spiller` og `Spill` er gjort korrekt, skal det nå være mulig å bruke det grafiske brukergrensesnitt som spiller *Syd* og spille mot spiller *Nord* (som implementerer en automatisk spiller).

Pilen i midten av bordet angir hvem som har tur. Syd legger ned et kort i til-bunken ved å klikke på kortet, trekker fra fra-bunken ved å klikke på fra-bunken og sier forbi ved å trykke på pilen i midten. Man kan få *Nord* til å gjøre en handling ved å trykke på ikonet for *Nord* spilleren. Tallene i grensesnittet forteller hvor mange kort *Nord* har og hvor mange kort der er i fra-bunken og til-bunken. Hvis man trykker på *Start* startes en ny omgang (et nytt spill).
