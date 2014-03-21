
package ohtu.verkkokauppa;

/**
 * @author Julppu
 */
public interface VarastoInterface {
    Tuote haeTuote(int id);
    void otaVarastosta(Tuote t);
    void palautaVarastoon(Tuote t);
    int saldo(int id);
}
