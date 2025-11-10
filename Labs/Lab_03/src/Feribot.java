public  class Feribot extends NavaCroaziera{
    private int nrAuto;

    public Feribot(String nume, String pavilion, int nrPasageri, int nrAuto) {
        super(nume, pavilion, nrPasageri);
        if (nrAuto <= 0) {
            throw new IllegalArgumentException("numarul de pasageri trebuie sa fie pozitiv");
        }
        this.nrAuto = nrAuto;
    }


    @Override
    public void utilizare() {
        System.out.println(this.nume + " - Transport vehicule și pasageri");
    }

    @Override
    public String toString() {
        return "Feribot{" +
                "nrAuto=" + nrAuto +
                ", nrPasageri=" + nrPasageri +
                ", nume='" + nume + '\'' +
                ", pavilion='" + pavilion + '\'' +
                '}';
    }
}
