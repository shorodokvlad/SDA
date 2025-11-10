public class Vopsitor extends Persoana implements IAngajat{
    private int id, nrOre, suprafataVopsita;
    private static double coeficientSlarial = 1.0;
    private static int nrMaxOreLucrate = 300;
    private static int suprafataMaxVopsita = 5000;

    public Vopsitor(String nume, String prenume, int id, int nrOre, int suprafataVopsita) {
        super(nume, prenume);
        this.id = id;
        setNrOreLucrate(nrOre);
        setSuprafataVopsita(suprafataVopsita);
    }

    @Override
    public void setNrOreLucrate(int nrOreLucrate) {
        nrOre = nrOreLucrate;
        if (nrOre > nrMaxOreLucrate) {
            nrOre = nrMaxOreLucrate;
        }
    }

    public void setSuprafataVopsita(int suprVopsita) {
        suprafataVopsita = suprVopsita;
        if (suprafataVopsita > suprafataMaxVopsita) {
            suprafataVopsita = suprafataMaxVopsita;
        }
    }

    @Override
    public double salariu() {
        return (salariuOrarMinim * coeficientSlarial * nrOre) + suprafataVopsita * 0.1;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s, Vopsitor, ID = %d, a lucrat %d, a vopsit %d mp - salariu= %.1f", super.toString(), id, nrOre, suprafataVopsita, salariu());
    }
}
