package magazin;

import cutii.Paralelipiped;
import jucarii.Avion;
import jucarii.Minge;
import jucarii.Racheta;
import cutii.Cub;
import cutii.Cilindru;

import java.util.ArrayList;

public class Magazin {
    ArrayList<Pachet> listaVanzari = new ArrayList<>();

    public ArrayList <Pachet> getListaVanzari() {
        return listaVanzari;
    }

    public void afisVanzari() {
        int counter = 1;
        for (Pachet p:listaVanzari) {
            System.out.println(counter + ". " + p.toString());
            counter++;
            System.out.println(p.PretPachete());
        }
    }

    public static void main(String[] args) {
        System.out.println("\n===== Demo Pachet (1p) =====");
        Pachet p1 = new Pachet(new Minge(10), true, true);
        System.out.println(p1);
        System.out.println("Pret=" + p1.pretPachet());

        System.out.println("===== Demo Cutii (1p) =====");
        Paralelipiped paralelipiped = new Paralelipiped(10, 20, 30);
        Cub cub = new Cub(40);
        Cilindru cilindru = new Cilindru(50, 60);
        System.out.println("[" + paralelipiped.toString() + ", " + cub.toString() + ", " + cub.toString() + ", " + cilindru.toString() + "]");

        System.out.println("===== Demo Jucarii (1p) =====");
        Avion avion = new Avion(10, 20, 30);
        Minge minge = new Minge(40);
        Racheta racheta = new Racheta(10, 60);
        System.out.println("[" + avion.toString() + ", " + minge.toString() + ", " + racheta.toString() + "]");

        System.out.println("===== Demo Panglica (1p) =====");
        RolaPanglica rola = RolaPanglica.getInstance();
        System.out.println("Pentru cutia:" + paralelipiped.toString() + " necesar lung_pang=" + paralelipiped.getLungimePanglica());
        System.out.println("        dupa cumparare:" + rola.getDisponibil(paralelipiped));
        System.out.println("Pentru cutia:" + cub.toString() + " necesar lung_pang=" + cub.getLungimePanglica());
        double dispCub = rola.getDisponibil(cub);
        System.out.println("dupa cumparare:" + dispCub);
        System.out.println("Pentru cutia:" + cilindru.toString() + " necesar lung_pang=" + cilindru.getLungimePanglica());
        double dispCilindru = rola.getDisponibil(cilindru);
        FabricaCutii fabrica = new FabricaCutii();
        System.out.println("dupa cumparare:" + dispCilindru);
        System.out.println("===== Demo Fabrica de Cutii (1p) =====");
        System.out.println("Pentru jucaria:" + avion.toString());
        Object cutieAvion = fabrica.getCutie(avion);
        System.out.println("cutia:" + cutieAvion.toString());
        System.out.println("Pentru jucaria:" + minge.toString());

        Object cutieMinge = fabrica.getCutie(minge);
        System.out.println("cutia:" + cutieMinge.toString());
        System.out.println("Pentru jucaria:" + racheta.toString());

        Object cutieRacheta = fabrica.getCutie(racheta);
        System.out.println("cutia:" + cutieRacheta.toString());
        System.out.println("\n===== Demo Pachet (1p) =====");
        Pachet p2 = new Pachet(new Minge(10), true, true);
        System.out.println(p2);
        System.out.println("Pret=" + p2.PretPachete());


        System.out.println("\n===== Demo Magazin (2p) =====");
        Magazin m = new Magazin();
        ArrayList<Pachet> vanzari = m.getListaVanzari(); vanzari.add( new
                Pachet(new Minge(10), true, true) ); vanzari.add( new
                Pachet(new Minge(10), true, false) ); vanzari.add( new
                Pachet(new Minge(10), true, true) ); vanzari.add( new
                Pachet(new Minge(10), false, false) ); vanzari.add( new
                Pachet(new Racheta(10,20), false, false) ); vanzari.add( new
                Pachet(new Avion(10,20, 30), false, false) ); vanzari.add( new
                Pachet(new Avion(10,20, 30), true, false) );
        m.afisVanzari();
        System.out.println("In rola au mai ramas "+
                RolaPanglica.getRola().getDisponibil()+" cm");
    }
}