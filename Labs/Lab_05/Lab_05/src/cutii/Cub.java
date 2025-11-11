package cutii;

public class Cub implements ICutie {
    private double l;

    public Cub(double l) {
        this.l = l;
    }

    public double getL() { return l; }

    @Override
    public double getSuprafataTotala() {
        return 6 * l * l;
    }

    @Override
    public double getLungimePanglica() {
        // folosește formula paralelipiped cu l=L=h
        double L = l;
        double h = l;
        double lung = 2 * (L + h) + 2 * (l + L);
        return lung + ICutie.lnod;
    }

    @Override
    public String toString() {
        return "Cutie - Cub{l=" + l + "}";
    }
}
