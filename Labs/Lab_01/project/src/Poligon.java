import java.util.Arrays;

public class Poligon {
    Punct varfuri[];

    public Poligon(Punct[] varfuri) {
        this.varfuri = varfuri;
    }

    @Override
    public String toString() {
        return "Poligon{" +
                "varfuri=" + Arrays.toString(varfuri) +
                '}';
    }

    public double perimetru () {
        double p = 0;

        for (int i = 0; i < varfuri.length-1; i++) {
            p += varfuri[i].distanta(varfuri[i + 1]);
        }
        return p + varfuri[varfuri.length-1].distanta(varfuri[0]);
    }
}
