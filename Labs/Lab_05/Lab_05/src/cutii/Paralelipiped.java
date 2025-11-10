package cutii;

public class Paralelipiped implements ICutie {
    private double lungime;
    private double latime;
    private double h;

    public Paralelipiped(double lungime, double latime, double h) {
        this.lungime = lungime;
        this.latime = latime;
        this.h = h;
    }

    @Override
    public double getSuprafataTotala() {
        return 2 * (h * lungime + h * latime + lungime * latime);
    }

    @Override
    public double getLungimePanglica() {
        return (int)(2 * (lungime + h) + 2 * (lungime + latime) + lnod);
    }

    @Override
    public double pret() {
        return ICutie.super.pret();
    }

    @Override
    public String toString() {
        return String.format("Cutie - Paralelipiped {l=%.1f, L=%.1f, h=%.1f}",lungime,latime, h);

    }
}
