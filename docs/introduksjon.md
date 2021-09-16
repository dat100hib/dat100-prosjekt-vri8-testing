## Kortspillet vri-åtter

Vri åtter er et kortspill som de fleste kjenner og det spilles med en vanlig kortstokk. Hvert kort har en farge (spar, hjerter, ruter og kløver) og en verdi (1,..,13). Verdiene 2,..,10 angis bare med tallverdien, mens de andre kortene har spesielle navn (1 = ess, 11 = knekt, 12 = dame og 13 = konge).

I vår versjon av spillet deltar det nøyaktig to spillere som vi kaller Nord og Syd. Navnet kommer fra hvordan de plasseres i det grafiske grensesnittet som er vist på figuren nedenfor.  

![](assets/markdown-img-paste-20210916151224467.png)

**TODO**: fiks figuren

En av spillerne er giver. Denne spilleren stokker kortene og deler et kort til motstanderen, så et kort til seg selv. Slik holder han/hun på til hver spiller har fått 7 kort. I applikasjonen vil det bli delt ut automatisk når man starter et nytt spill. Deretter snus øverste kortet og legges med billedsiden opp. Dette blir starten på bunken som spillerne senere spiller sine kort til (vi kaller denne bunken for til-bunken). Resten av kortene legges med billedsiden ned og blir bunken som man trekker fra (vi kaller denne bunken for fra-bunken). Kortene som en spiller har kalles en hand.

En av spillerne starter. Dette vil være den som er til venstre for giver, men i vår versjon med to spillere blir det motstanderen til den som har delt ut kort. Den som er i tur kan utføre en handling. Følgene handlingstyper er lovlige:

1.	Spille et kort til til-bunken. Det er lov å legge ned et kort som er av samme farge eller har samme verdi som kortet som ligger øverst på til-bunken. Det er også lov å spille en vilkårlig åtter. Det spilte kort, ligger nå øverst på til-bunken. Deretter blir det motstanderen sin tur.
2.	Trekke et kort fra fra-bunken. Hvis fra-bunken er tom, må man ta det øverste kort i til-bunken, stokke resten og legge de ned som den nye fra-bunken. I denne forenklede versjon av spillet kan en spiller høyst trekke et kort når det er han/hun sin tur.
3.	Si forbi (pass). Dette er kun lov etter man har trukket et kort.
Vinneren er den som først blir fri/tom for kort.

**Forenklinger**. Vanligvis kan den som spiller en åtter velge hvilken farge som skal spilles neste gang. I vår versjon, må neste spiller fortsette i samme farge som åtteren der ble lagt ned. Eksempel: Nord spiller spar 8. Da må Syd spille spar (eller en ny åtter). Det  er vanlig at man må si fra når man har bare ett kort igjen på hånd, gjerne i kombinasjon med en handling som bank i bordet. Dette vil vi se bort fra i vår versjon.  

Den delvise implementasjon av vri-åtter spillet som dere skal ta utgangspunkt i vil bli gjennomgått på introduksjonsforelesningen.

En video som viser eksempel på kjørsel av den ferdige spillapplikasjonen finnes via: https://www.youtube.com/watch?v=F2iQLU5wBXU

## 5.	Java-kildekoden for implementasjonen av spillet

Overordnet er implementasjon oppdelt etter en arkitektur som kalles modell-utsyn-kontroll som er en ofte brukt måte å strukturere en applikasjon på. Man kan lese mere om dette generelle programvarearkitekturprinsippet i Javaboken (Kapittel 15.8).

Konkret i dette prosjektet betyr det at koden er organisert i tre pakker:

-	no.hib.dat100.prosjekt.modell med de klasser som implementerer de basale data-strukturer vi skal bruke i spillet som bunke, hand, kort, kortfarge og kortsamling.
-	no.hib.dat100.prosjekt.utsyn med de klasser som implementerer det grafiske bruker-grensesnittet, herunder viser informasjon og fanger opp hendelser når der klikkes på knapper.
-	no.hib.dat100.prosjekt.kontroll som inneholder de klasser som implementerer lo-gikken i kortspillet, herunder hvem som har tur og hvilke regler som gjelder for spillet.
I tillegg finnes en pakke no.hib.dat100.prosjekt.main som inneholder en klasse med main-metoden for programmet.

Det generelle prinsipp for applikasjonen er at når brukeren gjør noe i grensesnitt så fanges dette opp i utsynet som formidler dette videre til kontrollen via metodekall. Kontroll-delen oppdaterer så modellen i henhold til den handling som brukeren har gjort. Deretter blir grensesnittet oppdatert til å vise den nye tilstanden for spillet (modellen).
