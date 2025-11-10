public abstract class Nava {
    protected String nume;
    protected String pavilion;

    public Nava(String nume, String pavilion) {
        this.nume = nume;
        this.pavilion = pavilion;
    }

    @Override
    public String toString() {
        return "Nava: " +
                "nume = " + nume + '\'' +
                ", pavilion =" + pavilion + '\'';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPavilion() {
        return pavilion;
    }

    public void setPavilion(String pavilion) {
        this.pavilion = pavilion;
    }

    public abstract void utilizare();
}
