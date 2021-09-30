## 4. Ekstraoppgaver

For de som har tid og lyst finnes nedenfor noen ideer til å utvikle vri-åtter spillet videre. Noen av de er mer krevende så denne delen er frivillig.

### 4.1 - Best av N runder

Utvid programmet så det blir mulig for *Nord* og *Syd* å spille best av *N* runder. Undersøk om *Nord* eller *Syd* sin strategi ser ut til å være best.

For å implementere spill i *N* runder, se på metodene `startSpill` og `spillAuto` i `Kontroll`-klassen. Den siste blir utført når brukeren trykker på *Play*-knappen i brukergrensesnittet.

### 4.2 - Bedre strategi for Syd

Hvis oppgave 8.1 ovenfor indikerer at *Nord* sin strategi er best, forsøk da å implementere en strategi for *Syd* som er bedre enn *Nord* sin.

Noen tips og ideer til inspirasjon

-	Man tar hensyn til kortene man har på hånd. Det kan være en god ide at det spilles den fargen vi har flest av. Det betyr at om kløver 3 ligger på toppen av til-bunken og vi har: kløver 4, kløver 7, kløver 9 og ruter 3, så spilles en kløver og ikke ruter 3.
- Ta hensyn til hvilke kort som ligger i til-bunken. Disse er i prinsippet kjent (om spilleren er flink til å huske kort)
- Husk på at motstander har ikke lovlige kort å spille når man sier forbi.
- Ta hensyn til motstanders strategi når denne kjent.

Strategien kan implementeres ved å endre i klassen `SydSpiller.java`. Alternativt kan man lage en ny klasse `Strategi.java` etter malen fra `SydSpiller` og så endre hvilken type spiller-objekt som blir oprettet for syd i `start()`-metoden i `Spill.java`-klassen.

### 4.3 - Konkurranse med andre grupper

Finn en annen gruppe i klassen og undersøk/konkurrer om hvem som er kommet opp med den beste strategien. Dette kan gjøres ved å endre i hvilke objekter som opprettes for syd og nord i  `start()`-metoden i `Spill.java`-klassen.
