public class Cargou extends Nava{

    private int capacitateMax;
    public Cargou(String nume, String pavilion, int capacitateMax) {
        super(nume, pavilion);
        if (capacitateMax <= 0) {
            throw new IllegalArgumentException("numarul de pasageri trebuie sa fie pozitiv");
        }
        this.capacitateMax = capacitateMax;
    }

    @Override
    public void utilizare() {
        System.out.println(this.nume + " - Transport marfuri");
    }

    @Override
    public String toString() {
        return "Cargou{" +
                "capacitateMax=" + capacitateMax +
                ", nume='" + nume + '\'' +
                ", pavilion='" + pavilion + '\'' +
                '}';
    }
}
