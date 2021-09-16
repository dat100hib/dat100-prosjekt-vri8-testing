# Eclipse-prosjekt med startkode og enhetstester

Dere skal ta utgangpunkt i to Eclipse-prosjekt.

Det ene Eclipse-prosjekt inneholder en rekke Java-klasser som utgjør rammen rundt en sykkelcomputer-applikasjonen. Dere trenger ikke å legge til nye klasser, men dere skal implementere ulike metoder i klassene som er gitt.

Det andre Eclipse-prosjektet inneholder en rekke enhetstester som skal bruke til automatisk å teste den koden dere skriver.

Fremgangsmåten for å importere Java-koden inn i Eclipse er beskrevet nedenfor og også vist i video som er lagt ut på Canvas: https://hvl.instructure.com/courses/13433/pages/programmeringsprosjekt-importere-startkode

Det finnes allerede kode i Eclipse-prosjektet som implementerer brukergrensesnittet basert på rammeverket Swing (beskrevet i Java-boken, Kapittel 14). Oppgavene i prosjektet handler om implementasjon av klasser/metoder i modell og kontroll-delen. Der bør ikke være behov for å gjøre endringer i det grensesnittet (dvs. klassene i pakken no.hib.dat100.prosjekt.utsyn).

Dokumentasjon av metoder og Javadoc
For å gjøre det enklere å finne ut hva de ulike metoder i klassene skal gjøre er der på forhånd skrevet dokumentasjon ved bruk av Javadoc-verktøyet. Dokumentasjonen i HTML format er tilgjengelig i folderen «doc» i Eclipse-prosjektet. Vanligvis vil denne beskrive for andre hvordan metoder i klassene skal brukes. Nå vil den også inneholde tips om hvordan ting kan implementeres.

Testing av metoder som implementeres
For å gjøre det mulig å teste metoder etterhvert som de implementeres uten å skulle starte selve spillet (hoved-applikasjonen) finnes to pakker i Eclipse-prosjekt (se avsnitt 7, nedenfor) som inneholder en rekke enhetstester (unit-tests) implementert ved bruk av rammeverket JUnit. Det er ikke et krav at dere i prosjektet legger til flere enhetstester.


## Steg 1: Eclipse-prosjekt med startkode (Fork + Clone + Import)

### Fork oppbevaringsplassen

Gå inn på github på oppbevaringsplassen som inneholder start-koden:

https://github.com/dat100hib/dat100-prosjekt-startkode-2020

Begynn med å opprette en kopi av denne oppbevaringsplassen ved å bruke "fork" (se øverste høyre hjørne på github-websiden). Du vil da få en kopi av oppbevaringsplassen med startkoden på din egen github konto.

### Klone og importere startkode i Eclipse

Du må nå laste ned (klone) oppbevaringsplassen med kode som du opprettet ovenfor. Det er **viktig** at du **ikke** kloner https://github.com/dat100hib/dat100-prosjekt-startkode-2020 men den oppbevaringsplassen som du opprettet på din egen konto da du utførte fork.

1.	Velg *Code* på github-siden

2.	Velg lenken og last ned en kopi (clone) oppbevaringsplassen på samme måten som du har gjort i Eclipse i tidligere oppgaver for å importere.

Du skal nå ha et prosjekt i Eclipse med navnet `dat100ptc-startcode`

Eclipse-prosjektet er organisert i et antall pakker med en pakke til hver av oppgavene i prosjektet. Pakkene inneholder de klasser og metoder som gruppen skal implementere i oppgavene som presenteres nedenfor.

De steder i koden hvor der skal implementeres Java-kode er merket med en kommenter og teksten `TODO`. Disse plassene i koden kan lett identifiseres ved at de gir en blå markering i høyresiden av editor-vinduet i Eclipse.

For å kjøre det enklere ifm. presentasjon av oppgaven å finne de plassene hvor dere har lagt til kode, anbefales det å la kommentarene med `TODO – START` og `TODO SLUTT` bli stående i koden.  

## Steg 2: Eclipse-prosjekt med enhetstester (Clone + Import)

Formålet med enhetstestene er å gjøre det enklere å teste metoder etterhvert som de implementeres uten å skulle starte selve sykkelcomputer-applikasjonen. Et Eclipse-prosjekt med ferdige enhetstester finnes på følgende github oppbevaringsplass:

https://github.com/dat100hib/dat100-prosjekt-testing-2020

