public class Sofer extends Persoana implements IAngajat {
    private int id;
    private int nrOreLucrate;
    private double km;
    private double coeficientSalarial = 1.0;

    public Sofer(String nume, String prenume, int id) {
        super(nume, prenume);
        this.id = id;
    }

    public Sofer(String nume, String prenume, int id, int nrOreLucrate, double km) {
        super(nume, prenume);
        this.id = id;
        this.nrOreLucrate = nrOreLucrate;
        this.km = km;
    }

    @Override
    public void setNrOreLucrate(int nrOreLucrate) {
        if (nrOreLucrate > 300) {
            nrOreLucrate = 300;
        } else {
            nrOreLucrate = nrOreLucrate;
        }
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Override
    public double getSalariu() {
        double salariuOrarSofer = salariuOrarMinim * coeficientSalarial;
        double salariuSofer = salariuOrarSofer * nrOreLucrate + km * 0.1;

        return salariuSofer;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Sofer %s (id=%d) a lucrat %d ore, a parcurs %.0f km salariu=%.1f", super.toString(), getId(), nrOreLucrate, km, getSalariu());
    }
}
