
package ohtu;

import javax.swing.JTextField;

class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private String edellinenTulos;
    private String edellinenKomento;
    private JTextField tuloskentta;
    private JTextField syotekentta;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.edellinenTulos = null;
        this.edellinenKomento = null;
    }
    
    @Override
    public void suorita() {
            tuloskentta.setText("" + (Integer.parseInt(tuloskentta.getText()) + Integer.parseInt(syotekentta.getText())));
    }

    @Override
    public void peru() {
        tuloskentta.setText(edellinenTulos);
        syotekentta.setText(edellinenKomento);
        edellinenTulos = edellinenKomento = null;
    }
}
