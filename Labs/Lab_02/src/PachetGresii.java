public class PachetGresii extends Gresie {
    private int id_pachet;
    private Gresie gresie;
    private int pret_unitar_gresie;
    private int nr_buc_gresii_in_pachet;

    public PachetGresii(Dreptunghi baza, double h, int culoare, int id_pachet, Gresie gresie, int pret_unitar_gresie, int nr_buc_gresii_in_pachet) {
        super(baza, h, culoare);
        this.id_pachet = id_pachet;
        this.gresie = gresie;
        this.pret_unitar_gresie = pret_unitar_gresie;
        this.nr_buc_gresii_in_pachet = nr_buc_gresii_in_pachet;
    }

    public int getId_pachet() {
        return id_pachet;
    }

    public void setId_pachet(int id_pachet) {
        this.id_pachet = id_pachet;
    }

    public Gresie getGresie() {
        return gresie;
    }

    public void setGresie(Gresie gresie) {
        this.gresie = gresie;
    }

    public int getPret_unitar_gresie() {
        return pret_unitar_gresie;
    }

    public void setPret_unitar_gresie(int pret_unitar_gresie) {
        this.pret_unitar_gresie = pret_unitar_gresie;
    }

    public int getNr_buc_gresii_in_pachet() {
        return nr_buc_gresii_in_pachet;
    }

    public void setNr_buc_gresii_in_pachet(int nr_buc_gresii_in_pachet) {
        this.nr_buc_gresii_in_pachet = nr_buc_gresii_in_pachet;
    }

    @Override
    public String toString() {
        return "PachetGresii (" + "ID pachet = " + id_pachet + ") " + gresie + ", pret unitar gresie = " +
                pret_unitar_gresie + ", nr buc gresii in pachet = " + nr_buc_gresii_in_pachet;
    }

    public double getValoarePachet() {
        return pret_unitar_gresie * nr_buc_gresii_in_pachet;
    }

    public double getVolumPachet() {
        return gresie.getVolum() * nr_buc_gresii_in_pachet;
    }

    public double getInaltimeTotalaPachet() {
        return gresie.getH() * nr_buc_gresii_in_pachet;
    }
}
