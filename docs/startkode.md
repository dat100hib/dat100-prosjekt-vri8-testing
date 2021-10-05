# Eclipse-prosjekt med startkode og enhetstester

Dere skal ta utgangpunkt i to Eclipse-prosjekt med Java-kode.

Det ene Eclipse-prosjekt inneholder en rekke Java-klasser som utgjør rammen rundt en spill-applikasjonen. Dere trenger ikke å legge til nye klasser, men dere skal implementere ulike metoder i klassene som er gitt.

Det andre Eclipse-prosjektet inneholder en rekke enhetstester som skal bruke til automatisk å teste den koden dere skriver.

Fremgangsmåten for å importere Java-koden inn i Eclipse er beskrevet nedenfor og også vist i video som er lagt ut på Canvas:

https://hvl.instructure.com/courses/17211/pages/programmeringsprosjekt-importere-startkode

Men viktig å lese instruksjonene nedenfor.

## Steg 1: Importere Eclipse-prosjekt med startkode (Fork + Clone + Import)

Det finnes allerede kode i Eclipse-prosjektet som implementerer brukergrensesnittet basert på rammeverket Swing (beskrevet i Java-boken, Kapittel 14).

### Fork oppbevaringsplassen med startkode

Gå inn på github på oppbevaringsplassen som inneholder start-koden:

https://github.com/dat100hib/dat100-prosjekt-startkode-2021

Begynn med å opprette en kopi av denne oppbevaringsplassen ved å bruke **fork** (se øverste høyre hjørne på github-websiden). Du vil da få en kopi av oppbevaringsplassen med startkoden på din egen github konto.

### Klone og importere startkode i Eclipse

Du må nå **klone** (laste ned) oppbevaringsplassen med kode som du opprettet ovenfor. Det er **viktig** at du **ikke** kloner https://github.com/dat100hib/dat100-prosjekt-startkode-2021, men kloner den oppbevaringsplassen som du opprettet på din egen konto da du utførte fork ovenfor.

1.	Velg *Code* på github-siden

2.	Velg lenken og last ned en kopi (clone) oppbevaringsplassen på samme måten som du har gjort i Eclipse i tidligere oppgaver for å importere.

Du skal nå ha et prosjekt i Eclipse med navnet `dat100prosjekt-startcode`

Eclipse-prosjektet er organisert i et antall pakker med en pakke til hver av oppgavene i prosjektet. Pakkene inneholder de klasser og metoder som gruppen skal implementere i oppgavene som presenteres nedenfor.

De steder i koden hvor der skal implementeres Java-kode er merket med en kommenter og teksten `TODO`. Disse plassene i koden kan lett identifiseres ved at de gir en blå markering i høyresiden av editor-vinduet i Eclipse.

For å gjøre det enklere ifm. presentasjon av oppgaven å finne de plassene hvor dere har lagt til kode, anbefales det å la kommentarene med `TODO – START` og `TODO SLUTT` bli stående i koden.  

### Java-kildekoden for implementasjonen av spillet

Overordnet er implementasjon oppdelt etter en arkitektur som kalles *modell-utsyn-kontroll* som er en ofte brukt måte å strukturere en større applikasjon på. Man kan lese mere om dette generelle programvarearkitekturprinsippet i Javaboken (Kapittel 15.8).

Konkret i dette prosjektet betyr det at koden er organisert i tre pakker:

-	`no.hvl.dat100.prosjekt.modell` med klasser som implementerer de basale data-strukturer vi skal bruke i spillet som bunke, hand, kort, kortfarge og kortsamling.
-	`no.hvl.dat100.prosjekt.utsyn` med de klasser som implementerer det grafiske bruker-grensesnittet, herunder viser informasjon og fanger opp hendelser når der klikkes på knapper.
-	`no.hvl.dat100.prosjekt.kontroll` som inneholder de klasser som implementerer logikken i kortspillet, herunder hvem som har tur og hvilke regler som gjelder for spillet.

I tillegg finnes en pakke `no.hvl.dat100.prosjekt.main` som inneholder en klasse med `main`-metoden for programmet.

Oppgavene i prosjektet handler om implementasjon av klasser/metoder i modell og kontroll-delen. Der bør ikke være behov for å gjøre endringer i det grensesnittet (dvs. klassene i pakken `no.hvl.dat100.prosjekt.utsyn`).

Det generelle prinsipp for applikasjonen er at når brukeren gjør noe i grensesnitt så fanges dette opp i utsynet som formidler dette videre til kontrollen via metodekall. Kontroll-delen oppdaterer så modellen i henhold til den handling som brukeren har gjort. Deretter blir grensesnittet oppdatert til å vise den nye tilstanden for spillet (modellen).

