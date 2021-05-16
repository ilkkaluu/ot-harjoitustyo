# Käyttöohje  

## Konfigurointi  
Sovellus vaatii toimiakseen juurihakemistoon tiedoston config.file, jonka sisältö on:
> userFile=users.txt
> fishFile=fishes.txt  

Ohjelma käyttää edellämainittuja tekstitiedostoja tietokantana.  

## Käynnistäminen  
#### Jar-tiedosto  
Ohjelman voi ajaa ladattavan jar.tiedoston kautta komentorivikomennolla:  
> java -jar kalapassi.jar  

### Lähdekoodilla  
Ohjelman voi suoittaa myös lataamalla lähdekoodin. Tällöin ohjelman voi ajaa esim. NetBeansissa avamaalla projektin ja kirjoittamalla komentorivikomennon hakemistossa Kalapassi/:  
> mvn compile exec:java -Dexec.mainClass=kalapassi.ui.KalapassiUi  

### Kirjautumisnäkymä  
Kirjautumisnäkymssä voi kirjautua sisään käyttäjätunnuksella ja painamalla "Login"-painiketta, siirtyä rekisteröintinäkymään "Register"-linkistä tai lopettaa ohjelman painamalla "Quit"-painiketta.  

### Rekisteröintinäkymä   
Rekisteröintinäkymässä voi luoda uuden käyttäjän kirjoittamalla oman nimen ja uniikin käyttäjätunnuksen. Nimen ja käyttäjätunnuksen tulee olla 3-12 merkkiä pitkä. Rekisteröinnin saa valmiiksi painamalla "Create an account"-painiketta. Rekisteröinnin voi peruuttaa painamalla "Cancel"-painiketta.

### Päämenunäkymä  
Päämenussa voi kirjautua ulos painikkeesta "Logout", lopettaa ohjelman painikkeesta "Quit", lisätä saaliin painikkeesta "Add a catch" ja tarkastella omia tilastoja painikkeesta "Personal statistics".  

### Saalisnäkymä  
Saalisnäkymässä voi lisätä uuden saaliin itselleen valitsemalla saalislajin ja painalla "Confirm"-painiketta. "Cancel"-painiketta painama näkymä vaihtuu takaisin päämenuun ilman, että saalista lisätään.  

### Statistiikkanäkymä  
Statistiikkanäkymässä voi tarkastella omia kalastustilastojaan. "Back"-painikkeesta palataan takaisin päämenunäkymään.
