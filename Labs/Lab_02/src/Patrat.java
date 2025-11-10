public class Patrat extends Dreptunghi{
    private double l;

    public Patrat() {}

    public Patrat(double lungime, double latime) {
        super(lungime, latime);
    }

    public Patrat(double l) {
        super(l, l);
        this.l = l;
    }

    @Override
    public String toString() {
        return "Patrat: ";
    }

    public double getAriaPatrat() {
        return l * l;
    }
}
