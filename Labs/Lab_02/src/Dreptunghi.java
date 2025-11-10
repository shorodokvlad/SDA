public class Dreptunghi {

    private double lungime;
    private double latime;

    public Dreptunghi() {}

    public Dreptunghi(double lungime, double latime) {
        this.lungime = lungime;
        this.latime = latime;
    }

    public double getLungime() {
        return lungime;
    }

    public double getLatime() {
        return latime;
    }

    @Override
    public String toString() {
        return "(lungime = " + lungime + ", latime = " + latime + ")";
    }

    public Double getAria() {
        return lungime * latime;
    }
}
