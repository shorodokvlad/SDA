public class Gresie {
    private Dreptunghi baza;
    private double h;

    private int culoare;

    public Gresie(Dreptunghi baza, double h, int culoare) {
        if (h >= baza.getLungime() || h >= baza.getLatime()) {
            throw new IllegalArgumentException("Înălțimea trebuie să fie mai mică decât lungimea și lățimea bazei!");
        }
        this.baza = baza;
        this.h = h;
        this.culoare = culoare;
    }
    public Gresie (double L, double l, double h, int c) {
        if (h >= L || h >= l) {
            throw new IllegalArgumentException("Înălțimea trebuie să fie mai mică decât lungimea și lățimea bazei!");
        }
        baza = new Dreptunghi(L, l);
        this.h = h;
        culoare = c;
    }

    public Gresie() {
    }

    public Dreptunghi getBaza() {
        return baza;
    }

    public void setBaza(Dreptunghi baza) {
        this.baza = baza;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        if (baza != null && (h >= baza.getLungime() || h >= baza.getLatime())) {
            throw new IllegalArgumentException("Înălțimea trebuie să fie mai mică decât lungimea și lățimea bazei!");
        }
        this.h = h;
    }

    public int getCuloare() {
        return culoare;
    }

    public void setCuloare(int culoare) {
        this.culoare = culoare;
    }

    @Override
    public String toString() {
        return "Gresie: baza " + baza +
                "h = " + h +
                "culoare = " + culoare;
    }

    public double getVolum() {
        return baza.getAria() * h;
    }
}
