package cutii;

public class Cub implements ICutie{
    protected double latura;

    public Cub(double latura) {
        this.latura = latura;
    }

    @Override
    public double getSuprafataTotala() {
        return 6*Math.pow(latura,2);
    }

    @Override
    public double getLungimePanglica() {
        return (int)(2*(latura+latura)+2*(latura+latura)+lnod);
    }

    @Override
    public double pret() {
        return ICutie.super.pret();
    }

    @Override
    public String toString() {
        return String.format("Cutie - CUB {l=%.1f}",latura);
    }
}
