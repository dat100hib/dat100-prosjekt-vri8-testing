## Oppgave 1: Ferdiggjøre implementasjon av KortSamling, Hand og Bunke

Den første oppgaven er å ferdiggjøre implementasjon av klassen `KortSamling` i `modell`-pakken `no.hvl.dat100.prosjekt.modell`.

### Oppgave 1.1 - Studer klassene Kort og Kortfarge

I modell-pakken finnes allerede implementasjon av klasser for `Kort` og `Kortfarge` som skal danne grunnlag for implementasjon av `KortSamling`. Ideen er at et objekt av klassen `Kort` representerer et kort i spillet.

Klassen `Kortfarge` er en oppramstype (se avsnitt 6.6) som skal brukes til å representere de ulike kort farger.

Begynn med å se på klassen `Kort` slik du får et overblikk over hvilke metoden som finnes i klassen og dermed hvilke metoder som kan utføres på objekter av denne klassen. Dette vil du få bruk for senere. Du bør dels se på koden men også se igjennom JavaDoc dokumentasjon for klassen.

### Oppgave 1.2 - Implementere Samlinger av Kort

Denne klassen skal brukes til å representere til-bunken, fra-bunken samt de kort som nord og syd har på handen. Her skal vi gjøre bruk av referansetabeller som beskrevet i avsnitt 6.4 i boken.

Start med metodene i klassen `KortSamling` som skal gjøre det mulig å lagre en samling av kort i en tabell etter samme prinsipp som brukt i oppgave 3 på programmeringslab 7:

https://github.com/dat100hib/dat100public/blob/master/programmering/jplab7/JP7.md#oppgave-3---klasser

Kommentarene i koden for `KortSamling` beskriver hva de ulike metodene skal gjøre.

Test metodene som implementeres i `KortSamling`-klassen ved å bruke enhetstestene for klassen som finnes i pakken `no.hvl.dat100.prosjekt.modell.tester.`