### Dokumentasjon av metoder og Javadoc

For å gjøre det enklere å finne ut hva de ulike metoder i klassene skal gjøre er der på forhånd skrevet dokumentasjon ved bruk av Javadoc-verktøyet. Dokumentasjonen i HTML format er tilgjengelig i folderen *doc* i Eclipse-prosjektet. Vanligvis vil denne beskrive for andre hvordan metoder i klassene skal brukes. Nå vil den også inneholde tips om hvordan ting kan implementeres.

## Steg 2: Eclipse-prosjekt med enhetstester (Clone + Import)

Formålet med enhetstestene er å gjøre det enklere å teste metoder etterhvert som de implementeres uten å skulle starte selve spill-applikasjonen. Et Eclipse-prosjekt med ferdige enhetstester finnes på følgende github oppbevaringsplass:

https://github.com/dat100hib/dat100-prosjekt-testing-2021

## Klone og importere enhetstester i Eclipse

Du **kloner** oppbevaringsplassen og importerer inn i Eclipse på samme måten som tidligere, men nå med oppbevaringsplassen gitt i lenken ovenfor. Du trenger **ikke** å gjøre fork på denne oppbevaringsplassen først siden du ikke trenger din egen kopi av oppbevaringsplassen på github.

Du skal nå ha et prosjekt i Eclipse med navnet `dat100prosjekt-testing` som inneholder en rekke enhetstester (unit-tests) implementert ved bruk av rammeverket JUnit. Det er ikke et krav i prosjektet å legge til flere enhetstester.

Enhets-test for implementasjonen er organisert i to pakker:

-	`no.hvl.dat100.prosjekt.modell.tester` som inneholder enhetstest for klassene i modell-pakken som skal implementeres i oppgave 1.
-	`no.hvl.dat100.prosjekt.modell.kontroll` som inneholder enhetstest for klassene i kontroll-pakken som skal implementeres i oppgave 2 og 3.

Konvensjonen er at enhetstester for en klasse `X.java` er implementert i filen med navn `TestX`.java. Eksempelvis inneholder klassen `TestKortSamling.java` enhetstester for klassen `KortSamling.java` hvor dere skal implementere metoder.

## Utføre JUnit enhetstest

En test-klasse med enhetstest utføres ved å velge test-klassen etterfulgt av *Run As → JUnit Test*. Man kan kjøre alle testene i en test-pakke ved å velge pakken etterfulgt av *Run As → JUnit Test*. Alle testene i Eclipse-prosjektet kjøres ved å velge prosjektet etterfulgt av *Run As → JUnit Test*.

Det er god/anbefalt praksis å gjenta testene når det gjøres endringer/forbedringer i implementasjonen av en metode. Det anbefales også å teste etterhvert som de enkelte metoder implementeres. Enhetstestene er ikke komplette, men tester basale ting for metodene i de klasser som dere skal implementere.

Etterhvert som de grunnleggende metoder implementeres kan applikasjonen også testes via det grafiske brukergrensesnittet.

Enhetstesting og test-drevet utvikling er et tema senere i studiet og det er et generellt godt ingeniørprinsipp å teste komponentene sine før de settes sammen til et større system.

## Dele oppbevaringsplass mellom gruppemedlemmer

Det enbefales at gruppen bruker en felles github-oppbevaringsplass for koden som utvikles. Det er derfor tilstrekkelig at en i gruppen utfører steg 1 ovenfor og gir de andre medlemmene i gruppen tilgang til oppbevaringsplassen (repository). Dette kan gjøres ved å logge inn på https://www.github.com, gå til oppbevaringsplassen og via *Settings* og *Manage access* for oppbevaringsplassen og legge til de andre medlemmer i gruppen som *Collaborators*.

De andre gruppemedlemmene må da klone oppbevaringsplassen ned på egen PC ved å velge *File → Import → Git → Projects from Git → Clone URI* i Eclipse og lime inn URL’en til den felles oppbevaringsplassen. Endringer i filer i prosjektet lastes opp til den felles oppbevaringsplassen ved å bruke  *Team | Add to Index* etterfulgt av *Team | Commit … | Commit and Push* og hentes ned ved å bruke *Team | Pull*.

For å unngå konflikter ifm. endringer i koden bør du utføre *Team | Pull* får du begynner å gjøre endringer og det er god praksis ofte å gjøre pushe endringer opp til opbevaringsplasser slik de blir tilgjengelig for de andre gruppemedlemmer.
