
package ohtu.verkkokauppa;

/**
 * @author Juha Lindqvist
 */
public interface PankkiInterface {
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