Du kloner oppbevaringsplassen og importerer inn i Eclipse på samme måten som tidligere men nå med oppbevaringsplassen gitt i lenken ovenfor. Du trenger **ikke** å gjøre fork på denne oppbevaringsplassen først siden du ikke trenger din egen kopi av oppbevaringsplassen på github.

Du skal nå ha et prosjekt i Eclipse med navnet `dat100ptc-testing` som inneholder en rekke enhetstester (unit-tests) implementert ved bruk av rammeverket JUnit. Det er ikke et krav i prosjektet å legge til flere enhetstester.

Konvensjonen er at enhetstester for en klasse `X.java` er implementert i filen med navn `XTester`.java. Eksempelvis inneholder klassen `GPSUtilsTester.java` enhetstester for klassen `GPSUtils.java` hvor dere skal implementere metoder.

## Utføre JUnit enhetstest

En test-klasse med enhetstest utføres ved å velge test-klassen etterfulgt av *Run As → JUnit Test*. Man kan kjøre alle testene i en test-pakke ved å velge pakken etterfulgt av *Run As → JUnit Test*. Alle testene i Eclipse-prosjektet kjøres ved å velge prosjektet etterfulgt av *Run As → JUnit Test*.

Det er god/anbefalt praksis å gjenta testene når det gjøres endringer/forbedringer i implementasjonen av en metode. Det anbefales også å teste etterhvert som de enkelte metoder implementeres. Enhetstestene er ikke komplette, men tester basale ting for metodene i de klasser som dere skal implementere.

Enhetstesting og test-drevet utvikling er et tema senere i studiet og det er et generelt godt ingeniørprinsipp å teste komponentene sine før de settes sammen til et større system.

I mappen `logs` i Eclipse-prosjektet finnes tre CSV filer filer: `short.log`, `medium.log`, `long.log` og `vm.log` med GPS data punkter som kan brukes som input til Java sykkelcomputeren.

7.	Testing av Implementasjonen
For å gjøre det enklere å teste metoder etterhvert som de implementeres uten å skulle starte selve spillet (hoved-applikasjonen) finnes et Eclipse-prosjekt (se avsnitt 7, nedenfor) inneholdende en rekke enhetstester (unit-tests) implementert ved bruk av rammeverket JUnit.

Etterhvert som de grunnleggende metoder implementeres kan applikasjonen også testes via det grafiske brukergrensesnitt. Enhets-test for implementasjonen er organisert i to pakker:

	no.hib.dat100.prosjekt.modell.tester som inneholder enhetstest for klassene i modell-pakken som skal implementeres i oppgave 1.
	no.hib.dat100.prosjekt.modell.kontroll som inneholder enhetstest for klas-sene i kontroll-pakken som skal implementeres i oppgave 2 og 3.
Konvensjonen er at enhetstest for en klasse X.java er implementert i filen TestX.java.  

En test-klasse med enhetstest utføres ved å velge test-klassen etterfulgt av Run As → JUnit Test. Man kan kjøre alle testene i en test-pakke ved å velge pakken etterfulgt av Run As → JUnit Test. Alle testene i Eclipse-prosjektet kjøres ved å velge prosjektet etterfulgt av Run As → JUnit Test.

Det er god/anbefalt praksis å gjenta testene når det gjøres endringer/forbedringer i implementasjonen av en klasse. Det anbefales også å teste etterhvert som de enkelte metoder implementeres.

Enhetstestene er ikke komplette, men tester basale ting for metodene i de klasser som dere skal implementere. Enhetstesting og test-drevet utvikling er et tema senere i studiet og det er et generellt godt ingeniørprinsipp å teste komponentene sine før de settes sammen til et større system.


## Dele oppbevaringsplass mellom gruppemedlemmer

Hvis gruppen ønsker å bruke en felles github-oppbevaringsplass for koden som utvikles, er det tilstrekkelig at en i gruppen utfører steg 1 ovenfor og gir de andre medlemmene i gruppen tilgang til oppbevaringsplassen (repository). Dette kan gjøres ved å logge inn på https://www.github.com, gå til oppbevaringsplassen og via *Settings* og *Manage access* for oppbevaringsplassen legge til de andre medlemmer i gruppen som *Collaborators*.

De andre gruppemedlemmene må da klone oppbevaringsplassen ned på egen PC ved å velge *File → Import → Git → Projects from Git → Clone URI* i Eclipse og lime inn URL’en til den felles oppbevaringsplassen. Endringer i filer i prosjektet lastes opp til den felles oppbevaringsplassen ved å bruke  *Team | Add to Index* etterfulgt av *Team | Commit … | Commit and Push* og hentes ned ved å bruke *Team | Pull*.
