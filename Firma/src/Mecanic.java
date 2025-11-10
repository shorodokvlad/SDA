public class Mecanic extends Persoana implements IAngajat{
    private int id;
    private int nrOre;
    private static double coeficientSlarial = 1.5;
    private static int nrMaxOreLucrate = 250;

    public Mecanic(String nume, String prenume, int id, int nrOre) {
        super(nume, prenume);
        this.id = id;
        setNrOreLucrate(nrOre);
    }

    @Override
    public void setNrOreLucrate(int nrOreLucrate) {
        nrOre = nrOreLucrate;
        if (nrOre > nrMaxOreLucrate) {
            nrOre = nrMaxOreLucrate;
        }
    }

    @Override
    public double salariu() {
        return salariuOrarMinim * coeficientSlarial * nrOre;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s, Mecanic, ID = %d, a lucrat %d - salariu= %.1f", super.toString(), id, nrOre, salariu());
    }
}
