
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    private int kasvatuskoko = 5;
    // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;
    // Joukon luvut säilytetään taulukon alkupäässä.

    public IntJoukko() {
        ljono = new int[5];
        Arrays.fill(ljono, 0);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        Arrays.fill(ljono, 0);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0)
            return;
        ljono = new int[kapasiteetti];
        Arrays.fill(ljono, 0);
        if (kasvatuskoko > 0)
            this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (ljono.length == 0) {
            ljono = new int[kasvatuskoko];
            Arrays.fill(ljono, 0);
            ljono[0] = luku;
            return true;
        }
        if (!kuuluu(luku)) {
            for (int i = 0; i < ljono.length; i++) {
                if (ljono[i] == 0) {
                    ljono[i] = luku;
                    break;
                }
            }
            if (ljono.length % alkioita() == 0) {
                int[] taulukkoOld = ljono;
                ljono = new int[ljono.length + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, ljono);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < ljono.length; i++) {
            if (luku == ljono[i])
                return true;
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < ljono.length; i++) {
            if (luku == ljono[i]) {
                ljono[i] = 0;
                Arrays.sort(ljono);
                return true;
            }
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int size() {
        return ljono.length;
    }
        
    public int alkioita() {
        int alkioita = 0;
        for (int i = 0; i < ljono.length; i++)
            if (ljono[i] != 0)
                alkioita++;
        return alkioita;
    }

    @Override
    public String toString() {
        if (ljono.length == 0)
            return "{}";
        
        String tuotos = "{";
        for (int i = 0; i < ljono.length - 1; i++) {
            if (ljono[i] != 0) {
                if (tuotos.length() > 1)
                    tuotos += ", ";
                tuotos += ljono[i];
            }
        }
        return tuotos + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioita()];
        int alkioita = 0;
        for (int i = 0; i < ljono.length; i++)
            if (ljono[i] != 0)
                taulu[alkioita++] = ljono[i];
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }
 
        return z;
    }
        
}