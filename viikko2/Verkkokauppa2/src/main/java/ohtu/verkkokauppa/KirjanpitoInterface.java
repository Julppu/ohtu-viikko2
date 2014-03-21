
package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 * @author Juha Lindqvist
 */

public interface KirjanpitoInterface {
    ArrayList<String> getTapahtumat();
    void lisaaTapahtuma(String tapahtuma);
}
