# Kalapassi
Sovellus auttaa käyttäjää pitämään kirjaa muun muuassa kalastuskerroistaan ja kalasaaliistaan. Sovellus antaa käyttäjälle pisteitä eri kaloista, jolloin käyttäjät voivat kilpailla keskenään. Sovellusta voi käyttää useampi eri henkilö omilla tunnuksilla.

## Dokumentaatio
* [Ohjelman kuvaus](https://github.com/ilkkaluu/ot-harjoitustyo/blob/master/documentation/DESIGN.md)
* [Työaikakirjanpito](https://github.com/ilkkaluu/ot-harjoitustyo/blob/master/documentation/TIME.md)  
* Arkkitehtuuri  
* [Vaativuusmäärittely](https://github.com/ilkkaluu/ot-harjoitustyo/blob/master/documentation/SRS.md)

## Releaset  
[Viikko 5](https://github.com/ilkkaluu/ot-harjoitustyo/releases/tag/viikko5)

## Ohjeita  
### Käynnistys
Projektin voi ladata GitHubista, jonka jälkeen sen voi suorittaa mm. komentorivikomennolla  
>  mvn compile exec:java -Dexec.mainClass=kalapassi.ui.KalapassiUi


## Komentorivikomennot  
### Checkstyle  
Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla  
> mvn jxr:jxr checkstyle:checkstyle  
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html
