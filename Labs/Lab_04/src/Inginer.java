public class Inginer extends Persoana implements IAngajat {
    private int id;
    private double coeficientSalarial = 1.5;
    private int nrOreLucrate;

    public Inginer(String nume, String prenume, int nrOreLucrate, int id) {
        super(nume, prenume);
        this.id = id;
        setNrOreLucrate(nrOreLucrate);
    }

    public Inginer(String nume, String prenume, int id) {
        super(nume, prenume);
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Inginer %s (id=%d) a lucrat %d ore salariu=%.1f",super.toString(), getId(), nrOreLucrate, getSalariu());
    }

    @Override
    public void setNrOreLucrate(int nrOreLucrate) {
        if (nrOreLucrate > 250) {
            nrOreLucrate = 250;
        } else {
            nrOreLucrate = nrOreLucrate;
        }
    }

    public double getSalariu() {
        double salariuOrarInginer = salariuOrarMinim * coeficientSalarial;

        return salariuOrarInginer;
    }

    @Override
    public int getId() {
        return id;
    }
}
