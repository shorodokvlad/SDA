public class EcuatieGrad1
{
    private double a;
    private double b;

    public EcuatieGrad1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a +"x " + (b < 0 ? "":"+") + b + " = 0";
    }

    public Double rezolva() {
        if (a == 0) return null;

        return -b/a;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }
}
