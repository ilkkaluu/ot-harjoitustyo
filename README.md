# Kalapassi
Sovellus auttaa käyttäjää pitämään kirjaa muun muuassa kalastuskerroistaan ja kalasaaliistaan. Sovellus antaa käyttäjälle pisteitä eri kalalajeista, jolloin käyttäjät voivat kerätä mahdollisimman monta pistettä kalastuskauden aikana. Sovellusta voi käyttää useampi eri henkilö omilla tunnuksilla.

## Dokumentaatio
* [Ohjelman kuvaus](https://github.com/ilkkaluu/ot-harjoitustyo/blob/master/documentation/DESIGN.md)
* [Työaikakirjanpito](https://github.com/ilkkaluu/ot-harjoitustyo/blob/master/documentation/TIME.md)  
* Arkkitehtuuri  
* [Vaativuusmäärittely](https://github.com/ilkkaluu/ot-harjoitustyo/blob/master/documentation/SRS.md)  
* [Käyttöohje]

## Releaset  
[Viikko 5](https://github.com/ilkkaluu/ot-harjoitustyo/releases/tag/viikko5)

[Kurssin loppupalautus]()

## Komentorivikomennot    
### Käynnistys
Projektin voi ladata GitHubista, jonka jälkeen sen voi suorittaa mm. komentorivikomennolla Kalapassi/ hakemiston sisällä:  
>  mvn compile exec:java -Dexec.mainClass=kalapassi.ui.KalapassiUi  

### Testit  
Testit voidaan ajaa terminaalikomennolla:
> mvn test  

Kattavuusraportti index.html luodaan sovelluksen kansioon Kalapassi/target/site/jacoco/ komennolla:  
> mvn jacoco:report  

### Jar-tiedoston luominen  
Sovelluksen hakemistoon voidaan luoda suoritettava jar-tiedosto ohjelmasta komennolla:  
> mvn package
  
### Checkstyle  
Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla  
> mvn jxr:jxr checkstyle:checkstyle  

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html  

Checkstyle-raportti ei tarkista sovelluksen UI-luokkaa.
