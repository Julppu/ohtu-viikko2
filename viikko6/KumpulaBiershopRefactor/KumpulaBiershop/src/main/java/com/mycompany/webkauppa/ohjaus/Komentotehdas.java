
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;

/**
 *
 * @author Julppu
 */
public class Komentotehdas {
    
    public Komentotehdas() {
    }

    public Komento ostoksenLisaysKoriin(Ostoskori kori, long tuoteId) {
        return new OstoksenLisaysKoriin(kori, tuoteId);
    }
    
    public Komento ostoksenPoistoKorista(Ostoskori kori, long tuoteId) {
        return new OstoksenPoistoKorista(kori, tuoteId);
    }
}
