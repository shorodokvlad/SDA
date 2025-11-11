package cutii;

public class Cilindru implements ICutie {
    private double r;
    private double h;
    private static final double PI = 3.14159;

    public Cilindru(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public double getR() { return r; }
    public double getH() { return h; }

    @Override
    public double getSuprafataTotala() {
        // suprafata totala = 2*pi*r*(r+h)
        return 2 * PI * r * (r + h);
    }

    @Override
    public double getLungimePanglica() {
        // "lungimea este cea necesara pentru a înfășura de 2 ori cutia in jurul suprafeței laterale"
        // Doua inveliri => 2 * circumferinta = 2 * (2*pi*r) = 4*pi*r
        double lung = 4 * PI * r;
        // rotunjită la valoare fără zecimale
        long rot = Math.round(lung); // rotunjire la cel mai apropiat întreg
        return rot + ICutie.lnod;
    }

    @Override
    public String toString() {
        return "Cutie-Cilindru{r=" + r + ", h=" + h + "}";
    }
}
