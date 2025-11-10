import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Firma {
    private List<IAngajat> angajati;

    public Firma() {
        angajati = new ArrayList<>();
    }

    public void adaugaAngajat(IAngajat angajat) {
        angajati.add(angajat);
    }

    public void afisareAngajat() {
        for (IAngajat angajat: angajati) {
            System.out.println(angajat.toString());
        }
    }

    public void afisareAngajati(int cum) {
        List<IAngajat> angList = new ArrayList<>(angajati);

        switch (cum) {
            case 1:
                angList.sort(ordineAlfabetica);
                break;
            case 2:
                angList.sort(dupaID);
            default:
                break;
        }

        for (IAngajat a: angList) {
            System.out.println(a.toString());
        }

    }

    public IAngajat getAngajatDupaID(int id) {
        for (IAngajat a: angajati) {
            if (a.getID() == id) {
                return a;
            }
        }
        return null;
    }

    public Comparator<IAngajat> ordineAlfabetica = new Comparator<IAngajat>() {
        @Override
        public int compare(IAngajat o1, IAngajat o2) {
            Persoana p1 = (Persoana) o1;
            Persoana p2 = (Persoana) o2;

            return p1.toString().compareTo(p2.toString());
        }
    };

    public Comparator<IAngajat> dupaID = Comparator.comparing(IAngajat::getID);


    public void citestePontaj(String numeFisier) {
        try (Scanner file = new Scanner(new File(numeFisier))) {
            while (file.hasNextInt()) {
                String linie = file.nextLine();
                String[] parti = linie.split(" ");
                IAngajat angajat = getAngajatDupaID(Integer.parseInt(parti[0]));
                angajat.setNrOreLucrate(Integer.parseInt(parti[1]));

                if (parti.length > 2) {
                    ((Vopsitor)angajat).setSuprafataVopsita(Integer.parseInt(parti[2]));
                }
            }
        } catch (Exception e) {
            System.out.println("Eroare la citire: " + e.getMessage());
        }
    }

    public double getTotalSalarii() {
        double totalSalarii = 0.0;

        for (IAngajat a : angajati) {
            totalSalarii += a.salariu();
        }
        return totalSalarii;
    }
}
