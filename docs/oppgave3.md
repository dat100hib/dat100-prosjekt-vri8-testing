## Oppgave 3: Implementasjon av første-som-kan-brukes (first-fit) strategi for Syd

Selv for et såpass enkelt spill som vri-åtter, kan det utvikles mange strategier.

### Oppgave 3.1 - Random strategien

I prosjektet finnes allerede en implementasjon (`RandomSpiller.java`) av en strategi i metoden `nesteHandling` som finner ut hvilken handling som *Nord* skal gjøre som det neste (når det er *Nord* sin tur).

Strategien for *Nord* er å gå gjennom alle kortene som nord har på hånden og se hvilke som er lovlig å spille. Deretter trekker nord et tilfeldig (random) som spilles. Det betyr at vi ikke tar hensyn til hvilke kort *Nord* har igjen. *Nord* spiller bare en åtter om det er eneste lovlige kort som kan spilles.

Studer implementasjon av metoden `nesteHandling` i klassen `RandomSpiller` for å forstå hvordan en strategi kan implementeres. Dette skal brukes i oppgaven nedenfor

### Oppgave 3.2 - First-fit strategi

Oppgaven er nå å implementere en enklere strategi for *Syd* i metoden `nesteHandling` i klassen `FirstFitSpiller.java` så *Syd* kan spille automatisk mot *Nord*. *Syd* sin strategi skal være å gå gjennom sine kort og spille det første (first-fit) som kan spilles (også om det er en åtter).

Implementasjonen av strategien kan testes først ved bruk av enhets-testen for `FirstFitSpiller` og enhetstestene i `TestKontroll`.

Om dette er implementert korrekt kan man trykke på *Play* knappen i spillet og så vil *Syd* spille automatisk med *Nord* utefra deres strategier. Trykkes på ikonet til *Syd* spilleren vil grensesnitt fremheve det kort som Syd sin strategi foreslår.

Applikasjonen har en implementasjon av en dommer (klassen `Dommer.java`) som sjekker at de handlinger som strategien for spillerne foreslår er lovlig i vri-åtter før de utføres. Loggen i Eclipse vil vise om en spiller forsøker å gjøre en ulovlig handling (se etter ordet **WARNING**).
