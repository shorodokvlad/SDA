import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        EcuatieGrad1 ecuatieGrad1 = new EcuatieGrad1(2, 10);
        System.out.println((ecuatieGrad1));

        ecuatieGrad1.setA(3e+5);
        double d = 255e+6;
        ecuatieGrad1.setB(-2*d);
        System.out.println("t = " + ecuatieGrad1.rezolva()/60 + " min");

        Double t = ecuatieGrad1.rezolva();
        if (t == null)
            System.out.println("ecuatie incompatibila");
        else
            System.out.println("t = " + t/60 + " min");

        Punct A = new Punct(3, 4);
        System.out.println();
        System.out.println(A);

        Punct O = new Punct();
        System.out.println(O);

        System.out.println("Distanta = " + O.distanta(A));

        Punct pcte[] = {new Punct(), new Punct(5, 0), new Punct(5, 3), new Punct(0, 3)};
        Poligon dreptunghi = new Poligon(pcte);
        System.out.println(dreptunghi);

        System.out.println("Perimetru: " + dreptunghi.perimetru());

        Punct p = new Punct("puncte.txt");
        p.afisarePuncte();
    }

    // De rezolvat: cu null
}
