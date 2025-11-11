package magazin;

public class RolaPanglica {
    private static RolaPanglica rola = new RolaPanglica();

    private double disponibil = 10000.0;
    private double costUnitateLungime = 0.01;

    private RolaPanglica() {}

    public static RolaPanglica getRola() {
        return rola;
    }

    public double getDisponibil() {
        return disponibil;
    }

    public double getCostUnitateLungime() {
        return costUnitateLungime;
    }

    /**
     * Incearca sa taie din rola lungimea ceruta.
     * Daca suficient disponibil -> reduce si returneaza true
     * Altfel -> nu modifica si returneaza false
     */
    public boolean cumpara(double lungime) {
        if (lungime <= disponibil) {
            disponibil -= lungime;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{RolaPanglica, disponibil=" + disponibil + "}";
    }
}
