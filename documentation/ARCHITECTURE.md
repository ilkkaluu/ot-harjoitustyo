## Sovellusarkkitehtuuri  
### Sovellusnäkymät  
Sovelluksessa on tällä hetkellä viisi (5) eri näkymää: sisäänkirjautuminen, rekisteröityminen, päämenu, saaliin lisäys - näkymä ja henkilökohtaiset tilastot - näkymä.  

### Luokka- ja pakkauskaavio   
Sovelluksen pääolioluokat ovat User ja Fish. User, eli käyttäjä voi sisältää monta kalaa, kun samanlainen kala voi kuulua usealle käyttäjälle.

Sovelluksen UI-luokka käyttää Domainin luokkia FishService, User, ja Fish.

Domainin FishService käyttää UserDao:ta ja FishDao:ta.  

### Datan tallennus ja käsittely  
Sovellus tallentaa kalastajien rekisteröintitietoja, ja käyttäjien saamia pistemääriä DAO-rajapintojen toteuttavien luokkien avulla. DAO-luokat toteuttavat sovelluksen palvelun FishService.  

Sovellus vaatii toimiakseen ennaltamääritetyn konfigurointitiedosto config.filen, joka määrittää tekstitiedostojen nimet (users.txt, fishes.txt).  

Jokaisen käynnistyksen yhteydessä DAO-luokkien konstruktoreita kutsutaan. Konstruktorit luovat puuttuvat tiedostot tarvittaessa.  

Tallennettaessa uutta tietoa palvelu kokoaa oliot kasaan, jolloin sovellus tallentaa lisäykset tiedostoihin DAO-luokkia hyödyntäen. 

config.file:n sisältö:  
> userFile=users.txt
> fishFile=fishes.txt
