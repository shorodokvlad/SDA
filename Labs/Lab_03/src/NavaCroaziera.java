public  class NavaCroaziera extends Nava {
    int nrPasageri;

    public NavaCroaziera(String nume, String pavilion) {
        super(nume, pavilion);
    }

    public NavaCroaziera(String nume, String pavilion, int nrPasageri) {
        super(nume, pavilion);
        if (nrPasageri <= 0) {
            throw new IllegalArgumentException("numarul de pasageri trebuie sa fie pozitiv");
        }
        this.nrPasageri = nrPasageri;
    }

    @Override
    public void utilizare() {
            System.out.println(this.nume + " - Croaziere de lux");
    }

    @Override
    public String toString() {
        return "NavaCroaziera: " +
                "nume = " + nume  +
                ", pavilion = " + pavilion +
                ", nrPasageri = " + nrPasageri;
    }
}
