import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Firma {

    ArrayList<IAngajat> angajati = new ArrayList<>();

    // ----------------- Adăugare angajați ---------------------

    public boolean addAngajati(IAngajat a) {
        angajati.add(a);
        return true;
    }

    // ----------------- Căutare angajat după ID ----------------

    public IAngajat getAngajatDupaId(int id) {
        for (IAngajat a : angajati)
            if (a.getId() == id)
                return a;
        return null;
    }

    // ----------------- Comparatori ----------------------------

    Comparator<IAngajat> cmpID = Comparator.comparingInt(IAngajat::getId);

    Comparator<IAngajat> cmpNumePrenume = new Comparator<IAngajat>() {
        @Override
        public int compare(IAngajat a, IAngajat b) {
            Persoana pa = (Persoana) a;
            Persoana pb = (Persoana) b;

            int c = pa.getNume().compareToIgnoreCase(pb.getNume());
            if (c != 0) return c;

            return pa.getPrenume().compareToIgnoreCase(pb.getPrenume());
        }
    };

    Comparator<IAngajat> cmpProfesieNume = new Comparator<IAngajat>() {
        @Override
        public int compare(IAngajat a, IAngajat b) {
            String profA = a.getClass().getSimpleName();
            String profB = b.getClass().getSimpleName();

            int cp = profA.compareTo(profB);
            if (cp != 0) return cp;

            return cmpNumePrenume.compare(a, b);
        }
    };

    Comparator<IAngajat> cmpSalDesc = new Comparator<IAngajat>() {
        @Override
        public int compare(IAngajat a, IAngajat b) {
            return Double.compare(b.getSalariu(), a.getSalariu()); // DESC
        }
    };

    // ----------------- Afisare salarii ------------------------

    public void afiseazaSalarii(int cum) {
        switch (cum) {
            case 0: angajati.sort(cmpID); break;
            case 1: angajati.sort(cmpNumePrenume); break;
            case 2: angajati.sort(cmpProfesieNume); break;
            case 3: angajati.sort(cmpSalDesc); break;
        }

        for (IAngajat a : angajati) {
            System.out.println(a);
        }
    }

    public double getTotalSalarii() {
        double s = 0;
        for (IAngajat a : angajati)
            s += a.getSalariu();
        return s;
    }

    // ----------------- Citire angajați -------------------------

    public void citesteAngajati(Scanner sc) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) break;

            try {
                String[] p = line.split(",");
                if (p.length < 4) continue;

                String tip = p[0].trim();
                int id = Integer.parseInt(p[1].trim());
                String nume = p[2].trim();
                String prenume = p[3].trim();

                if (getAngajatDupaId(id) != null) {
                    System.out.println("Eroare la linia: \"" + line + "\". In firma exista deja un angajat cu id=" + id);
                    continue;
                }

                IAngajat ang = null;

                if (tip.equals("Inginer"))
                    ang = new Inginer(nume, prenume, id);
                else if (tip.equals("Sofer"))
                    ang = new Sofer(nume, prenume, id);

                if (ang != null)
                    angajati.add(ang);

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        System.out.println("In firma s-au angajat " + angajati.size() + " persoane");
    }

    // ----------------- Citire pontaj --------------------------

    public int citestePontaj(Scanner sc) {
        if (!sc.hasNextLine()) return -1;

        // resetăm ore + km
        for (IAngajat a : angajati) {
            a.setNrOreLucrate(0);
            if (a instanceof Sofer)
                ((Sofer) a).setKm(0);
        }

        int modSort = -1;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] p = line.split(",");

            // linie cu un singur număr → cod sortare
            if (p.length == 1) {
                try {
                    int cod = Integer.parseInt(p[0].trim());
                    if (cod >= 0 && cod <= 3) {
                        modSort = cod;

                        if (sc.hasNextLine()) sc.nextLine(); // consumă linia albă
                        return modSort;
                    }
                } catch (Exception ignored) {}
            }

            // linie pontaj angajat
            try {
                int id = Integer.parseInt(p[0].trim());

                IAngajat a = getAngajatDupaId(id);
                if (a == null) {
                    System.out.println("Eroare la linia: \"" + line + "\". Nu exista angajat cu id=" + id);
                    continue;
                }

                int ore = (p.length > 1) ? Integer.parseInt(p[1].trim()) : 0;
                double km = (p.length > 2) ? Double.parseDouble(p[2].trim()) : 0;

                a.setNrOreLucrate(ore);
                if (a instanceof Sofer)
                    ((Sofer) a).setKm(km);

            } catch (Exception e) {
                System.out.println("Eroare de formatare la linia de pontaj: \"" + line + "\"");
            }
        }

        return modSort;
    }

    // ----------------- MAIN -----------------------------------

    public static void main(String[] args) {

        Firma f = new Firma();
        Scanner sc = null;

        try {
            if (args.length > 0)
                sc = new Scanner(new File(args[0]));
            else
                sc = new Scanner(System.in);

            f.citesteAngajati(sc);

            int luna = 1;

            while (true) {
                int cum = f.citestePontaj(sc);
                if (cum == -1)
                    break;

                System.out.print("Luna: " + luna + " - ");

                switch (cum) {
                    case 0: System.out.println("se afiseaza in ordinea crescatoare a ID-urilor"); break;
                    case 1: System.out.println("se afiseaza in ordinea lexicografica a numelor si prenumelor"); break;
                    case 2: System.out.println("se afiseaza angajatii pe categorii (inginer, sofer) iar in interiorul categoriilor in ordinea lexicografica a numelor si prenumelor"); break;
                    case 3: System.out.println("se afiseaza angajatii in ordinea descrescatoare a salariilor lor"); break;
                }

                f.afiseazaSalarii(cum);
                System.out.println("Total salarii: " + f.getTotalSalarii());
                luna++;
            }

        } catch (Exception e) {
            System.out.println("Eroare: " + e);
        }
    }
}
