## Oppgave 1: Implementasjon av KortSamling og hjelpemetoder

Den første oppgaven er å ferdiggjøre implementasjon av klassen `KortSamling` i `modell`-pakken `no.hvl.dat100.prosjekt.modell` samt noen hjelpemetoder i `KortUtils`klassen.

### Oppgave 1.1 - Studer klassene Kort og Kortfarge

I modell-pakken finnes allerede implementasjon av klasser for `Kort` og `Kortfarge` som skal danne grunnlag for implementasjon av `KortSamling`. Ideen er at et objekt av klassen `Kort` representerer et kort i spillet.

Klassen `Kortfarge` er en oppramstype (se kapittel 6.6 i Java-boken) som skal brukes til å representere de ulike kort farger.

Studer klassen `Kort` slik at du får et overblikk over hvilke metoder som finnes i klassen og dermed hvilke metoder som kan utføres på objekter av denne klassen. Dette vil du få bruk for senere. Du bør dels se på koden men også se igjennom JavaDoc dokumentasjon for klassen.

### Oppgave 1.2 - Implementere samlinger av Kort

Denne klassen skal brukes til å representere til-bunken, fra-bunken samt de kort som nord og syd har på handen. Klassen skal også brukes senere til å implementere spill-strategi for nord og syd-spilleren.

Her skal vi gjøre bruk av referansetabeller som beskrevet i kapittel 6.4 i Java-boken.

Start med metodene i klassen `KortSamling` som skal gjøre det mulig å lagre en samling av kort i en tabell etter samme prinsipp som brukt i oppgave 3 på programmeringslab 7:

https://github.com/dat100hib/dat100public/blob/master/programmering/jplab7/JP7.md#oppgave-3---klasser

Kommentarene i koden for `KortSamling` beskriver hva de ulike metodene skal gjøre.

Test metodene som implementeres i `KortSamling`-klassen ved å bruke enhetstestene for klassen som finnes i pakken `no.hvl.dat100.prosjekt.modell.tester.`

### Oppgave 1.3 - Sortere og stokke Kort

I klassen `KortUtils` skal der implementers to metoder.

Metoden `sorter` skal sortere en samling av kort der rekkefølgen er bestemt av `compareTo`-metoden på Kort. Metoden skal senere brukes til å sortere handen for for syd slik kortene vises i en naturlig rekkfølge. Sortering og noen algoritmer for dette er beskrevet i kapittel 5.4 i Java-boken

Implementer metoden `stokk` (som skal brukes til å stokke kort). **Hint** her for du bruk for `Random`-klassen i Java til å velge en tilfeldig posisjon å sette inn et kort.
