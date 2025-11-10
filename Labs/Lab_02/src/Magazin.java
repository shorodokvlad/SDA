import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Magazin {
    private  int nrmax;
    private PachetGresii[] pachetGresii;
    private int nrCurent;

    public Magazin(int nrmax) {
        this.nrmax = nrmax;
        this.pachetGresii = new PachetGresii[nrmax];
        this.nrCurent = 0;
    }

    public int getNrmax() {
        return nrmax;
    }

    public void setNrmax(int nrmax) {
        this.nrmax = nrmax;
    }

    public PachetGresii[] getPachetGresii() {
        return pachetGresii;
    }

    public void setPachetGresii(PachetGresii[] pachetGresii) {
        this.pachetGresii = pachetGresii;
    }

    public double getValoareTotala() {
        double suma = 0;
        for (int i = 0; i < nrCurent; i++) {
            suma += pachetGresii[i].getValoarePachet();
        }
        return suma;
    }

    public double getInaltimeTotalaPachete() {
        double inaltimeTotala = 0;
        for (int i = 0; i < nrCurent; i++) {
            inaltimeTotala += pachetGresii[i].getInaltimeTotalaPachet();
        }
        return inaltimeTotala;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Magazinul conține următoarele pachete de gresii:\n");
        for (int i = 0; i < nrCurent; i++) {
            sb.append(pachetGresii[i]).append("\n");
        }
        return sb.toString();
    }

    public boolean existaInMagazin(int id_pachet) {
        for (int i = 0; i < nrCurent; i++) {
            if (pachetGresii[i] != null && pachetGresii[i].getId_pachet() == id_pachet) {
                return true;
            }
        }
        return false;
    }

    public boolean adaugaPachetGresii(PachetGresii pachet) {
        if (existaInMagazin(pachet.getId_pachet())) {
            System.out.println("pachetul cu id-ul" + pachet.getId_pachet() + " exista deja");
        return false;
        }

        if (nrCurent < nrmax) {
            pachetGresii[nrCurent++] = pachet;
            return true;
        }
        System.out.println("Nu este loc");
        return false;
    }
    public boolean vindePachet(int id_pachet) {
        if (!existaInMagazin(id_pachet)) {
            System.out.println(" Nu există niciun pachet cu id-ul " + id_pachet + " in magazin.");
            return false;
        }
        double valoareInainte = getValoareTotala();
        double valoarePachetVandut = 0.0;

        for (int i = 0; i < nrCurent; i++) {
            if (pachetGresii[i] != null && pachetGresii[i].getId_pachet() == id_pachet) {
                // mutam toate elemetele din dreapta in stanga
                for (int j = i; j < nrCurent - 1; j++) {
                    pachetGresii[j] = pachetGresii[j + 1];
                }
                pachetGresii[--nrCurent] = null; // eliberam ultimele pozitii
                break;
            }
        }

        double valoareDupa = getValoareTotala();

        System.out.printf("Pachetul cu id %d a fost vândut (valoare %.2f lei).\n", id_pachet, valoarePachetVandut);
        System.out.printf("Valoare totală înainte: %.2f lei\n", valoareInainte);
        System.out.printf("Valoare totală după vânzare: %.2f lei\n", valoareDupa);

        return true;
    }

    public boolean adaugaDinFisier(String numeFisier) {
        boolean toateAdaugate = true;

        try(Scanner sc = new Scanner(new File(numeFisier))) {
            while (sc.hasNextLine()) {
                String linie = sc.nextLine().trim();
                if (linie.isEmpty()) continue;;

                try {
                    String parts[] = linie.split("\\s+");
                    if (parts.length != 6) {
                        System.out.println("Linie invalida" + linie);
                        toateAdaugate = false;
                        continue;
                    }

                    double lungime = Double.parseDouble(parts[0]);
                    double latime = Double.parseDouble(parts[1]);
                    double h = Double.parseDouble(parts[2]);
                    int culoare = (int) Double.parseDouble(parts[3]);
                    int pret = (int) Double.parseDouble(parts[4]);
                    int nrBuc = Integer.parseInt(parts[5]);

                    Dreptunghi baza = new Dreptunghi(lungime, latime);
                    Gresie gresie = new Gresie(baza, h, culoare);
                    PachetGresii pachet = new PachetGresii(baza, h, culoare, nrCurent + 1, gresie, pret, nrBuc);

                    if (!adaugaPachetGresii(pachet)) {
                        toateAdaugate = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("eroare la conversia datelor" + linie);
                    toateAdaugate = false;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("fisierul nu a fost gasit" + numeFisier);
            return false;
        }
        return toateAdaugate;
    }
}
