package cutii;

public class Cilindru implements ICutie {
    private double raza;
    private double h;

    public Cilindru(double raza, double h) {
        this.raza = raza;
        this.h = h;
    }

    @Override
    public double getSuprafataTotala() {
        return 2*Math.PI*raza*(raza+h);
    }

    @Override
    public double getLungimePanglica() {
        return (int)(4*Math.PI*raza*h+lnod);
    }

    @Override
    public double pret() {
        return ICutie.super.pret();
    }

    @Override
    public String toString() {
        return String.format("Cutie - Cilindru {r=%.1f, h=%.1f}",raza, h);
    }
}
