package cutii;

public class Paralelipiped implements ICutie {
    private double l; // mic
    private double L; // mare
    private double h;

    public Paralelipiped(double l, double L, double h) {
        this.l = l;
        this.L = L;
        this.h = h;
    }

    public double getL() { return l; }
    public double getLarga() { return L; }
    public double getH() { return h; }

    @Override
    public double getSuprafataTotala() {
        return 2 * (l * L + l * h + L * h);
    }

    @Override
    public double getLungimePanglica() {
        // conform enunț: lungimea = 2*(L+h) + 2*(l+L) + lnod
        double lung = 2 * (L + h) + 2 * (l + L);
        return lung + ICutie.lnod;
    }

    @Override
    public String toString() {
        return "Cutie - Paralelipiped{l=" + l + ", L=" + L + ", h=" + h + "}";
    }
}
