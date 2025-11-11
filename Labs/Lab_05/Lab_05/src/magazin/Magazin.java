package magazin;

import cutii.*;
import jucarii.*;

import java.io.File;
import java.util.*;

public class Magazin {

    private ArrayList<Pachet> listaVanzari = new ArrayList<>();

    public List<Pachet> getListaVanzari() {
        return listaVanzari;
    }

    public void afisVanzari() {
        System.out.println("Vanzari efectuate");
        int idx = 1;
        double suma = 0.0;
        for (Pachet p : listaVanzari) {
            System.out.println(idx + ". " + p.toString());
            System.out.println("Pret=" + p.pretPachet());
            suma += p.pretPachet();
            idx++;
        }
        System.out.println("Suma totala incasata=" + suma);
    }

    public void citesteVanzari(String numeFisier) {
        try (Scanner br = new Scanner(new File(numeFisier))) {

            String linie;

            while ((linie = br.nextLine()) != null) {

                linie = linie.trim();
                if (linie.isEmpty()) continue;

                // Exemplu linie: "Minge da DA"
                String[] parti = linie.split("\\s+");
                if (parti.length < 3) continue;

                String numeJucarie = parti[0];
                boolean cereCutie = parti[1].equalsIgnoreCase("da");
                boolean cerePanglica = parti[2].equalsIgnoreCase("da");

                // 1. Creez jucăria corespunzătoare
                Jucarie j;
                switch (numeJucarie.toLowerCase()) {
                    case "minge":
                        j = new Minge();
                        break;
                    case "racheta":
                        j = new Racheta();
                        break;
                    case "avion":
                        j = new Avion();
                        break;
                    default:
                        System.out.println("Jucărie necunoscută: " + numeJucarie);
                        continue;
                }

                // 2. Creez pachetul
                Pachet p = new Pachet(j, cereCutie, cerePanglica);

                // 5. Adaug la lista de vânzări
                listaVanzari.add(p);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Demo Cutii
        System.out.println("===== Demo Cutii (2p) =====");
        ICutie[] cutii = new ICutie[3];
        cutii[0] = new Paralelipiped(10.0, 20.0, 30.0);
        cutii[1] = new Cub(40.0);
        cutii[2] = new Cilindru(50.0, 60.0);
        System.out.println(Arrays.toString(cutii));

        // Demo Jucarii
        System.out.println("===== Demo Jucarii (2p) =====");
        Jucarie[] jucs = new Jucarie[3];
        jucs[0] = new Avion(15.0, 25.0, 35.0);
        jucs[1] = new Minge(45.0);
        jucs[2] = new Racheta(55.0, 65.0);
        System.out.println(Arrays.toString(jucs));

        // Demo Fabrica de cutii
        System.out.println("===== Demo Fabrica de cutii (1p) =====");
        for (Jucarie j : jucs) {
            ICutie c = FabricaCutii.getCutie(j);
            System.out.println("Pentru jucaria:" + j.toString() + " cutia:" + c.toString());
        }

        // Demo Panglica
        System.out.println("===== Demo Panglica (1p) =====");
        ICutie c1 = new Paralelipiped(10.0, 20.0, 30.0);
        double lung1 = c1.getLungimePanglica();
        System.out.println("Pentru cutia:" + c1.toString() + " necesar lung_panglica=:" + lung1);
        RolaPanglica.getRola().cumpara(lung1);
        System.out.println("dupa cumparare: " + RolaPanglica.getRola().toString());

        ICutie c2 = new Cub(40.0);
        double lung2 = c2.getLungimePanglica();
        System.out.println("Pentru cutia:" + c2.toString() + " necesar lung_panglica=:" + lung2);
        RolaPanglica.getRola().cumpara(lung2);
        System.out.println("dupa cumparare: " + RolaPanglica.getRola().toString());

        ICutie c3 = new Cilindru(50.0, 60.0);
        double lung3 = c3.getLungimePanglica();
        System.out.println("Pentru cutia:" + c3.toString() + " necesar lung_panglica=:" + lung3);
        RolaPanglica.getRola().cumpara(lung3);
        System.out.println("dupa cumparare: " + RolaPanglica.getRola().toString());

        // Demo Pachet
        System.out.println("===== Demo Pachet (1p) =====");
        Pachet p1 = new Pachet(new Minge(10), true, true);
        System.out.println(p1);
        System.out.println("Pret=" + p1.pretPachet());

        // Demo Magazin
        System.out.println("\n===== Demo Magazin (2p) =====");
        Magazin m = new Magazin();
        List<Pachet> vanzari = m.getListaVanzari();
        vanzari.add(new Pachet(new Minge(10), true, true));
        vanzari.add(new Pachet(new Minge(10), true, false));
        vanzari.add(new Pachet(new Minge(10), true, true));
        vanzari.add(new Pachet(new Minge(10), false, false));
        vanzari.add(new Pachet(new Racheta(10,20), false, false));
        vanzari.add(new Pachet(new Avion(10,20, 30), false, false));
        vanzari.add(new Pachet(new Avion(10,20, 30), true, false));
        m.afisVanzari();
        System.out.println("In rola au mai ramas " + RolaPanglica.getRola().getDisponibil() + " cm");
    }
}
