package readme;

public class Rules {

    public Rules() {
        writeRules();
    }

    private void writeRules(){
        System.out.println("Az állatmenhely alapítvány kisállat-versenyt rendez. Mindegyik állat regisztrálásakor \n " +
                "meg kell adni az állat nevét és a születési évét. \n" +
                "Ezek a verseny során nyilván nem változhatnak. \n" +
                "Mindegyikőjüket pontozzák, pontot kapnak a szépségükre és a viselkedésükre is.\n" +
                "\n" +
                "A pontszám meghatározásakor figyelembe veszik a korukat is (csak év): \n" +
                "egy egységesen érvényes maximális kor fölött 0 pontot kapnak, \n" +
                "alatta pedig az életkor arányában veszik figyelembe a szépségre és a viselkedésre adott pontokat. \n" +
                "Minél fiatalabb, annál inkább a szépsége számít, és minél idősebb, annál inkább a viselkedése.\n" +
                " (Ha pl. 10 év a maximális kor, akkor egy 2 éves állat pontszáma: (10-2)*a szépségére adott pontok + 2* a viselkedésére kapott pontok.)\n");;
    }
}
