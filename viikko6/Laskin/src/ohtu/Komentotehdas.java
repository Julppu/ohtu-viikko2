package ohtu;

import javax.swing.JTextField;

public class Komentotehdas {
    
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;

    public Komentotehdas(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }

    public Komento hae(String operaatio) {
        if (operaatio.equals("summa")) {
            return new Summa(sovellus, tuloskentta, syotekentta);
        } else if (operaatio.equals("erotus")) {
            return new Erotus(sovellus, tuloskentta, syotekentta);
        } else if (operaatio.equals("nollaus")) {
            return new Nollaa(sovellus, tuloskentta, syotekentta);
        }
        return null;
    }
}