package magazin;

import cutii.ICutie;

public class RolaPanglica {
    private double costUnitateLungime = 0.01;
    private double lungime = 10000;
    private double disponibil;
    private static RolaPanglica instance = null;

    public RolaPanglica() {}

    public RolaPanglica(double costUnitateLungime, double disponibil) {
        this.costUnitateLungime = costUnitateLungime;
        this.disponibil = disponibil;
    }

    public static synchronized RolaPanglica getInstance() {
        if (instance == null) {
            instance = new RolaPanglica();
        }
        return instance;
    }

    public double getDisponibil(ICutie cutie) {
        double necesar = cutie.getLungimePanglica();
        if (disponibil == 0.0) {
            disponibil = lungime;
        }
        if (necesar > disponibil) {
            System.out.println("Eroare la disponibilitate in magazin");
        }
        disponibil -= necesar;

        return disponibil;
    }

    public double getCostUnitateLungime() {
        return this.costUnitateLungime;
    }

    public static RolaPanglica getRola()
    {
        return instance;
    }

    public double getDisponibil() {
        return disponibil;
    }
}
