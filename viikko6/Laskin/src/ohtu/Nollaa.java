
package ohtu;

import javax.swing.JTextField;

class Nollaa implements Komento {
    
    private Sovelluslogiikka sovellus;
    private String edellinenTulos;
    private String edellinenKomento;
    private JTextField tuloskentta;
    private JTextField syotekentta;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.edellinenTulos = null;
        this.edellinenKomento = null;
    }
    
    @Override
    public void suorita() {
        this.edellinenTulos = tuloskentta.getText();
        this.edellinenKomento = syotekentta.getText();
        tuloskentta.setText("0");
        syotekentta.setText("0");
    }

    @Override
    public void peru() {
        tuloskentta.setText(edellinenTulos);
        syotekentta.setText(edellinenKomento);
        edellinenTulos = edellinenKomento = null;
    }
}
